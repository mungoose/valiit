package ee.bcs.valiit.tasks.oldOnes.testBankRepository;

import ee.bcs.valiit.tasks.bankController2.classes.BankClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestBankRepository testBankRepository;

    @GetMapping("hibernate_test")   //localhost:8080/hibernate_test
    public List<BankClient> getAllClients(){
        return testBankRepository.findAll();
    }

    @GetMapping("hibernate_test2")  //localhost:8080/hibernate_test2?id=2
    public BankClient getOneClient(int id){
        return testBankRepository.getOne(id);
    }

    @PostMapping("hibernate_test3")  // localhost:8080/hibernate_test3?firstName=Joosep&lastName=Thoots
    public BankClient addOneClient(String firstName, String lastName){
        BankClient saveObject = new BankClient(firstName, lastName);
        return testBankRepository.save(saveObject);
    }
}
