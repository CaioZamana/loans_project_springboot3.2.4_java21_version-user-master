package Santander.Emprestimos.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.math.BigDecimal;
import java.util.List;

@Entity
public class LoanProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição não pode estar em braco.")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    @Column(nullable = false, length = 255)
    private String description;

    @NotNull(message = "A taxa de juros padrão não pode ser nula.")
    @DecimalMin(value = "0.0", message = "O valor da taxa de juros padrão deve ser positivo")
    @Column(nullable = false)
    private BigDecimal standardInterestRate; //Taxa de juros padrão

    @NotNull(message = "O prazo máximo não pode ser nulo")
    @Positive(message = "O prazo máximo deve ser um número positivo de meses")
    @Column(nullable = false)
    private Integer maxTermInMonths; //Prazo Máximo em meses

    @OneToMany(mappedBy = "loanProduct")
    private List<Loan> loans;

    public LoanProduct() {
    }

    public LoanProduct(String description, BigDecimal standardInterestRate, Integer maxTermInMonths, List<Loan> loans) {
        this.description = description;
        this.standardInterestRate = standardInterestRate;
        this.maxTermInMonths = maxTermInMonths;
        this.loans = loans;
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

    public BigDecimal getStandardInterestRate() {
        return standardInterestRate;
    }

    public void setStandardInterestRate(BigDecimal standardInterestRate) {
        this.standardInterestRate = standardInterestRate;
    }

    public Integer getMaxTermInMonths() {
        return maxTermInMonths;
    }

    public void setMaxTermInMonths(Integer maxTermInMonths) {
        this.maxTermInMonths = maxTermInMonths;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "LoanProduct{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", standardInterestRate=" + standardInterestRate +
                ", maxTermInMonths=" + maxTermInMonths +
                ", loans=" + loans +
                '}';
    }
}