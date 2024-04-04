package Santander.Loan.controller;



import Santander.Loan.dto.CustomerDto;
import Santander.Loan.exception.serviceexception.BusinessException;
import Santander.Loan.model.Customer;
import Santander.Loan.service.implementation.CustomerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
@RequestMapping("/customers")
@Tag(name = "Customer Controller", description = "RESTful API for managing customer.")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    @Autowired
    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @PostMapping("/post")
    @Operation(summary = "Create new customer.", description = "Create a new customer and return 'Cliente criado com sucesso'.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer create successfully."),
            @ApiResponse(responseCode = "422", description = "Invalid customer data provided.")
    })
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDto customerDto) {
        customerServiceImpl.createCustomer(customerDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer criado com sucesso.");
    }



    @DeleteMapping("/{customerId}")
    @Operation(summary ="Delete a customer.", description = "Delete and existing customer based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully."),
            @ApiResponse(responseCode = "404", description = "User not found.")

    })
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
        customerServiceImpl.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer deletado com sucesso.");
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all customer.", description = "Retrieve a list of all registered customers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful.")
    })
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
    //GET ALL Utilizando streams e map

        List<Customer> customers = customerServiceImpl.getAllCustomers();
        List<CustomerDto> customerDtoList = customers.stream()
                .map(CustomerDto::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerDtoList);
    }
    @GetMapping("/get/{customerId}")
    @Operation(summary = "Get a customer by ID.", description = "Retrieve a specific customer based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful."),
            @ApiResponse(responseCode = "404", description = "Customer not found.")
    })
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerServiceImpl.getCustomerById(customerId);
        CustomerDto customerDto = CustomerDto.fromEntity(customer);
        return ResponseEntity.ok(customerDto);
    }


    @PutMapping("/update/{customerId}")
    @Operation(summary = "Update a customer.", description = "Update the data of and existing customer based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer updated successfully."),
            @ApiResponse(responseCode = "404", description = "Customer not found."),
            @ApiResponse(responseCode = "422", description = "Invalid customer data provided.")
    })
    public ResponseEntity<String> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {

            Customer updatedCustomer = customerDto.toEntity(); // Converter CustomerDto para Customer
            updatedCustomer.setId(customerId); // Define o ID do cliente

            customerServiceImpl.updateCustomer(updatedCustomer);

            return ResponseEntity.ok().body("Cliente atualizado com sucesso.");

    }
}
