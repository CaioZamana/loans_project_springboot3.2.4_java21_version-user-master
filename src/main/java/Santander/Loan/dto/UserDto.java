package Santander.Loan.dto;

import Santander.Loan.model.Users;
import Santander.Loan.security.RoleEnum;

import java.util.HashSet;
import java.util.Set;

public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String cpf;
    private String fullName;
    private Set<RoleEnum> roles;
    private String address;
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

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
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



    //Método para converter UserDto para User Entidade
    public Users toEntity() {
        Users users = new Users();
        users.setId(this.id);
        users.setUsername(this.username);
        users.setPassword(this.password);
        users.setEmail(this.email);
        users.setCpf(this.cpf);
        users.setFullName(this.fullName);
        users.setRoles(this.roles != null ? new HashSet<>(this.roles) : null);
        users.setAddress(this.address);
        users.setTelephone(this.telephone);
        return users;
    }

    //Método para converter User Entidade para UserDto
    public static UserDto fromEntity(Users users) {
        UserDto dto = new UserDto();
        dto.setId(users.getId());
        dto.setUsername(users.getUsername());
        dto.setPassword(users.getPassword());
        dto.setEmail(users.getEmail());
        dto.setCpf(users.getCpf());
        dto.setFullName(users.getFullName());
        dto.setRoles(users.getRoles());
        dto.setAddress(users.getAddress());
        dto.setTelephone(users.getTelephone());
        return dto;
    }
}
