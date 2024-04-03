package Santander.Emprestimos.dto;

//import lombok.*;
import Santander.Emprestimos.model.Customer;

import java.time.LocalDate;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class CustomerDto {

    // Atributos da classe User

    private String username;
    private String password;
    private String email;
    private String cpf;
    private String fullName;
    private String address;
    private String telephone;



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

    // Método para converter de Customer para CustomerDto
    public static CustomerDto fromEntity(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setUsername(customer.getUsername());
        customerDto.setPassword(customer.getPassword());
        customerDto.setEmail(customer.getEmail());
        customerDto.setCpf(customer.getCpf());
        customerDto.setFullName(customer.getFullName());
        customerDto.setAddress(customer.getAddress());
        customerDto.setTelephone(customer.getTelephone());
        return customerDto;
    }

    // Método para converter de CustomerDto para Customer
    public Customer toEntity() {
        Customer customer = new Customer();
        customer.setUsername(this.getUsername());
        customer.setPassword(this.getPassword());
        customer.setEmail(this.getEmail());
        customer.setCpf(this.getCpf());
        customer.setFullName(this.getFullName());
        customer.setAddress(this.getAddress());
        customer.setTelephone(this.getTelephone());
        return customer;
    }


}
