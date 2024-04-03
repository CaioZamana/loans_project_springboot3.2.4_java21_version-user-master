package Santander.Emprestimos.reposiroty;


import Santander.Emprestimos.model.Collateral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollateralRepository extends JpaRepository<Collateral, Long> {
}
