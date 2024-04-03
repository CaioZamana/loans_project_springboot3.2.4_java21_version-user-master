package Santander.Loan.reposiroty;

import Santander.Loan.model.RiskAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskAssessmentRepository extends JpaRepository<RiskAssessment, Long> {
}
