package Santander.Loan.service.implementation;

import Santander.Loan.exception.exceptionservice.BusinessException;
import Santander.Loan.model.Users;
import Santander.Loan.reposiroty.UserRepository;
import Santander.Loan.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired //Construtor autowired com o repository
    public UserServiceImpl(UserRepository userRepository1) {

        this.userRepository = userRepository1;
    }

    public Users getUserByUsername(String username) {
        Users users = userRepository.findByUsername(username);
        if (users == null) {
            throw new BusinessException("Username '" + username + "' não encontrado.");
        }
        return users;
    }

    public Users getUserByEmail(String email) {
        Users users = userRepository.findByEmail(email);
        if (users == null) {
            throw new BusinessException("Usuário com o e-mail '" + email + "' não encontrado.");
        }
        return users;
    }

    public Users getUserByCpf(String cpf) {
        Users users = userRepository.findByCpf(cpf);
        if (users == null) {
            throw new BusinessException("O Cpf '" + cpf + "' não foi encontrado.");
        }
        return users;
    }

    public Users getUserByFullName(String fullName) {
        Users users = userRepository.findByFullName(fullName);
        if (users == null) {
            throw new BusinessException("O Nome '" + fullName + "' não foi encontrado.");
        }
        return users;
    }
    public List<Users> getAllUsers(){
        List<Users> usersList = userRepository.findAll();
        if (usersList.isEmpty()){
            throw new BusinessException("A lista de usuários está vazia.");
        }
        return usersList;
    }

    public Users getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new BusinessException("Usuário com ID '"+ userId + "' não encontrado."));

    }
}


