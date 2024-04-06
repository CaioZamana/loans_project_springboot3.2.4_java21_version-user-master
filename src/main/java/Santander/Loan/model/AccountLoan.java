package Santander.Loan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
public class AccountLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID em sequência
    private Long acconutId;

    @Column(nullable = false)
    @NotBlank(message = "A agência não pode estar em branco")
    private String agency;

    @Column(nullable = false, precision = 15, scale = 2)
    @NotNull(message = "O saldo não pode ser nulo")
    @DecimalMin(value = "0", message = "O saldo da conta não pode ser negativo")
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "customer_id") // Nome da coluna na tabela Accounts
    private Customer customer;

    public Long getId() {
        return acconutId;
    }

    public void setId(Long id) {
        this.acconutId = id;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
