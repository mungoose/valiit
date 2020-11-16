package ee.bcs.valiit.tasks.BankController2.repository;

import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankAccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // Create an account by defining account number, attach client id, set initial balance of 0
    public void createAccount(int id, String accountNr) {
        String sql = "INSERT INTO client_account (account_nr, client_id, balance) VALUES (:value1, :value2, :value3)";
        Map<String, Object> accountMap = new HashMap<>();
        BigDecimal zero = BigDecimal.ZERO;
        accountMap.put("value1", accountNr);
        accountMap.put("value2", id);
        accountMap.put("value3", zero);
        jdbcTemplate.update(sql, accountMap);
    }

    // Add account number, transaction and client ID to history
    public void addToHistory(String accountNr, BigDecimal transaction) {
        String sql = "INSERT INTO bank_history (account_nr, transaction, client_id) VALUES (:value1, :value2, :value3)";
        Map<String, Object> addToHistoryMap = new HashMap<>();
        addToHistoryMap.put("value1", accountNr);
        addToHistoryMap.put("value2", transaction);
        addToHistoryMap.put("value3", getClientId(accountNr));
        jdbcTemplate.update(sql, addToHistoryMap);
    }

    // Add account number, transaction in and client ID to history
    public void addToHistoryIn(String accountNr, BigDecimal transaction){
        String sql = "INSERT INTO bank_history (account_nr, sum_in, client_id) VALUES (:value1, :value2, :value3)";
        Map<String, Object> addToHistoryMap = new HashMap<>();
        addToHistoryMap.put("value1", accountNr);
        addToHistoryMap.put("value2", transaction);
        addToHistoryMap.put("value3", getClientId(accountNr));
        jdbcTemplate.update(sql, addToHistoryMap);
    }

    // Add account number, transaction out and client ID to history
    public void addToHistoryOut(String accountNr, BigDecimal transaction){
        String sql = "INSERT INTO bank_history (account_nr, sum_out, client_id) VALUES (:value1, :value2, :value3)";
        Map<String, Object> addToHistoryMap = new HashMap<>();
        addToHistoryMap.put("value1", accountNr);
        addToHistoryMap.put("value2", transaction);
        addToHistoryMap.put("value3", getClientId(accountNr));
        jdbcTemplate.update(sql, addToHistoryMap);
    }

    // Add account number, initial sum and client id manually to history
    public void addToHistoryInitial(String accountNr, BigDecimal initial, int id) {
        String sql = "INSERT INTO bank_history (account_nr, transaction, client_id) VALUES (:value1, :value2, :value3)";
        Map<String, Object> addToHistoryMap = new HashMap<>();
        addToHistoryMap.put("value1", accountNr);
        addToHistoryMap.put("value2", initial);
        addToHistoryMap.put("value3", id);
        jdbcTemplate.update(sql, addToHistoryMap);
    }


    // Get account balance by account number
    public BigDecimal getBalance(String accountNr) {
        String sql = "SELECT balance FROM client_account WHERE account_nr = (:value)";
        Map<String, Object> getBalanceMap = new HashMap<>();
        getBalanceMap.put("value", accountNr);
        return jdbcTemplate.queryForObject(sql, getBalanceMap, BigDecimal.class);
    }

    // Set balance by account number and sum
    public void setBalance(String accountNr, BigDecimal sum) {
        String sql = "UPDATE client_account SET balance = (:value1) WHERE account_nr = (:value2)";
        Map<String, Object> setBalanceMap = new HashMap<>();
        setBalanceMap.put("value1", sum);
        setBalanceMap.put("value2", accountNr);
        jdbcTemplate.update(sql, setBalanceMap);
    }

    // Get client ID by account number
    public int getClientId(String accountNr) {
        String sql = "SELECT client_id FROM client_account WHERE account_nr = (:value)";
        Map<String, String> getClientIdMap = new HashMap<>();
        getClientIdMap.put("value", accountNr);
        return jdbcTemplate.queryForObject(sql, getClientIdMap, int.class);
    }
}
