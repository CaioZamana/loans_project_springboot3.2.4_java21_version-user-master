//package Santander.Emprestimos.controller;
//
//import Santander.Emprestimos.dto.CustomerDto;
//import Santander.Emprestimos.dto.UserDto;
//import Santander.Emprestimos.exception.NotFoundException;
//import Santander.Emprestimos.model.Customer;
//import Santander.Emprestimos.model.Users;
//import Santander.Emprestimos.service.interfaces.ICustomerService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
////import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
////@PreAuthorize("permitAll")
//@RequestMapping("/customers")
//public class CustomerController {
//
//    private final ICustomerService customerService;
//
//    @Autowired
//    public CustomerController(ICustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping("/{customerId}")
//    @Operation(summary = "Get a customer by ID", description = "Retrieve a specific customer based on its ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Operation successful"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")
//    })
//    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long customerId) {
//        Customer customer = customerService.getCustomerById(customerId);
//        CustomerDto customerDto = new CustomerDto(customer);
//        return ResponseEntity.ok(customerDto);
//    }
//
//    @GetMapping("/username/{username}")
//    @Operation(summary = "Get a customer by username", description = "Retrieve a specific customer based on its ursername")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Operation successful"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")
//    })
//
//    public ResponseEntity<CustomerDto> getCustomerByUsername(@PathVariable String username) {
//        Customer customer = customerService.getCustomerByUsername(username);
//        CustomerDto customerDto = new CustomerDto(customer);
//        return ResponseEntity.ok(customerDto);
//    }
//
//    @GetMapping("/email/{email}")
//    @Operation(summary = "Get a customer by e-mail", description = "Retrieve a specific customer based on its e-mail")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Operation successful"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")
//    })
//    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email) {
//        Customer customer = customerService.getCustomerByEmail(email);
//        CustomerDto customerDto = new CustomerDto(customer);
//        return ResponseEntity.ok(customerDto);
//    }
//
//    @GetMapping("/get-all")
//    @Operation(summary = "Get all customer", description = "Retrieve a list of all registered customers")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Operation successful")
//    })
//    public ResponseEntity<List<CustomerDto>> getAllUsers() {
//        // Recupera a lista de usuários do serviço
//        List<Customer> customers = customerService.getAllCustomers();
//
//        // Mapeia os usuários para DTOs usando stream e Collectors.toList()
//        List<CustomerDto> customerDtos = customers.stream()
//                .map(CustomerDto::fromEntity)
//                .collect(Collectors.toList());
//
//        // Retorna uma ResponseEntity com a lista de DTOs de usuários e status 200 OK
//        return ResponseEntity.ok(customerDtos);
//    }
//
//    @PostMapping("/post")
////    @PreAuthorize("permitAll")
//
//    @Operation(summary = "Create new customer", description = "Create a new customer and return 'Cliente criado com sucesso'")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Customer create successfully"),
//            @ApiResponse(responseCode = "422", description = "Invalid customer data provided")
//    })
//    public ResponseEntity<String> createCustomer(@RequestBody CustomerDto customerDto) {
//        try {
//            Customer customer = customerDto.toEntity();
//            customerService.createCustomer(customer);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente criado com sucesso!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//
//    @PutMapping("/{customerId}")
//    @Operation(summary = "Update a customer", description = "Update the data of and existing customer based on its ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Customer updated successfully"),
//            @ApiResponse(responseCode = "404", description = "Customer not found"),
//            @ApiResponse(responseCode = "422", description = "Invalid customer data provided")
//    })
//    public ResponseEntity<String> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {
//        try {
//            Customer customer = customerDto.toEntity();
//            customer.setId(customerId);
//            customerService.updateCustomer(customer);
//            return ResponseEntity.ok("Cliente atualizado com sucesso!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//
//    @DeleteMapping("/{customerId}")
//    @Operation(summary ="Delete a customer", description = "Delete and existing customer based on its ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
//            @ApiResponse(responseCode = "404", description = "User not found")
//
//    })
//    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
//        try {
//            customerService.deleteCustomer(customerId);
//            return ResponseEntity.ok("Cliente deletado com sucesso!");
//        } catch (NotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//}
