package Santander.Emprestimos.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número da conta não pode estar em branco")
    @Column(unique = true, nullable = false)
    private UUID accountNumber;

    @Column(nullable = false)
    @NotBlank(message = "A agência não pode estar em branco")
    private String agency;

    @Column(nullable = false)
    @NotNull(message = "O saldo não pode estar em branco")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "customer_id") //A anotação @JoinColumn(name = "customer_id") é usada para definir uma chave estrangeira (foreign key)
    @NotNull(message = "O cliente não pode ser nulo")
    private Customer customer;

    public Account() {
    }

    public Account(UUID accountNumber, String agency, BigDecimal balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.balance = balance;
        this.customer = customer;
    }
}
