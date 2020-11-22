package ee.bcs.valiit.tasks.bankController2.repository;

import ee.bcs.valiit.tasks.bankController2.classes.BankClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankClientRepository extends JpaRepository<BankClient, Integer> {

}
