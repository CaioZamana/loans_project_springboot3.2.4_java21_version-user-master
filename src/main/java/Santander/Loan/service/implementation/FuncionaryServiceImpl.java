package Santander.Loan.service.implementation;

import Santander.Loan.exception.serviceexception.BusinessException;
import Santander.Loan.model.Funcionary;
import Santander.Loan.reposiroty.FuncionaryRepository;
import Santander.Loan.reposiroty.UserRepository;

import Santander.Loan.service.interfaces.IFuncionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class FuncionaryServiceImpl implements IFuncionaryService {

    private final FuncionaryRepository funcionaryRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public FuncionaryServiceImpl(FuncionaryRepository funcionaryRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.funcionaryRepository = funcionaryRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createFuncionary(Funcionary funcionary) {
        if (funcionaryRepository.existsByCpf(funcionary.getCpf())) {
            throw new BusinessException("CPF já está sendo utilizado.");
        }
        if (funcionaryRepository.existsByEmail(funcionary.getEmail())) {
            throw new BusinessException("E-mail já está sendo utilizado.");
        }
        if (userRepository.existsByUsername(funcionary.getUsername())) {
            throw new BusinessException("Username já está sendo utilizado.");
        }
        if (!isNumericPassword(funcionary.getPassword())) {
            throw new BusinessException("A senha deve conter entre 6 e 10 dígitos numéricos.");
        }

        // Criptografa a senha antes de salvar
        String encryptedPassword = passwordEncoder.encode(funcionary.getPassword());
        funcionary.setPassword(encryptedPassword);

        funcionaryRepository.save(funcionary);
    }


    // Utiliza uma expressão regular para verificar se a senha contém apenas dígitos numéricos
    private boolean isNumericPassword(String password) {
        return Pattern.matches("^\\d{6,10}$", password);
    }

    public void updateFuncionary(Funcionary updatedFuncionary){
        if (!isNumericPassword(updatedFuncionary.getPassword())) {
            throw new BusinessException("A senha deve conter entre 6 e 10 dígitos numéricos.");
        }
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
            throw new BusinessException("Erro ao atualizar funcionário. Contém campo inválido. Mensagem do erro: "+ e.getMessage());
        }
    }

    public Funcionary getFuncionaryById(Long funcionaryId){
        return funcionaryRepository.findById(funcionaryId)
                .orElseThrow(() -> new BusinessException("Funcionário com o ID '" + funcionaryId +"' não foi encontrado."));
    }

    public void deleteFuncionary(Long funcionaryId){
        if (!funcionaryRepository.existsById(funcionaryId)){
            throw new BusinessException("Funcionário com ID '" + funcionaryId + "' não encontrado.");
        }
        funcionaryRepository.deleteById(funcionaryId);
    }

    public List<Funcionary> getAllFuncionaries(){
        List<Funcionary> funcionaryList = funcionaryRepository.findAll();
        if(funcionaryList.isEmpty()){
            throw new BusinessException("A lista de funcionários está vazia.");
        }
        return funcionaryList;
    }




}

