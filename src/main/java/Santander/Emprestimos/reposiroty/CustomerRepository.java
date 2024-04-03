package Santander.Emprestimos.reposiroty;

import Santander.Emprestimos.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
    Customer findByEmail(String email);
    boolean existsByCpf (String cpf);
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
