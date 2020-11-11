package ee.bcs.valiit.tasks.service;

import ee.bcs.valiit.tasks.History;
import ee.bcs.valiit.tasks.repository.BankAccountRepository;
import ee.bcs.valiit.tasks.repository.BankClientRepository;
import ee.bcs.valiit.tasks.repository.BankHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankClientRepository bankClientRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankHistoryRepository bankHistoryRepository;

    // Add client by defining first name and last name. SQL will assign unique id
    public void addClient(String firstName, String lastName) {
        bankClientRepository.addClient(firstName, lastName);
    }

    // Add an account
    public void createAccount(int id, String accountNr) {
        // Create account with initial balance 0
        bankAccountRepository.createAccount(id, accountNr, BigDecimal.ZERO);
        // Add to bank history with initial balance 0
        bankAccountRepository.addToHistory(accountNr, BigDecimal.ZERO);
    }

    // Add money to an account
    public void addAmount(String accountNr, BigDecimal in) {
        // Get initial balance
        BigDecimal balance = bankAccountRepository.getBalance(accountNr);

        // Make sure balance is not null
        assert balance != null;
        // Add money and update balance
        bankAccountRepository.setBalance(accountNr, balance.add(in));

        // Add money and add to bank history
        bankAccountRepository.addToHistory(accountNr, balance.add(in));

    }

    // Withdraw money from an account
    public void withdraw(String accountNr, BigDecimal out) {
        // Get initial balance
        BigDecimal balance = bankAccountRepository.getBalance(accountNr);

        // Make sure balance is not null
        assert balance != null;
        // If sufficient funds are present, perform transaction
        if (balance.compareTo(out) >= 0) {
            BigDecimal sum = balance.subtract(out);
            // Update balance
            bankAccountRepository.setBalance(accountNr, sum);

            // Add to bank history
            bankAccountRepository.addToHistory(accountNr, out.negate());
        }
    }

    // Transfer money between accounts
    public void transfer(String fromAccount, String toAccount, BigDecimal money) {
        // Get balance for fromAccount
        BigDecimal balanceFrom = bankAccountRepository.getBalance(fromAccount);
        // Get balance for toAccount
        BigDecimal balanceTo = bankAccountRepository.getBalance(toAccount);

        // Check if sufficients funds are present on fromAccount
        if (balanceFrom.compareTo(money) >= 0) {

            // Subtract sum from fromAccount and update balance
            bankAccountRepository.setBalance(fromAccount, balanceFrom.subtract(money));
            // Add sum to toAccount and update toAccount balance
            bankAccountRepository.setBalance(toAccount, balanceTo.add(money));

            // Add fromAccount transaction to bank history
            bankAccountRepository.addToHistory(fromAccount, money.negate());
            // Add toAccount transaction to bank history
            bankAccountRepository.addToHistory(toAccount, money);
        }
    }

    // Get transaction history by id
    public List<History> getHistory() {
        return bankHistoryRepository.getHistory();
    }
}
