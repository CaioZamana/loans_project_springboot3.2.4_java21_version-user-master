package Santander.Loan.controller;

import Santander.Loan.dto.CustomerDto;
import Santander.Loan.dto.FuncionaryDto;
import Santander.Loan.exception.serviceexception.BusinessException;
import Santander.Loan.model.Funcionary;
import Santander.Loan.service.implementation.FuncionaryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    @Operation(summary = "Create new funcionary.", description = "Create a new funcionary.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Funcionary create successfully."),
            @ApiResponse(responseCode = "422", description = "Invalid customer data provided.")
    })
    public ResponseEntity<String> createFuncionary(@RequestBody FuncionaryDto funcionaryDto){
        funcionaryServiceImpl.createFuncionary(funcionaryDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário '"+ funcionaryDto.getFullName()+"' criado com sucesso.");
    }

    // Endpoint para atualizar um funcionário por ID
    @PutMapping("/update/{funcionaryId}")
    @Operation(summary = "Update a funcionary.", description = "Update the data of and existing funcionary based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionary updated successfully."),
            @ApiResponse(responseCode = "404", description = "Funcionary not found."),
            @ApiResponse(responseCode = "422", description = "Invalid funcionary data provided.")
    })
    public ResponseEntity<String> updateFuncionary(@PathVariable Long funcionaryId, @RequestBody FuncionaryDto funcionaryDto){
        Funcionary updatedFuncionary = funcionaryDto.toEntity();
        updatedFuncionary.setId(funcionaryId);
        funcionaryServiceImpl.updateFuncionary(updatedFuncionary);
        return ResponseEntity.ok().body("Funcionário atualizado com sucesso.");

    }

    @GetMapping("/get/{funcionaryId}")
    @Operation(summary = "Get funcionary by Id.", description = "Retrieve a specific funcionary based on its Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation Successful."),
            @ApiResponse(responseCode = "404", description = "Funcionary not found.")
    })
    ResponseEntity<FuncionaryDto> getFuncionaryById(@PathVariable Long funcionaryId){
        Funcionary funcionary = funcionaryServiceImpl.getFuncionaryById(funcionaryId);
        FuncionaryDto funcionaryDto = FuncionaryDto.fromEntity(funcionary);
        return ResponseEntity.ok(funcionaryDto);
    }

    @DeleteMapping("/delete/{funcionaryId}")
    @Operation(summary ="Delete a funcionary.", description = "Delete and existing funcionary based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Funcionary deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Funcionary not found.")
    })
    public ResponseEntity<String> deleteFuncionary(@PathVariable Long funcionaryId){
        funcionaryServiceImpl.deleteFuncionary(funcionaryId);
        return ResponseEntity.ok("Funcionary deletado com sucesso.");
    }


    @GetMapping("/get-all")
    @Operation(summary = "Get all funcionaries.", description = "Retrieve a list of all funcionaries.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation sucessful.")
    })
    public ResponseEntity<List<FuncionaryDto>> getAllFuncionaries(){
        //utilização de streams e map
        List<Funcionary> funcionaries = funcionaryServiceImpl.getAllFuncionaries();
        List<FuncionaryDto> funcionaryDtoList = funcionaries.stream()
                .map(FuncionaryDto::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(funcionaryDtoList);
    }
}
