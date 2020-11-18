package ee.bcs.valiit.tasks.oldOnes;

import java.math.BigDecimal;

public class Account {
    private String accountNr;
    private BigDecimal balance;
    private int clientId;

    public Account() {
    }

    public Account(String accountNr, BigDecimal balance) {
        this.accountNr = accountNr;
        this.balance = balance;
    }

    public Account(String accountNr, BigDecimal balance, int clientId) {
        this.accountNr = accountNr;
        this.balance = balance;
        this.clientId = clientId;
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
