package Santander.Emprestimos.model;

import Santander.Emprestimos.security.RoleEnum;
import jakarta.persistence.*;
//import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

//@EqualsAndHashCode(callSuper = true)
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Customer extends Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "credit_score_id") // Nome da coluna na tabela Customer
    private CreditScore creditScore;

    @OneToMany(mappedBy = "customer")
    private List<Loan> loans;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    @OneToMany(mappedBy = "customer")
    private List<TransactionHistory> transactionHistory;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public Customer(){}

    public Customer(String username, String password, String email, String cpf, String fullName, Set<RoleEnum> roles, String address, String telephone, CreditScore creditScore, List<Loan> loans, List<Account> accounts, List<TransactionHistory> transactionHistory) {
        super(username, password, email, cpf, fullName, roles, address, telephone);
        this.creditScore = creditScore;
        this.loans = loans;
        this.accounts = accounts;
        this.transactionHistory = transactionHistory;
    }

    public Customer(CreditScore creditScore, List<Loan> loans, List<Account> accounts, List<TransactionHistory> transactionHistory) {
        this.creditScore = creditScore;
        this.loans = loans;
        this.accounts = accounts;
        this.transactionHistory = transactionHistory;
    }

    public Customer(String username, String password, String email, String cpf, String fullName, Set<RoleEnum> roles, String address, String telephone, Long id, CreditScore creditScore, List<Loan> loans, List<Account> accounts, List<TransactionHistory> transactionHistory, RoleEnum role) {
        super(username, password, email, cpf, fullName, roles, address, telephone);
        this.id = id;
        this.creditScore = creditScore;
        this.loans = loans;
        this.accounts = accounts;
        this.transactionHistory = transactionHistory;
        this.role = role;
    }

    public CreditScore getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(CreditScore creditScore) {
        this.creditScore = creditScore;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<TransactionHistory> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<TransactionHistory> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}


