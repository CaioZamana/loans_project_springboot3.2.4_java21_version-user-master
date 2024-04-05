package Santander.Loan.model;

import Santander.Loan.Enum.AccountTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID em sequência
    private Long id;

    @Enumerated(EnumType.STRING)
    private AccountTypeEnum accountType;

    @Column(unique = true, nullable = false)
    private Long accountNumber; // Número de conta

    @Column(nullable = false)
    @NotBlank(message = "A agência não pode estar em branco")
    private String agency;

    @Column(nullable = false, precision = 15, scale = 2)
    @NotNull(message = "O saldo não pode ser nulo")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "customer_id") // Nome da coluna na tabela Accounts
    private Customer customer;

    // Getters e setters
}
