package ee.bcs.valiit.tasks.BankController2.repository;

import ee.bcs.valiit.tasks.BankController2.classes.History;
import ee.bcs.valiit.tasks.BankController2.rowmappers.HistoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
        return jdbcTemplate.query(sql, historyMap, new HistoryRowMapper());
    }

    public List<History> getHistoryByAccount(String accountNr){
        String sql = "SELECT * FROM bank_history WHERE account_nr = :value1";
        Map<String, Object> historyMap = new HashMap<>();
        historyMap.put("value1", accountNr);
        return jdbcTemplate.query(sql, historyMap, new HistoryRowMapper());
    }

    public List<History> getHistoryById(int id){
        String sql = "SELECT * FROM bank_history WHERE client_id = :value1";
        Map<String, Object> historyMap = new HashMap<>();
        historyMap.put("value1", id);
        return jdbcTemplate.query(sql, historyMap, new HistoryRowMapper());
    }

}