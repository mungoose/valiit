package ee.bcs.valiit.tasks;

import java.math.BigDecimal;

public class History {
    private int id;
    private String accountNr;
    private BigDecimal transaction;
    private int clientId;

    public History() {
    }

    public History(int id, String accountNr) {
        this.id = id;
        this.accountNr = accountNr;
    }

    public History(int id, String accountNr, BigDecimal transaction) {
        this.id = id;
        this.accountNr = accountNr;
        this.transaction = transaction;
    }

    public History(int id, String accountNr, BigDecimal transaction, int clientId) {
        this.id = id;
        this.accountNr = accountNr;
        this.transaction = transaction;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public BigDecimal getTransaction() {
        return transaction;
    }

    public void setTransaction(BigDecimal transaction) {
        this.transaction = transaction;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

}
