package ee.bcs.valiit.tasks.controller;

import ee.bcs.valiit.tasks.tasks.Account2;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("Bank")
@RestController
public class BankController {
    //createAccount (accountNr) (Stringiga konto nr)
    //depositMoney (accountNr, money)
    //withdrawMoney(accountNr,money) (Lisa funktsioonid keelatud liigutuste kohta.)
    //transferMoney(fromAccount, toAccount, money)
    //getAccountBalance(accountNr)
    //---------------------------------
    //Raskem
    //createClient(firstName, lastName; ....)
    //muut createAccount (clientId, accountNr) (Et ühel kliendil saab olla mitu kontot)
    //getBalanceHistory (accountNr)

    //List<Account> accountList = new ArrayList<>();
    private Map<String, Account2> accounts = new HashMap<>();

    @PostMapping("account")     // localhost:8080/Bank/account
    public void createAccount(@RequestBody String accountNr) {
        accounts.put(accountNr, new Account2(accountNr));
    }

    @GetMapping("account")      // localhost:8080/Bank/account
    public Map<String, Account2> getAccountList() {
        return accounts;
    }

    @GetMapping("account/getBalance")
    public BigDecimal getAccount(@RequestParam("accountNr") String accountNr) {
        return accounts.get(accountNr).getBalance();
    }


    @PutMapping("account/add")      // localhost:8080/Bank/account/add?accountNr=EE22101&moneyIn=5.00
    public void addMoney(@RequestParam("accountNr") String accountNr, //@PathVariable("id") int id,
                         @RequestParam("moneyIn") BigDecimal in) {
     /*   Account account = accounts.get(accountNr);
        BigDecimal oldValue = account.getBalance();
        BigDecimal newValue = oldValue.add(in);
        account.setBalance(newValue);
        accounts.put(accountNr, account);*/

        BigDecimal newValue = accounts.get(accountNr).getBalance().add(in);
        accounts.get(accountNr).setBalance(newValue);
    }

    @PutMapping("account/withdraw") // localhost:8080/Bank/account/withdraw?accountNr=EE22101&moneyOut=2.49
    public void withdrawMoney(@RequestParam("accountNr") String accountNr,
                              @RequestParam("moneyOut") BigDecimal out) {
        BigDecimal first = accounts.get(accountNr).getBalance();
        BigDecimal second = out;
        if (first.compareTo(second) <= 0) {
            BigDecimal newValue = accounts.get(accountNr).getBalance().subtract(out);
            accounts.get(accountNr).setBalance(newValue);
        }
    }

    @PutMapping("account/transfer") // localhost:8080/Bank/account/transfer?from=EE22101&to=EE22100&money=10
    public void transferMoney(@RequestParam("from") String from,
                              @RequestParam("to") String to,
                              @RequestParam("money") BigDecimal money) {
        BigDecimal first = accounts.get(from).getBalance();
        BigDecimal second = accounts.get(to).getBalance();
        if (first.compareTo(money) >= 0) {
            first = first.subtract(money);
            second = second.add(money);
            accounts.get(from).setBalance(first);
            accounts.get(to).setBalance((second));
        }

    }
}


