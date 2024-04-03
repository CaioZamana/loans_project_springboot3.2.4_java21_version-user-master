package Santander.Emprestimos.reposiroty;

import Santander.Emprestimos.model.Funcionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionaryRepository extends JpaRepository<Funcionary, Long> {
    boolean existsByCpf (String cpf);
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
