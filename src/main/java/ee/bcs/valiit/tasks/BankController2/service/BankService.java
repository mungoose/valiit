package ee.bcs.valiit.tasks.BankController2.service;

import ee.bcs.valiit.tasks.BankController2.exceptions.ApplicationException;
import ee.bcs.valiit.tasks.BankController2.classes.History;
import ee.bcs.valiit.tasks.BankController2.repository.BankAccountRepository;
import ee.bcs.valiit.tasks.BankController2.repository.BankClientRepository;
import ee.bcs.valiit.tasks.BankController2.repository.BankHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
//    public void addClient(String firstName, String lastName) {
//        bankClientRepository.addClient(firstName, lastName);
//    }



    // Add an account
    public void createAccount(int id, String accountNr) {
        // Create account with initial balance 0
        bankAccountRepository.createAccount(id, accountNr);
        // Add to bank history with initial balance 0
        //bankAccountRepository.addToHistoryInitial(accountNr, BigDecimal.ZERO, id);
    }

    // Add an account without providing initial balance to history
    public void createAccount2(int id, String accountNr){
        // Create account with initial balance of 0
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
        bankAccountRepository.addToHistoryIn(accountNr, balance.add(in));

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
            bankAccountRepository.addToHistoryOut(accountNr, out.negate());
        } else {
            // If funds are smaller than requested money ("out"), throw exception with message
            throw new ApplicationException("Not enough money!");
        }
    }

    // Transfer money between accounts
    public void transfer(String fromAccount, String toAccount, BigDecimal money) {
        // Get balance for fromAccount
        BigDecimal balanceFrom = bankAccountRepository.getBalance(fromAccount);
        // Get balance for toAccount
        BigDecimal balanceTo = bankAccountRepository.getBalance(toAccount);

        // Make sure balanceFrom is not null
        assert balanceFrom != null;
        // Check if sufficient funds are present on fromAccount
        if (balanceFrom.compareTo(money) >= 0) {

            // Subtract sum from fromAccount and update balance
            bankAccountRepository.setBalance(fromAccount, balanceFrom.subtract(money));
            // Add sum to toAccount and update toAccount balance
            bankAccountRepository.setBalance(toAccount, balanceTo.add(money));

            // Add fromAccount transaction to bank history
            bankAccountRepository.addToHistoryOut(fromAccount, money.negate());
            // Add toAccount transaction to bank history
            bankAccountRepository.addToHistoryIn(toAccount, money);
        } else {
            throw new ApplicationException("Not enough money to transfer!");
        }
    }

    // Get transaction history
    public List<History> getHistory() {
        return bankHistoryRepository.getHistory();
    }

    // Get transaction history by account nr
    public List<History> getHistoryByAccount(String accountNr){
        return bankHistoryRepository.getHistoryByAccount(accountNr);
    }

    // Get transaction history by client ID
    public List<History> getHistoryById(int id){
        return bankHistoryRepository.getHistoryById(id);
    }

    // Get account by client ID
    public List<History> getAccountById(int id) {
        return bankHistoryRepository.getAccountNrByID(id);
    }
}
