package Santander.Loan.dto;

import Santander.Loan.model.Funcionary;
import Santander.Loan.security.RoleEnum;

import java.util.Set;

public class FuncionaryDto {

    private String username;
    private String password;
    private String email;
    private String cpf;
    private String fullName;
    private String address;
    private String telephone;
    private String professionalRegistrationNumber;
    private Double salary;
    private Set<RoleEnum> roles;


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

    public String getProfessionalRegistrationNumber() {
        return professionalRegistrationNumber;
    }

    public void setProfessionalRegistrationNumber(String professionalRegistrationNumber) {
        this.professionalRegistrationNumber = professionalRegistrationNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }

    public Funcionary toEntity() {
        Funcionary funcionary = new Funcionary();
        funcionary.setUsername(this.username);
        funcionary.setPassword(this.password);
        funcionary.setEmail(this.email);
        funcionary.setCpf(this.cpf);
        funcionary.setFullName(this.fullName);
        funcionary.setAddress(this.address);
        funcionary.setTelephone(this.telephone);
        funcionary.setProfessionalRegistrationNumber(this.professionalRegistrationNumber);
        funcionary.setSalary(this.salary);
        funcionary.setRoles(this.roles);
        return funcionary;
    }

    //Método para converter Funcionary Entidade para FuncionaryDto
    public static FuncionaryDto fromEntity(Funcionary funcionary) {
        FuncionaryDto funcionaryDto = new FuncionaryDto();
        funcionaryDto.setUsername(funcionary.getUsername());
        funcionaryDto.setPassword(funcionary.getPassword());
        funcionaryDto.setEmail(funcionary.getEmail());
        funcionaryDto.setCpf(funcionary.getCpf());
        funcionaryDto.setFullName(funcionary.getFullName());
        funcionaryDto.setAddress(funcionary.getAddress());
        funcionaryDto.setTelephone(funcionary.getTelephone());
        funcionaryDto.setProfessionalRegistrationNumber(funcionary.getProfessionalRegistrationNumber());
        funcionaryDto.setSalary(funcionary.getSalary());
        funcionaryDto.setRoles(funcionary.getRoles());
        return funcionaryDto;
    }

}
