package Santander.Loan.service.interfaces;

import Santander.Loan.model.AccountLoan;
import Santander.Loan.model.Customer;

import java.util.List;

public interface IAccountLoanService {

    void createAccountLoan(AccountLoan accountLoan, Customer customer
    );

    void updateAccountAgency(AccountLoan accountLoan);

    void deleteAccount(AccountLoan accountLoan);

    AccountLoan getAccountById(Long accountId);

    List<AccountLoan> getAllAccounts();


//    deposit: Método para realizar um depósito em uma conta bancária.
//
//    withdraw: Método para realizar um saque de uma conta bancária.
//
//    transfer: Método para transferir fundos entre duas contas bancárias.
//
//    getAccountBalance: Método para obter o saldo atual de uma conta bancária.
//
//    getAccountStatement: Método para obter o extrato de uma conta bancária.
//    getLoansByAccount: Método para obter todos os empréstimos associados a uma conta bancária específica.
//    makeLoanPayment: Método para fazer um pagamento em um empréstimo existente.

}
