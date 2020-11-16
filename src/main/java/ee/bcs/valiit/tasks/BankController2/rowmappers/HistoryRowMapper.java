package ee.bcs.valiit.tasks.BankController2.rowmappers;

import ee.bcs.valiit.tasks.BankController2.classes.History;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryRowMapper implements RowMapper<History> {

    @Override
    public History mapRow(ResultSet resultSet, int i) throws SQLException {
        History history = new History();
        history.setId(resultSet.getInt("id"));
        history.setAccountNr(resultSet.getString("account_nr"));
        history.setSumIn(resultSet.getBigDecimal("sum_in"));
        history.getSumOut(resultSet.getBigDecimal("sum_out"));
        history.setClientId(resultSet.getInt("client_id"));
        return history;
    }
}
