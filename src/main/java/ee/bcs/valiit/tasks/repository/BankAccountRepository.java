package ee.bcs.valiit.tasks.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankAccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // Add an account
    public void createAccount(int id, String accountNr, BigDecimal zero) {
        // Create an account by defining account number, attach client id, set initial balance of 0
        String sql = "INSERT INTO client_account (account_nr, client_id, balance) VALUES (:value1, :value2, :value3)";
        Map<String, Object> accountMap = new HashMap<>();
        accountMap.put("value1", accountNr);
        accountMap.put("value2", id);
        accountMap.put("value3", zero);
        jdbcTemplate.update(sql, accountMap);
    }

    public void addToHistory(String accountNr, BigDecimal transaction) {
        // Add created account with balance of 0 to bank history
        String sql = "INSERT INTO bank_history (account_nr, transaction, client_id) VALUES (:value1, :value2, :value3)";
        Map<String, Object> addToHistoryMap = new HashMap<>();
        addToHistoryMap.put("value1", accountNr);
        addToHistoryMap.put("value2", transaction);
        addToHistoryMap.put("value3", getClientId(accountNr));
        jdbcTemplate.update(sql, addToHistoryMap);
    }

    public BigDecimal getBalance(String accountNr) {
        // Get initial balance
        String sql = "SELECT balance FROM client_account WHERE account_nr = (:value1)";
        Map<String, Object> getBalanceMap = new HashMap<>();
        getBalanceMap.put("value1", accountNr);
        return jdbcTemplate.queryForObject(sql, getBalanceMap, BigDecimal.class);
    }

    public void setBalance(String accountNr, BigDecimal sum) {
        String sql2 = "UPDATE client_account SET balance = (:value1) WHERE account_nr = (:value2)";
        Map<String, Object> setBalanceMap = new HashMap<>();
        setBalanceMap.put("value1", sum);
        setBalanceMap.put("value2", accountNr);
        jdbcTemplate.update(sql2, setBalanceMap);
    }

    public int getClientId(String accountNr) {
        String sql3 = "SELECT client_id FROM client_account WHERE account_nr = (:value)";
        Map<String, Object> getClientIdMap = new HashMap<>();
        getClientIdMap.put("value", accountNr);
        return jdbcTemplate.queryForObject(sql3, getClientIdMap, int.class);
    }
}
