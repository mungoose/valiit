package ee.bcs.valiit.tasks.bankController2.repository;

import ee.bcs.valiit.tasks.bankController2.classes.History;
import ee.bcs.valiit.tasks.bankController2.rowmappers.BankHistoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BankHistoryRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<History> getHistory() {
        String sql = "SELECT * FROM bank_history";
        Map historyMap = new HashMap();
        return jdbcTemplate.query(sql, historyMap, new BankHistoryRowMapper());
    }

    public List<History> getHistoryByAccount(String accountNr){
        String sql = "SELECT * FROM bank_history WHERE account_nr = (:value1)";
        Map<String, Object> historyMap = new HashMap<>();
        historyMap.put("value1", accountNr);
        return jdbcTemplate.query(sql, historyMap, new BankHistoryRowMapper());
    }

    public List<History> getHistoryById(int id){
        String sql = "SELECT * FROM bank_history WHERE client_id = (:value)";
        Map<String, Object> historyMap = new HashMap<>();
        historyMap.put("value", id);
        return jdbcTemplate.query(sql, historyMap, new BankHistoryRowMapper());
    }

    // Add account number, transaction in and client ID to history
    public void addToHistoryIn(String accountNr, BigDecimal transaction){
        String sql = "INSERT INTO bank_history (account_nr, sum_in, sum_out, client_id) VALUES (:value1, :value2, :value3, :value4)";
        Map<String, Object> addToHistoryMap = new HashMap<>();
        BigDecimal zero = BigDecimal.ZERO;
        addToHistoryMap.put("value1", accountNr);
        addToHistoryMap.put("value2", transaction);
        addToHistoryMap.put("value3", zero);
        addToHistoryMap.put("value4", bankAccountRepository.getClientId(accountNr));
        jdbcTemplate.update(sql, addToHistoryMap);
    }

    // Add account number, transaction out and client ID to history
    public void addToHistoryOut(String accountNr, BigDecimal transaction){
        String sql = "INSERT INTO bank_history (account_nr, sum_in, sum_out, client_id) VALUES (:value1, :value2, :value3, :value4)";
        Map<String, Object> addToHistoryMap = new HashMap<>();
        BigDecimal zero = BigDecimal.ZERO;
        addToHistoryMap.put("value1", accountNr);
        addToHistoryMap.put("value2", zero);
        addToHistoryMap.put("value3", transaction);
        addToHistoryMap.put("value4", bankAccountRepository.getClientId(accountNr));
        jdbcTemplate.update(sql, addToHistoryMap);
    }


}