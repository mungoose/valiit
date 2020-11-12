package ee.bcs.valiit.tasks.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankClientRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // Create client by providing first name and last name
    public void addClient(String firstName, String lastName) {
        String sql = "INSERT INTO bank_client (first_name, last_name) VALUES (:first_name, :last_name)";
        Map<String, String> clientMap = new HashMap<>();
        clientMap.put("first_name", firstName);
        clientMap.put("last_name", lastName);
        jdbcTemplate.update(sql, clientMap);
    }
}
