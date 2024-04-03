package Santander.Emprestimos.service.interfaces;

import Santander.Emprestimos.model.Users;

import java.util.List;

public interface IUserService {
    // Operações de consulta de usuário


    Users getUserByUsername(String username);

    Users getUserByEmail(String email);

    Users getUserByCpf(String cpf);

    Users getUserByFullName(String fullName);

    List<Users> getAllUsers();

}
