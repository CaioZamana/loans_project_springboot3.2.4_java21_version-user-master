package Santander.Loan.controller;


import Santander.Loan.dto.AccountLoanDto;
import Santander.Loan.exception.exceptionservice.BusinessException;
import Santander.Loan.model.AccountLoan;
import Santander.Loan.model.Customer;
import Santander.Loan.service.implementation.AccountLoanServiceImpl;
import Santander.Loan.service.implementation.CustomerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/accounts")
@Tag(name = "Accounts Controller", description = "RESTful API for managing accounts.")
public class AccountLoanController {
    private final AccountLoanServiceImpl accountLoanServiceImpl;
    private final CustomerServiceImpl customerServiceImpl; // Injeção de dependência do serviço de Customer

    @Autowired
    public AccountLoanController(AccountLoanServiceImpl accountLoanServiceImpl, CustomerServiceImpl customerServiceImpl) {
        this.accountLoanServiceImpl = accountLoanServiceImpl;
        this.customerServiceImpl = customerServiceImpl;
    }

    @PostMapping("/post/{customerId}")
    @Operation(summary = "Create new Account.", description = "Create a new account for an Customer.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account for customer create successfully."),
            @ApiResponse(responseCode = "422", description = "Validation failed. Please check the provided fields.")
    })
    public ResponseEntity<String> createAccountLoan(@PathVariable Long customerId, @RequestBody AccountLoanDto accountLoanDto) {

        Customer customer = customerServiceImpl.getCustomerById(customerId);
        AccountLoan accountLoan = accountLoanDto.toEntity();
        accountLoanServiceImpl.createAccountLoan(accountLoan, customer);
        return ResponseEntity.ok("Conta de empréstimo criada com sucesso.");

    }


    @GetMapping("/get/{accountId}")
    @Operation(summary = "Get a account by ID.", description = "Retrieves an account's information based on the provided ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account found and returned successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    public ResponseEntity<AccountLoanDto> getAccountById(@PathVariable Long accountId) {
        AccountLoan accountLoan = accountLoanServiceImpl.getAccountById(accountId);
        AccountLoanDto accountLoanDto = AccountLoanDto.fromEntity(accountLoan);
        return ResponseEntity.ok(accountLoanDto);
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all accounts.", description = "Retrieves a list of accounts.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation sucessful.")
    })
    ResponseEntity<List<AccountLoanDto>> getAllAccounts() {
        List<AccountLoanDto> accountLoanDtoList = accountLoanServiceImpl.getAllAccounts().stream()
                .map(AccountLoanDto::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(accountLoanDtoList);

    }

    @DeleteMapping("/delete/{accountId}")
    public ResponseEntity<String> deleteAccountLoan(@PathVariable Long accountId){
        accountLoanServiceImpl.deleteAccount(accountId);
        return ResponseEntity.ok("Account '" + accountId + "' deletada com sucesso.");

    }

}