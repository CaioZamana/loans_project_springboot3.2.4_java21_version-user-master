package Santander.Emprestimos.model;

import Santander.Emprestimos.security.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class Funcionary extends Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "O salário é obrigatório")
    private Double salary;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O número de registro é obrigatório")
    private String professionalRegistrationNumber;

    public Funcionary(String username, String password, String email, String cpf, String fullName, Set<RoleEnum> roles, String address, String telephone, Long id, Double salary, String professionalRegistrationNumber) {
        super(username, password, email, cpf, fullName, roles, address, telephone);
        this.id = id;
        this.salary = salary;
        this.professionalRegistrationNumber = professionalRegistrationNumber;
    }

    public Funcionary() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getProfessionalRegistrationNumber() {
        return professionalRegistrationNumber;
    }

    public void setProfessionalRegistrationNumber(String professionalRegistrationNumber) {
        this.professionalRegistrationNumber = professionalRegistrationNumber;
    }
}
