package Santander.Loan.reposiroty;

import Santander.Loan.model.AccountLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountLoan, Long> {
}
