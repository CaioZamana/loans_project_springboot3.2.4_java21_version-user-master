package Santander.Loan.controller;

import Santander.Loan.dto.FuncionaryDto;
import Santander.Loan.service.implementation.FuncionaryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/funcionaries")
@Tag(name = "Funcionaries Controller", description = "RESTful API for managing funcionaries.")
public class FuncionaryController {

    private final FuncionaryServiceImpl funcionaryServiceImpl;

    @Autowired
    public FuncionaryController(FuncionaryServiceImpl funcionaryService){
        this.funcionaryServiceImpl = funcionaryService;
    }

    @PostMapping("/post")
    @Operation(summary = "Create new funcionary.", description = "Create a new funcionary and return 'Funcionário 'fullName' criado com sucesso'")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer create successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid customer data provided")
    })
    public ResponseEntity<String> createFuncionary(@RequestBody FuncionaryDto funcionaryDto){
        funcionaryServiceImpl.createFuncionary(funcionaryDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário '"+ funcionaryDto.getFullName()+"' criado com sucesso.");
    }

}
