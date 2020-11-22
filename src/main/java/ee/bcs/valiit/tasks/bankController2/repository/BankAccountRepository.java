package ee.bcs.valiit.tasks.bankController2.repository;

import ee.bcs.valiit.tasks.bankController2.classes.Account;
import ee.bcs.valiit.tasks.bankController2.rowmappers.BankAccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
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

    public List<Account> getAccountNrsByID(int id) {
        String sql = "SELECT * FROM client_account WHERE client_id = (:value)";
        Map<String, Object> accountNr = new HashMap();
        accountNr.put("value", id);
        return jdbcTemplate.query(sql, accountNr, new BankAccountRowMapper());
    }

}
