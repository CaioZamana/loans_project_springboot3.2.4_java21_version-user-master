package Santander.Loan.service.implementation;

import Santander.Loan.exception.serviceexception.BusinessException;
import Santander.Loan.model.Account;
import Santander.Loan.model.Customer;
import Santander.Loan.reposiroty.AccountRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Transactional
    public void createAccount(Account account, Customer customer) {
        if(customer ==null) {
        throw new BusinessException("Customer não pode ser nulo");
        }
        if (account.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException("O saldo da conta não pode ser negativo");
        }
        if (account.getAccountNumber() == null || account.getAccountNumber() <= 0) {
            throw new BusinessException("O número da conta é inválido");
        }
        if (account.getAgency() == null || account.getAgency().isEmpty()) {
            throw new BusinessException("A agência não pode estar vazia");
        }

        accountRepository.save(account);
    }
}
