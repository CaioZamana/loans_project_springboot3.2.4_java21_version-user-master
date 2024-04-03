package Santander.Emprestimos.service.interfaces;

import Santander.Emprestimos.model.Funcionary;
import Santander.Emprestimos.security.RoleEnum;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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