package Santander.Loan.model;

import Santander.Loan.Enum.LoanStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data de início do empréstimo não pode ser nula")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateStart;

    @NotNull(message = "A data de vencimento do empréstimo não pode ser nula")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Future(message = "A data de vencimento do empréstimo deve ser uma data futura")
    private LocalDate expirationDateLoan;

    @NotNull(message = "O status do empréstimo não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private LoanStatusEnum loanStatusEnum;

    @NotNull(message = "O valor do empréstimo deve ser positivo")
    @Min(value = 0, message = "O valor do empréstimo deve ser positivo")
    private double valueLoan;

    @NotNull(message = "A taxa de juros não pode ser nula")
    @DecimalMin(value = "0.0", inclusive = false, message = "A taxa de juros não pode ser negativa")
    private double interestRate;

    @OneToMany(mappedBy = "loan")
    private List<Collateral> collateral;

    @ManyToOne
    @JoinColumn(name = "loan_product_id")
    private LoanProduct loanProduct;

    @ManyToOne
    @JoinColumn(name = "funcionary_id")
    private Funcionary funcionary;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "loan")
    private List<RiskAssessment> riskAssessments;

    @OneToMany(mappedBy = "loan")
    private List<InstallmentPayment> installmentPayment;


    @OneToMany(mappedBy = "loan")
    private List<TransactionHistory> transactionHistory;



}

