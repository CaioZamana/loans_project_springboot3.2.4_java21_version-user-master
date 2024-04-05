package Santander.Loan.service.implementation;

import Santander.Loan.exception.serviceexception.BusinessException;
import Santander.Loan.model.AccountLoan;
import Santander.Loan.model.Customer;
import Santander.Loan.reposiroty.AccountRepository;
import jakarta.transaction.Transactional;
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
    public void createAccount(AccountLoan account, Customer customer) {
        if(customer ==null) {
        throw new BusinessException("Customer não pode ser nulo");
        }
        if (account.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException("O saldo da conta não pode ser negativo");
        }
        if (account.getAgency() == null || account.getAgency().isEmpty()) {
            throw new BusinessException("A agência não pode estar vazia");
        }
        account.setCustomer(customer);
        accountRepository.save(account);
    }


}
