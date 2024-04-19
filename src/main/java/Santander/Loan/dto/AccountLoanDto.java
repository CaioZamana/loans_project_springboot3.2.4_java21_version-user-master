package Santander.Loan.dto;

import Santander.Loan.model.AccountLoan;
import Santander.Loan.model.Customer;

import java.math.BigDecimal;

public class AccountLoanDto {
    private Long id;
    private String agency;
    private BigDecimal balance;


    //Método AccountLoanController fromEntity para transformar Entidade em Dto
    //to get
    public static AccountLoanDto fromEntity(AccountLoan accountLoan){
        AccountLoanDto accountLoanDto = new AccountLoanDto();
        accountLoanDto.setAgency(accountLoan.getAgency());
        accountLoanDto.setBalance(accountLoan.getBalance());
        accountLoanDto.setId(accountLoan.getId());
        return accountLoanDto;
    }

    //método AccountLoan toEntity para transformar Dto em Entidade
    //to create
    public AccountLoan toEntity(){
        AccountLoan accountLoan = new AccountLoan();
        accountLoan.setAgency(this.agency);
        accountLoan.setBalance(this.balance);
        return accountLoan;
    }
    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
