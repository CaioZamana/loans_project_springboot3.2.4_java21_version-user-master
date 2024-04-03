package Santander.Emprestimos.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "A data e hora da transação não podem ser nulas")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") // Formato ISO 8601
    private LocalDateTime dateTime;

    @Positive(message = "O valor do histórico de transação deve ser positivo")
    @NotNull(message = "O valor da transação não pode ser nulo")
    private BigDecimal valueTransaction;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    @NotNull(message = "O empréstimo não pode ser nulo")
    private Loan loan;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public TransactionHistory() {
    }

    public TransactionHistory(String description, LocalDateTime dateTime, BigDecimal valueTransaction, Loan loan) {
        this.description = description;
        this.dateTime = dateTime;
        this.valueTransaction = valueTransaction;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getValue() {
        return valueTransaction;
    }

    public void setValue(BigDecimal valueTransaction) {
        this.valueTransaction = valueTransaction;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", value=" + valueTransaction +
                ", loan=" + loan +
                '}';
    }
}
