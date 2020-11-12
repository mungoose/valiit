package ee.bcs.valiit.tasks.BankController2.TestBankRepository;

import ee.bcs.valiit.tasks.Client;
import ee.bcs.valiit.tasks.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestBankRepository extends JpaRepository<BankClient, Integer> {

}
