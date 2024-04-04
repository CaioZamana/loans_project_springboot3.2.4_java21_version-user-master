package Santander.Loan.model;

import Santander.Loan.security.RoleEnum;
import jakarta.persistence.*;
//import lombok.*;

import java.util.List;

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

    public Customer() {
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


