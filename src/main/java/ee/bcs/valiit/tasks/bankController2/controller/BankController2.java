package ee.bcs.valiit.tasks.bankController2.controller;

import ee.bcs.valiit.tasks.bankController2.classes.Account;
import ee.bcs.valiit.tasks.bankController2.classes.BankClient;
import ee.bcs.valiit.tasks.bankController2.classes.History;
import ee.bcs.valiit.tasks.bankController2.classes.User;
import ee.bcs.valiit.tasks.bankController2.repository.BankClientRepository;
import ee.bcs.valiit.tasks.bankController2.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("Bank2")
@RestController
public class BankController2 {
    @Autowired
    private BankService bankService;
    @Autowired
    private BankClientRepository bankClientRepository;


    // Add client with first name and last name and auto id
    @CrossOrigin
    @PostMapping("addClient2")
    public BankClient addClient2(String firstName, String lastName) {
        return bankService.addClient(firstName, lastName);
    }
    // localhost:8080/Bank2/addClient2?firstName=John&lastName=Smith

    @CrossOrigin
    @GetMapping("getBalance")
    public BigDecimal getBalanceByAccountNr(String accountNr) {
        return bankService.getBalanceByAccountNr(accountNr);
    }
    // localhost:8080/Bank2/getBalance?accountNr=EE22101

    @CrossOrigin
    @GetMapping("getClientAccounts")
    public List<Account> getClientAccounts(int id) {
        return bankService.getAccountsById(id);
    }
    // localhost:8080/Bank2/getClientAccounts?id=15

    @CrossOrigin
    @GetMapping("getClientNameById")
    public BankClient getClientNameById(int id) {
        return bankService.getClientNameById(id);
    }
    // localhost:8080/Bank2/getClientNameById?id=3

    // Create account by providing client ID and account number
    @CrossOrigin
    @PostMapping("createAccount")
    public void createAccount(int id, String accountNr) {
        bankService.createAccount(id, accountNr);
    }
    // localhost:8080/Bank2/createAccount?id=14&accountNr=EE22100


    // Add funds to an account by providing account number and deposit sum
    @CrossOrigin
    @PostMapping("addAmount")
    public void addAmount(String accountNr, BigDecimal in) {
        bankService.addAmount(accountNr, in);
    }
    // localhost:8080/Bank2/addAmount?accountNr=EE22100&in=450


    // Withdraw funds from an account by providing account number and withdraw sum
    // Will ignore function if balance is smaller than sum
    @CrossOrigin
    @PostMapping("withdraw")
    public void withdraw(String accountNr, BigDecimal out) {
        bankService.withdraw(accountNr, out);
    }
    // localhost:8080/Bank2/withdraw?accountNr=EE22100&out=500


    // Transfer money between accounts by providing from and to accounts and a sum
    // Will ignore function if balance of from account is smaller than money
    @CrossOrigin
    @PostMapping("transfer")
    public void transfer(String fromAccount, String toAccount, BigDecimal money) {
        bankService.transfer(fromAccount, toAccount, money);
    }
    // localhost:8080/Bank2/transfer?fromAccount=EE22100&toAccount=EE22101&money=47


    // Display all Bank's transaction history
    @CrossOrigin
    @GetMapping("getHistory")
    public List<History> getHistory() {
        return bankService.getHistory();
    }
    // localhost:8080/Bank2/getHistory


    // Display history of an account. Input account number.
    @CrossOrigin
    @GetMapping("getHistoryByAccount")
    public List<History> getHistoryByAccount(String accountNr) {
        return bankService.getHistoryByAccount(accountNr);
    }
    // localhost:8080/Bank2/getHistoryByAccount?accountNr=EE22106


    // Display history of a client by providing client id
    @CrossOrigin
    @GetMapping("getHistoryById")
    public List<History> getHistoryById(int id) {
        return bankService.getHistoryById(id);
    }
    // localhost:8080/Bank2/getHistoryById?id=1


    @CrossOrigin
    @PostMapping("register")
    public List<User> register(@RequestBody User user) {
        System.out.println(user);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(new User("john", "john@smt.com", 33));
        userList.add(new User("peter", "none", 45));
        userList.add(new User("john", "john@anotherjohg.com", 53));
        userList.add(new User("linda", "lindasnad@gag.com", 34));
        return userList;
    }


}

