package ee.bcs.valiit.tasks.bankController2.rowmappers;

import ee.bcs.valiit.tasks.bankController2.classes.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setAccountNr(resultSet.getString("account_nr"));
        account.setBalance(resultSet.getBigDecimal("balance"));
        account.setClientId(resultSet.getInt("client_id"));
        return account;
    }
}
