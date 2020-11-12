package ee.bcs.valiit.tasks.BankController2.TestBankRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankClient {

    @Id                                                  // See @ käib järgmise reaga kaasas
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Ütleb, et id on auto-incremented. Kehtib kuni ";"
    private int id;
    private String firstName;
    private String lastName;

    public BankClient() {

    }

    public BankClient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
