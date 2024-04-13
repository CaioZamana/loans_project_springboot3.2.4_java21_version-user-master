package Santander.Loan.service.interfaces;

import Santander.Loan.model.AccountLoan;
import Santander.Loan.model.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountLoanService {

    void createAccountLoan(AccountLoan accountLoan, Customer customer
    );

    void updateAccountAgency(AccountLoan accountLoan);

    void deleteAccount(Long accountId);

    AccountLoan getAccountById(Long accountId);

    List<AccountLoan> getAllAccounts();

    void deposit(Long accountId, BigDecimal amount);


    void withdraw(Long accountId, BigDecimal amount);

    void transfer(Long sourceAccountId, Long targetAccountId, BigDecimal amount);


//    getAccountBalance: Método para obter o saldo atual de uma conta bancária.
//    getAccountStatement: Método para obter o extrato de uma conta bancária.
//    getLoansByAccount: Método para obter todos os empréstimos associados a uma conta bancária específica.
//    makeLoanPayment: Método para fazer um pagamento em um empréstimo existente.

}
