package Santander.Loan.model;

import Santander.Loan.security.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import lombok.*;

import java.util.List;
import java.util.Set;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username é obrigartório")
    @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$", message = "O username deve conter apenas letras, números ou underscores e ter entre 4 e 16 caracteres")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Password é obrigatório")
//    @Size(min = 8, max = 30, message = "O tamanho da senha deve ter entre 8 e 30 caracteres")
    private String password;

//    @NotBlank(message = "Confirmação de senha é obrigatória")
//    private String confirmPassword;
    @Column(unique = true, nullable = false)
    @NotBlank(message = "O E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @Column(unique = true, nullable = false)
    @CPF(message = "CPF inválido")
    private String cpf;

    @Column(nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
    private String fullName;

    @Column(nullable = false)
    @NotEmpty(message = "A lista de papéis não pode estar vazia")
    @Enumerated(EnumType.STRING)
    private List<RoleEnum> roles;

    @Column(nullable = false)
    @NotBlank(message = "Endereço é obrigatório")
    private String address;

    @Column(nullable = false)
    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp="\\d{10,11}", message="A informação do telefone deve conter apenas 10 ou 11 dígitos numéricos consecutivos, incluindo o DDD") // Validação de padrão para 10 ou 11 dígitos numéricos
    private String telephone;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", fullName='" + fullName + '\'' +
                ", roles=" + roles +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
