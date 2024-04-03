package Santander.Emprestimos.controller;

import Santander.Emprestimos.dto.UserDto;
import Santander.Emprestimos.model.Users;
import Santander.Emprestimos.service.implementation.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/username/{username}")
    @Operation(summary = "Get a customer by username.", description = "Retrieve a specific customer based on its ursername")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        Users users = userServiceImpl.getUserByUsername(username);
        return ResponseEntity.ok(UserDto.fromEntity(users));
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get a customer by e-mail.", description = "Retrieve a specific customer based on its e-mail")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        Users users = userServiceImpl.getUserByEmail(email);
        return ResponseEntity.ok(UserDto.fromEntity(users));
    }

    @GetMapping("/cpf/{cpf}")
    @Operation(summary = "Get a customer by CPF.", description = "Retrieve a specific customer based on its cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<UserDto> getUserByCpf(@PathVariable String cpf) {
        Users users = userServiceImpl.getUserByCpf(cpf);
        return ResponseEntity.ok(UserDto.fromEntity(users));
    }

    @GetMapping("/fullname/{fullName}")
    @Operation(summary = "Get a customer by full name.", description = "Retrieve a specific customer based on its Full Name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<UserDto> getUserByFullName(@PathVariable String fullName) {
        Users users = userServiceImpl.getUserByFullName(fullName);
        return ResponseEntity.ok(UserDto.fromEntity(users));
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get all users.", description = "Retrieve a list of all registered users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<UserDto>> getAllUsers() {
        //GET ALL Utilizando streams e map

        List<Users> users = userServiceImpl.getAllUsers();

        // Mapeia os usuários para DTOs usando stream e Collectors.toList()
        List<UserDto> userDtos = users.stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userDtos);
    }


}