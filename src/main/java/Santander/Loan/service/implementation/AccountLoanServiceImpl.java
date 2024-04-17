package Santander.Loan.service.implementation;

import Santander.Loan.exception.exceptionservice.BusinessException;
import Santander.Loan.model.AccountLoan;
import Santander.Loan.model.Customer;
import Santander.Loan.reposiroty.AccountRepository;
import Santander.Loan.service.interfaces.IAccountLoanService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class AccountLoanServiceImpl implements IAccountLoanService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountLoanServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Transactional
    public void createAccountLoan(AccountLoan account, Customer customer) {
        if (customer == null)
            throw new BusinessException("Cliente com id: '" + customer + "' não encontrado.");

        AccountLoan existingAccount = accountRepository.findByCustomer(customer);
        if (existingAccount != null)
            throw new BusinessException("Este customer já tem uma account.");

        account.setCustomer(customer);
        accountRepository.save(account);
    }

    public AccountLoan getAccountById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new BusinessException("Account com ID '" + accountId + "' não foi encontrado."));
    }

    public List<AccountLoan> getAllAccounts() {
        List<AccountLoan> listAccounts = accountRepository.findAll();
        if (listAccounts.isEmpty()) {
            throw new BusinessException("A lista de accounts está vazia.");
        }
        return listAccounts;
    }

    public void deleteAccount(Long accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new BusinessException("Account com ID '" + accountId + "' não encontrada");
        }
        accountRepository.deleteById(accountId);
    }

    public void updateAccountAgency(AccountLoan accountLoan) {
        try {
            AccountLoan existingAccount = accountRepository.findById(accountLoan.getId())
                    .orElseThrow(() -> new BusinessException("Account não encontrada."));
            existingAccount.setAgency(accountLoan.getAgency());
            accountRepository.save(existingAccount);
        } catch (Exception e) {
            throw new BusinessException("Erro ao atualizar account. Contém campo inválido. Mensagem do erro: " + e.getMessage());
        }
    }

    @Transactional
    public void deposit(Long accountId, BigDecimal amount){
   //   if(amount.compareTo(BigDecimal.ZERO) <= 0) {
        if(amount.signum() <= 0) { //(sinal) signum retorna -1, 0 ou 1 para negativo, zero e positivo
            throw new BusinessException("O valor do depósito deve ser maior que zero.");
        }
        AccountLoan account = accountRepository.findById(accountId)
                .orElseThrow(() -> new BusinessException("Conta com ID '" + accountId + "' não encontrada."));

        BigDecimal currentBalance = account.getBalance();
        BigDecimal newBalance = currentBalance.add(amount);
        account.setBalance(newBalance);
    }

    @Transactional
    public void withdraw(Long accountId, BigDecimal amount){
        if(amount.signum() <= 0 ){
            throw new BusinessException ("Saldo inválido.");
        }
        AccountLoan account = accountRepository.findById(accountId)
                .orElseThrow(()-> new BusinessException("Conta com ID '" + accountId + "' não encontrada."));

        BigDecimal currentBalance = account.getBalance();
        BigDecimal newBalance = currentBalance.subtract(amount);
        account.setBalance(newBalance);
    }

    @Transactional
    public void transfer(Long sourceAccountId, Long targetAccountId, BigDecimal amount){
        if(amount.signum() <= 0){
            throw new BusinessException("O valor da transferência deve ser maior do que zero.");
        }

        AccountLoan sourceAccount = accountRepository.findById(sourceAccountId)
                .orElseThrow(() -> new BusinessException("A conta de origem com o Id '" + sourceAccountId + "' não foi encontrada."));
        AccountLoan targetAccount = accountRepository.findById(targetAccountId)
                .orElseThrow(() -> new BusinessException("A conta de destino com o Id '" + targetAccountId + "' não foi encontrada."));

        BigDecimal sourceCurrentBalance = sourceAccount.getBalance();
        BigDecimal sourceNewBalance = sourceCurrentBalance.subtract(amount);
        if (sourceNewBalance.signum() <= 0) {
            throw new BusinessException("Saldo insuficiente na conta de origem.");
        }
        sourceAccount.setBalance(sourceNewBalance);
        BigDecimal targetCurrentBalance = targetAccount.getBalance();
        BigDecimal targetNewBalance = targetCurrentBalance.add(amount);
        targetAccount.setBalance(targetNewBalance);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }
}
