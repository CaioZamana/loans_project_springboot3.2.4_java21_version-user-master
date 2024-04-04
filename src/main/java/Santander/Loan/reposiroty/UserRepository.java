package Santander.Loan.reposiroty;

import Santander.Loan.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    Users findByEmail(String email);

    Users findByCpf(String cpf);

    Users findByFullName(String fullName);

    boolean existsByUsername(String username);


    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

}
