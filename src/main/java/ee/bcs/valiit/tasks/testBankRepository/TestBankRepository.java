package ee.bcs.valiit.tasks.testBankRepository;

import ee.bcs.valiit.tasks.BankController2.classes.BankClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBankRepository extends JpaRepository<BankClient, Integer> {

}
