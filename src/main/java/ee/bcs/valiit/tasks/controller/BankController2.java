package ee.bcs.valiit.tasks.controller;

import ee.bcs.valiit.tasks.History;
import ee.bcs.valiit.tasks.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RequestMapping("Bank2")
@RestController
public class BankController2 {
    @Autowired
    private BankService bankService;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("addClient")   // localhost:8080/Bank2/addClient?firstName=John&lastName=Smith
    public void addClient(String firstName, String lastName) {
        bankService.addClient(firstName, lastName);
    }

    @PostMapping("createAccount")   // localhost:8080/Bank2/createAccount?id=14&accountNr=EE22100
    public void createAccount(int id, String accountNr) {
        bankService.createAccount(id, accountNr);
    }

    @PostMapping("addAmount")      // localhost:8080/Bank2/addAmount?accountNr=EE22100&in=450
    public void addAmount(String accountNr, BigDecimal in) {
        bankService.addAmount(accountNr, in);
    }

    @PostMapping("withdraw")        // localhost:8080/Bank2/withdraw?accountNr=EE22100&out=500
    public void withdraw(String accountNr, BigDecimal out) {
        bankService.withdraw(accountNr, out);
    }

    @PostMapping("transfer")        // localhost:8080/Bank2/transfer?fromAccount=EE22100&toAccount=EE22101&sum=47
    public void transfer(String fromAccount, String toAccount, BigDecimal money) {
        bankService.transfer(fromAccount, toAccount, money);
    }

    @GetMapping("getHistory")   // localhost:8080/Bank2/getHistoryById
    public List<History> getHistor() {
        return bankService.getHistory();
    }
}

