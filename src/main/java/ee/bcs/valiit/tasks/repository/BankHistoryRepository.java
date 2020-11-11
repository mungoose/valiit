package ee.bcs.valiit.tasks.repository;

import ee.bcs.valiit.tasks.History;
import ee.bcs.valiit.tasks.HistoryRowMapper;
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

    public List<History> getHistory() {
        String sql = "SELECT * FROM bank_history";
        Map historyMap = new HashMap();
        List<History> result = jdbcTemplate.query(sql, historyMap, new HistoryRowMapper());
        return result;
    }
}

/*
    // Et saada üks konkreetne tabel:
    @GetMapping("clientAccounts")       // localhost:8080/Bank2/clientAccounts
    public List<Account> getClientAccounts() {
        String sql = "SELECT * FROM client_account";
        Map paramMap = new HashMap();
        List<Account> result = jdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        return result;
        // Sellega seotud AccountRowMapper.java class ja selle küljes olev Account.java klass
    }*/