package Santander.Emprestimos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.math.BigDecimal;

@Entity
public class Collateral {
//Atributos e anotações de mapeamento objeto relaciol ORM

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    @Column(nullable = false, length = 255)
    private String description;

    @NotNull(message = "O valor estimado não pode estar em branco")
    @DecimalMin(value = "0.0", message = "O valor estimado deve ser positivo")
    private BigDecimal estimatedValue;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    @NotNull(message = "O empréstimo não pode ser nulo")
    private Loan loan;


}
