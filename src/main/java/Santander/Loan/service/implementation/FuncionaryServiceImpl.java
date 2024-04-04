package Santander.Loan.service.implementation;

import Santander.Loan.exception.serviceexception.BusinessException;
import Santander.Loan.model.Customer;
import Santander.Loan.model.Funcionary;
import Santander.Loan.reposiroty.FuncionaryRepository;
import Santander.Loan.reposiroty.UserRepository;
import Santander.Loan.security.RoleEnum;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionaryServiceImpl {

    private final FuncionaryRepository funcionaryRepository;
    private final UserRepository userRepository;

    @Autowired
    public FuncionaryServiceImpl(FuncionaryRepository funcionaryRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
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


    public void updateFuncionary(Funcionary updatedFuncionary){
        try {
            Funcionary existingFuncionary = funcionaryRepository.findById(updatedFuncionary.getId())
                    .orElseThrow(() -> new BusinessException("Funcionário não encontrado."));

            existingFuncionary.setUsername(updatedFuncionary.getUsername());
            existingFuncionary.setPassword(updatedFuncionary.getPassword());
            existingFuncionary.setEmail(updatedFuncionary.getEmail());
            existingFuncionary.setCpf(updatedFuncionary.getCpf());
            existingFuncionary.setFullName(updatedFuncionary.getFullName());
            existingFuncionary.setAddress(updatedFuncionary.getAddress());
            existingFuncionary.setTelephone(updatedFuncionary.getTelephone());
            existingFuncionary.setProfessionalRegistrationNumber(updatedFuncionary.getProfessionalRegistrationNumber());
            existingFuncionary.setSalary(updatedFuncionary.getSalary());
            existingFuncionary.setRoles(updatedFuncionary.getRoles());

            funcionaryRepository.save(existingFuncionary);
        } catch (Exception e) {
            throw new BusinessException("Erro ao atualizar funcionário. Campo contém caractere inválido. Mensagem do erro: "+ e.getMessage());
        }
    }

    public Funcionary getFuncionaryById(Long funcionaryId){
        return funcionaryRepository.findById(funcionaryId)
                .orElseThrow(() -> new BusinessException("Funcionário com o ID '" + funcionaryId +"' não foi encontrado."));
    }

//    void deleteFuncionary(Long funcionaryId){
//
//    }
//    List<Funcionary> getAllFuncionaries(){
//
//    }

}

