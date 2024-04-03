package Santander.Loan.service.interfaces;

import Santander.Loan.model.Funcionary;

import java.util.List;

public interface IFuncionaryService {
    // Operações básicas de funcionário

    void createFuncionary(Funcionary funcionary);

    void updateFuncionary(Funcionary funcionary);

    void deleteFuncionary(Long funcionaryId);
    List<Funcionary> getAllFuncionaries();
    Funcionary getFuncionaryById(Long funcionaryId);

    // Operações de consulta de funcionário

//    Funcionary getFuncionariesByRole(RoleEnum role);
//
//    Funcionary getFuncionaryByEmail(String email);
//
//    Funcionary getFuncionaryByCpf(String cpf);
//
//    Funcionary getFuncionaryByName(String funcioanryName);
//
//    void updateFuncionarySalary(Long funcionaryId, Double newSalary);


}