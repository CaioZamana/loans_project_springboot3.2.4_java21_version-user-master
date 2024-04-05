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
    @JoinColumn(name = "credit_score_id")
    private CreditScore creditScore;

    //Relacionamentos "One to Many" mostram as colunas na tabela do many
    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    @OneToMany(mappedBy = "customer")
    private List<Loan> loans;
    @OneToMany(mappedBy = "customer")
    private List<TransactionHistory> transactionHistory;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
