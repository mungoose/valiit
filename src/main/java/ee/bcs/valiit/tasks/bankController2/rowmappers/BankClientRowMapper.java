package ee.bcs.valiit.tasks.bankController2.rowmappers;


import ee.bcs.valiit.tasks.bankController2.classes.BankClient;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankClientRowMapper implements RowMapper<BankClient> {

    @Override
    public BankClient mapRow(ResultSet resultSet, int i) throws SQLException {
        BankClient bankClient = new BankClient();
        bankClient.setId(resultSet.getInt("id"));
        bankClient.setFirstName(resultSet.getString("first_name"));
        bankClient.setLastName(resultSet.getString("last_name"));
        return bankClient;
    }
}
