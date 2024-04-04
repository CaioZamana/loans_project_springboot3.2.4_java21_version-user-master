package Santander.Loan.model;

import Santander.Loan.security.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Password é obrigatório")
    private String password;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "O E-mail é obrigatório")
    private String email;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @Column(nullable = false)
    @NotBlank(message = "O nome é obrigatório")
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

//    public void setPassword(String password) {
//        this.password = password;
//    }

    public void setPassword (String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
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
