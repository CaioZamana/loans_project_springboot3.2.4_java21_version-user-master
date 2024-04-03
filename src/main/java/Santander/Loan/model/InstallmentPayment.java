package Santander.Loan.model;

import Santander.Loan.Enum.InstallmentStatusEnum;
import Santander.Loan.Enum.PaymentEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class InstallmentPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O número de parcelas não pode ser nulo.")
    @Size(min = 1, max = 48, message = "O número de parcelas deve ser entre 1 e 48.")
    @Column(nullable = false)
    private Integer numberOfInstallment;

    @Positive(message = "O valor da parcela deve ser positivo.")
    private BigDecimal valueOfInstallment;

    @NotNull(message = "A data de vencimento da parcela não pode ser nula.")
    @Future(message = "A data de vencimento da parcela deve ser no futuro.")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate expirationDateInstallment;

    @NotNull(message = "O status do empréstimo não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private InstallmentStatusEnum installmentStatusEnum;

    @Positive(message = "O valor da parcela deve ser positivo.")
    private Double valuePaid;

    @NotNull(message = "A data de vencimento não pode ser nula.")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentEnum paymentEnum;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    @NotNull(message = "O empréstimo não pode ser nulo.")
    private Loan loan;


    public InstallmentPayment() {
    }

    public InstallmentPayment(Integer numberOfInstallment, BigDecimal valueOfInstallment, LocalDate expirationDateInstallment, InstallmentStatusEnum installmentStatusEnum, Double valuePaid, LocalDate paymentDate, PaymentEnum paymentEnum, Loan loan) {
        this.numberOfInstallment = numberOfInstallment;
        this.valueOfInstallment = valueOfInstallment;
        this.expirationDateInstallment = expirationDateInstallment;
        this.installmentStatusEnum = installmentStatusEnum;
        this.valuePaid = valuePaid;
        this.paymentDate = paymentDate;
        this.paymentEnum = paymentEnum;
        this.loan = loan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfInstallment() {
        return numberOfInstallment;
    }

    public void setNumberOfInstallment(Integer numberOfInstallment) {
        this.numberOfInstallment = numberOfInstallment;
    }

    public BigDecimal getValueOfInstallment() {
        return valueOfInstallment;
    }

    public void setValueOfInstallment(BigDecimal valueOfInstallment) {
        this.valueOfInstallment = valueOfInstallment;
    }

    public LocalDate getExpirationDateInstallment() {
        return expirationDateInstallment;
    }

    public void setExpirationDateInstallment(LocalDate expirationDateInstallment) {
        this.expirationDateInstallment = expirationDateInstallment;
    }

    public InstallmentStatusEnum getInstallmentStatusEnum() {
        return installmentStatusEnum;
    }

    public void setInstallmentStatusEnum(InstallmentStatusEnum installmentStatusEnum) {
        this.installmentStatusEnum = installmentStatusEnum;
    }

    public Double getValuePaid() {
        return valuePaid;
    }

    public void setValuePaid(Double valuePaid) {
        this.valuePaid = valuePaid;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentEnum getPaymentEnum() {
        return paymentEnum;
    }

    public void setPaymentEnum(PaymentEnum paymentEnum) {
        this.paymentEnum = paymentEnum;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "InstallmentPayment{" +
                "id=" + id +
                ", numberOfInstallment=" + numberOfInstallment +
                ", valueOfInstallment=" + valueOfInstallment +
                ", expirationDateInstallment=" + expirationDateInstallment +
                ", installmentStatusEnum=" + installmentStatusEnum +
                ", valuePaid=" + valuePaid +
                ", paymentDate=" + paymentDate +
                ", paymentEnum=" + paymentEnum +
                ", loan=" + loan +
                '}';
    }
}

