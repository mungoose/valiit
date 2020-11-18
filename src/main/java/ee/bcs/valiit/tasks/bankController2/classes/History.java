package ee.bcs.valiit.tasks.bankController2.classes;

import java.math.BigDecimal;

public class History {
    private int id;
    private String accountNr;
    private BigDecimal sumIn;
    private BigDecimal sumOut;
    private int clientId;

    public History() {
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

    public BigDecimal getSumIn() {
        return sumIn;
    }

    public void setSumIn(BigDecimal sumIn) {
        this.sumIn = sumIn;
    }

    public BigDecimal getSumOut(BigDecimal sum_out) {
        return sumOut;
    }

    public void setSumOut(BigDecimal sumOut) {
        this.sumOut = sumOut;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

//    public History(int id, String accountNr) {
//        this.id = id;
//        this.accountNr = accountNr;
//    }
//
//    public History(int id, String accountNr, BigDecimal sumIn, BigDecimal sumOut) {
//        this.id = id;
//        this.accountNr = accountNr;
//        this.sumIn = sumIn;
//        this.sumOut = sumOut;
//    }
//
//    public History(int id, String accountNr, BigDecimal sumIn, BigDecimal sumOut, int clientId) {
//        this.id = id;
//        this.accountNr = accountNr;
//        this.sumIn = sumIn;
//        this.sumOut = sumOut;
//        this.clientId = clientId;
//    }

}
