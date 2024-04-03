package Santander.Emprestimos.service.implementation;

import Santander.Emprestimos.exception.BusinessException;
import Santander.Emprestimos.model.Funcionary;
import Santander.Emprestimos.reposiroty.FuncionaryRepository;
import Santander.Emprestimos.security.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FuncionaryServiceImpl {

    private final FuncionaryRepository funcionaryRepository;

    @Autowired
    public FuncionaryServiceImpl(FuncionaryRepository funcionaryRepository){
        this.funcionaryRepository = funcionaryRepository;
    }

    public void createFuncionary(Funcionary funcionary) {
        if (funcionaryRepository.existsByCpf(funcionary.getCpf())) {
            throw new BusinessException("CPF já está sendo utilizado.");
        }
        if (funcionaryRepository.existsByEmail(funcionary.getEmail())) {
            throw new BusinessException("E-mail já está sendo utilizado.");
        }
        if (funcionaryRepository.existsByUsername(funcionary.getUsername())) {
            throw new BusinessException("Username já está sendo utilizado.");
        }

        funcionaryRepository.save(funcionary);
    }



//
//    void updateFuncionary(Funcionary funcionary){
//
//    }
//
//    void deleteFuncionary(Long funcionaryId){
//
//    }
//    List<Funcionary> getAllFuncionaries(){
//
//    }
//    Funcionary getFuncionaryById(Long funcionaryId){
//
//    }

}

