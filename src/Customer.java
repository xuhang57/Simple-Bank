import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.ArrayList;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class Customer extends AbstractPerson {
    private Map<Long, List<UUID>> allAccounts;

    /**
     * Create a new Customer and recording the Name and Phone Number
     * @param name: Name
     * @param phoneNumber: long
     */
    public Customer(Name name, long phoneNumber) {
        super(name, phoneNumber, false);
        this.allAccounts = new HashMap<>();
        this.allAccounts.put(phoneNumber, new ArrayList<>());
    }

    /**
     * Open a Checking Account for this Customer
     * @param depositMoney
     * @return checking: Account
     */
    public Account openChecking(double depositMoney) {
        Account checking = new CheckingAccount(this.getName(), depositMoney);
        this.allAccounts.get(this.getPhoneNumber()).add(checking.getAcctId());
        return checking;
    }

    /**
     * Open a Saving Account for this Customer
     * @param depositMoney
     * @return saving: Account
     */
    public Account openSaving(double depositMoney) {
        Account saving = new SavingAccount(this.getName(), depositMoney);
        this.allAccounts.get(this.getPhoneNumber()).add(saving.getAcctId());
        return saving;
    }

    /**
     *  Request a Loan for this Customer
     * @param loanAmount: double
     * @return loan: Loan (Account)
     */
    public Loan requestLoan(double loanAmount) {
        Loan loan = new Loan(this.getName(), loanAmount);
        this.allAccounts.get(this.getPhoneNumber()).add(loan.getAcctId());
        return loan;
    }
}
