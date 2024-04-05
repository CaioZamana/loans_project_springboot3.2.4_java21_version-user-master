package Santander.Loan.dto;

import Santander.Loan.model.AccountLoan;
import Santander.Loan.model.Customer;

import java.math.BigDecimal;

public class AccountLoanDto {
    private String agency;
    private BigDecimal balance;


    //Método AccountLoanController fromEntity para transformar Entidade em Dto
    public AccountLoanDto fromEntity(AccountLoan accountLoan){
        AccountLoanDto accountLoanDto = new AccountLoanDto();
        accountLoanDto.setAgency(accountLoan.getAgency());
        accountLoanDto.setBalance(accountLoan.getBalance());
        return accountLoanDto;
    }

    //método AccountLoan toEntity para transformar Dto em Entidade
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


}
