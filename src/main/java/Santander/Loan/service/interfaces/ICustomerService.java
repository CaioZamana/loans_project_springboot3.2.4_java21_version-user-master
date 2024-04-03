package Santander.Loan.service.interfaces;

import Santander.Loan.model.Customer;

import java.util.List;

public interface ICustomerService {

    // Operações básicas de cliente
    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long customerId);

    Customer getCustomerById(Long customerId);

    List<Customer> getAllCustomers();

    // Operações de consulta de cliente

//    List<Customer> getCustomersByCreditScoreRange(Double minCreditScore, Double maxCreditScore);
//
//    List<Customer> getCustomersWithLoans();
//
//    List<Customer> getCustomersWithCreditScoreAbove(Double minCreditScore);
//
//    List<Customer> getCustomersWithCreditScoreBelow(Double maxCreditScore);



}
