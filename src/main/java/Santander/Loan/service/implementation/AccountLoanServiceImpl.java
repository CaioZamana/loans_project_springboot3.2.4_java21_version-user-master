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
public class AccountLoanServiceImpl {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountLoanServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Transactional
    public void createAccountLoan(AccountLoan account, Customer customer) {
        if (customer == null)
            throw new BusinessException("O cliente não pode ser nulo");

        AccountLoan existingAccount = accountRepository.findByCustomer(customer);
        if (existingAccount != null)
            throw new BusinessException("Este customer já tem uma account.");

        account.setCustomer(customer);
        accountRepository.save(account);
    }


}
