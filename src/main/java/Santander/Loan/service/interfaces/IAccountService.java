package Santander.Loan.service.interfaces;

import Santander.Loan.model.Account;
import Santander.Loan.model.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface IAccountService {

    void createAccountForCustomer(Customer customer, UUID accountNumber, String agency, BigDecimal initialBalance);

    void updateAccount(Account account);

    void deleteAccount(Account account);

    Account getAccountById(Long accountId);

    List<Account> getAllAccounts();
}
