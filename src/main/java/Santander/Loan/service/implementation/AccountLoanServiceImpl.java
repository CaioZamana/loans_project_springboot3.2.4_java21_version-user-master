package Santander.Loan.service.implementation;

import Santander.Loan.exception.serviceexception.BusinessException;
import Santander.Loan.model.AccountLoan;
import Santander.Loan.model.Customer;
import Santander.Loan.reposiroty.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class AccountLoanServiceImpl {

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
}
