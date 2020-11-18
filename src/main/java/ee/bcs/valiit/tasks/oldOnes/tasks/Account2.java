package ee.bcs.valiit.tasks.oldOnes.tasks;


import ee.bcs.valiit.tasks.bankController2.classes.History;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account2 {
    private String accountNr;
    private BigDecimal balance;
    private List<History> accountHistory = new ArrayList<>();

    public Account2(String accountNr) {
        this.accountNr = accountNr;
        this.balance = BigDecimal.ZERO;

    }

    public List<History> getAccountHistory() {
        return accountHistory;
    }

    public void setAccountHistory(List<History> accountHistory) {
        this.accountHistory = accountHistory;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
