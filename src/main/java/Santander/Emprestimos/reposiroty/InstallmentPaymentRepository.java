package Santander.Emprestimos.reposiroty;


import Santander.Emprestimos.model.InstallmentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentPaymentRepository extends JpaRepository<InstallmentPayment, Long> {
}
