package Santander.Loan.service.interfaces;

import Santander.Loan.model.Account;
import Santander.Loan.model.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface IAccountService {

    void createAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);

    Account getAccountById(Long accountId);

    List<Account> getAllAccounts();


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
