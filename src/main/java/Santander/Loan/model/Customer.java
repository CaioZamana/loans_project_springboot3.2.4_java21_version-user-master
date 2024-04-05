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

// Relacionamento "One-to-Many":
// Neste tipo de relacionamento, um objeto desta classe (Customer) pode estar associado a vários objetos de outra classe (por exemplo, Account, Loan, TransactionHistory).
// O lado "Many" do relacionamento (por exemplo, a classe Account) terá uma coluna na tabela que armazena o identificador (ID) desta classe (Customer) para indicar a associação.
// Isso significa que cada linha na tabela de Account (ou Loan, TransactionHistory) terá um valor na coluna que faz referência ao ID deste Customer específico.
// Dessa forma, podemos recuperar todas as contas, empréstimos ou históricos de transações associados a um cliente específico facilmente usando essa coluna de referência.


    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    @OneToMany(mappedBy = "customer")
    private List<Loan> loans;
    @OneToMany(mappedBy = "customer")
    private List<TransactionHistory> transactionHistory;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
