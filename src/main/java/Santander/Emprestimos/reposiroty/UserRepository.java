package Santander.Emprestimos.reposiroty;

import Santander.Emprestimos.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    Users findByEmail(String email);

    Users findByCpf(String cpf);

    Users findByFullName(String fullName);


}
