package Santander.Emprestimos.service.implementation;

import Santander.Emprestimos.exception.BusinessException;
import Santander.Emprestimos.model.Users;
import Santander.Emprestimos.reposiroty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

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
}


