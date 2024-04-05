package Santander.Loan.controller;


import Santander.Loan.dto.AccountLoanDto;
import Santander.Loan.exception.serviceexception.BusinessException;
import Santander.Loan.model.AccountLoan;
import Santander.Loan.model.Customer;
import Santander.Loan.service.implementation.AccountLoanServiceImpl;
import Santander.Loan.service.implementation.CustomerServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/accounts")
@Tag(name = "Accounts Controller", description = "RESTful API for managing accounts.")
public class AccountLoanController {
    private final AccountLoanServiceImpl accountLoanServiceImpl;
    private final CustomerServiceImpl customerServiceImpl; // Injeção de dependência do serviço de Customer

    public AccountLoanController(AccountLoanServiceImpl accountLoanServiceImpl, CustomerServiceImpl customerServiceImpl) {
        this.accountLoanServiceImpl = accountLoanServiceImpl;
        this.customerServiceImpl = customerServiceImpl;
    }

    @PostMapping("/post/{customerId}")
    public ResponseEntity<String> createAccountLoan(@PathVariable Long customerId, @RequestBody AccountLoanDto accountLoanDto) {

            // Carrega o cliente correspondente ao customerId do banco de dados
            Customer customer = customerServiceImpl.getCustomerById(customerId);

            // Verifica se o cliente foi encontrado
            if (customer == null) {
                return ResponseEntity.badRequest().body("Cliente não encontrado para o ID fornecido: " + customerId);
            }

            // Cria uma nova conta de empréstimo com os dados do DTO
            AccountLoan accountLoan = new AccountLoan();
            accountLoan.setBalance(accountLoanDto.getBalance());
            accountLoan.setAgency(accountLoanDto.getAgency());
            // Outros setters para configurar a conta de empréstimo

            // Chama o serviço para criar a conta de empréstimo associada ao cliente com o ID fornecido
            accountLoanServiceImpl.createAccountLoan(accountLoan, customer);

            // Retorna uma resposta de sucesso
            return ResponseEntity.ok("Conta de empréstimo criada com sucesso.");

    }
}