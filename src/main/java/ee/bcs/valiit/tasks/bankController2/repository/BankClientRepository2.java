package ee.bcs.valiit.tasks.bankController2.repository;

import ee.bcs.valiit.tasks.bankController2.classes.BankClient;
import ee.bcs.valiit.tasks.bankController2.rowmappers.BankClientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BankClientRepository2 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public BankClient getClientNameById(int id) {
        String sql = "SELECT * FROM bank_client WHERE id = (:value)";
        Map<String, Object> bankClientMap = new HashMap<>();
        bankClientMap.put("value", id);
        return jdbcTemplate.queryForObject(sql, bankClientMap, new BankClientRowMapper());
    }

}
