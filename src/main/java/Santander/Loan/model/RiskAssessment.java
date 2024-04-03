package Santander.Loan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class RiskAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição não pode estar em branco.")
    @Size(max = 255, message = "A descrição não pode ter mais do que 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String description;

    @NotNull(message = "O level do risco não pode ser nulo.")
    @Positive
    @DecimalMax(value = "10.0", message = "O valor máximo deve ser 10.0")
    @Column(nullable = false)
    private Double riskLevel;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    @NotNull(message = "O empréstimo não pode ser nulo.")
    private Loan loan;


    public RiskAssessment() {
    }

    public RiskAssessment(String description, Double riskLevel, Loan loan) {
        this.description = description;
        this.riskLevel = riskLevel;
        this.loan = loan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Double riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "RiskAssessment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", riskLevel=" + riskLevel +
                ", loan=" + loan +
                '}';
    }
}