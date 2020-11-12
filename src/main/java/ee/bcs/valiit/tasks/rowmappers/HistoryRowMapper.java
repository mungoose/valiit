package ee.bcs.valiit.tasks.rowmappers;

import ee.bcs.valiit.tasks.classes.History;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryRowMapper implements RowMapper<History> {

    @Override
    public History mapRow(ResultSet resultSet, int i) throws SQLException {
        History history = new History();
        history.setId(resultSet.getInt("id"));
        history.setAccountNr(resultSet.getString("account_nr"));
        history.setTransaction(resultSet.getBigDecimal("transaction"));
        history.setClientId(resultSet.getInt("client_id"));
        return history;
    }
}
