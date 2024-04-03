package Santander.Emprestimos.service.interfaces;

import Santander.Emprestimos.model.Account;
import Santander.Emprestimos.model.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IAccountService {

    void createAccountForCustomer(Customer customer, UUID accountNumber, String agency, BigDecimal initialBalance);

    void updateAccount(Account account);

    void deleteAccount(Account account);

    Account getAccountById(Long accountId);

    List<Account> getAllAccounts();
}
