package ee.bcs.valiit.tasks.controller;

import ee.bcs.valiit.tasks.classes.History;
import ee.bcs.valiit.tasks.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("Bank2")
@RestController
public class BankController2 {
    @Autowired
    private BankService bankService;
    private NamedParameterJdbcTemplate jdbcTemplate;

    // Add client with first name and last name.
    // Postgre will assign unique id which will be used as client ID.
    @PostMapping("addClient")
    public void addClient(String firstName, String lastName) {
        bankService.addClient(firstName, lastName);
    }
    // localhost:8080/Bank2/addClient?firstName=John&lastName=Smith


    // Create account by providing client ID and account number
    @PostMapping("createAccount")
    public void createAccount(int id, String accountNr) {
        bankService.createAccount(id, accountNr);
    }
    // localhost:8080/Bank2/createAccount?id=14&accountNr=EE22100


    // Add funds to an account by providing account number and deposit sum
    @PostMapping("addAmount")
    public void addAmount(String accountNr, BigDecimal in) {
        bankService.addAmount(accountNr, in);
    }
    // localhost:8080/Bank2/addAmount?accountNr=EE22100&in=450


    // Withdraw funds from an account by providing account number and withdraw sum
    // Will ignore function if balance is smaller than sum
    @PostMapping("withdraw")
    public void withdraw(String accountNr, BigDecimal out) {
        bankService.withdraw(accountNr, out);
    }
    // localhost:8080/Bank2/withdraw?accountNr=EE22100&out=500


    // Transfer money between accounts by providing from and to accounts and a sum
    // Will ignore function if balance of from account is smaller than money
    @PostMapping("transfer")
    public void transfer(String fromAccount, String toAccount, BigDecimal money) {
        bankService.transfer(fromAccount, toAccount, money);
    }
    // localhost:8080/Bank2/transfer?fromAccount=EE22100&toAccount=EE22101&money=47


    // Display all Bank's transaction history
    @GetMapping("getHistory")
    public List<History> getHistory() {
        return bankService.getHistory();
    }
    // localhost:8080/Bank2/getHistory


    // Display history of an account. Input account number.
    @GetMapping("getHistoryByAccount")
    public List<History> getHistoryByAccount(String accountNr) {
        return bankService.getHistoryByAccount(accountNr);
    }
    // localhost:8080/Bank2/getHistoryByAccount?accountNr=EE22106


    // Display history of a client by providing client id
    @GetMapping("getHistoryById")
    public List<History> getHistoryById(int id) {
        return bankService.getHistoryById(id);
    }
    // localhost:8080/Bank2/getHistoryById?id=18
}



