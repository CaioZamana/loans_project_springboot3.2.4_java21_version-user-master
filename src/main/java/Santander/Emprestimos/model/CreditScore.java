package Santander.Emprestimos.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class CreditScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A pontuação não pode ser nula")
    private Double score;

    @NotBlank(message = "A descrição não pode estar em branco")
    private String description;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    @NotBlank(message = "A data de emissão é obrigatória")
    private LocalDate dateIssued; //Data de Emissão

    @Column(nullable = false, unique = true)
    private UUID reportNumber = UUID.randomUUID(); //único gerado atuomaticamente

    public CreditScore() {
    }

    public CreditScore(Double score, String description, Customer customer) {
        this.score = score;
        this.description = description;
        this.customer = customer;
    }

}