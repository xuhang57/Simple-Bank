import java.util.UUID;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class Loan implements Account {

    private double balance;
    private UUID id;
    private Name customerName;

    /**
     * Setup a New Loan with an Empty Balance
     */
    public Loan() {
        this.balance = 0;
        this.id = UUID.randomUUID();
    }

    /**
     * Setup a New Loan with a Provided Balance
     * @param balance
     */
    public Loan(double balance) {
        this.balance = balance;
        this.id = UUID.randomUUID();
    }

    /**
     * Setup a New Loan with a Provided Name and Balance
     * @param name : Name
     * @param balance : double
     */
    public Loan(Name name, double balance) {
        this.balance = balance;
        this.id = UUID.randomUUID();
        this.customerName = name;
    }

    /**
     * Get the Current Balance in this Account
     *
     * @return this.balance : double
     */
    @Override
    public double getBalance() {
        return this.balance;
    }

    /**
     * Return the Interest Rate in this Loan Account
     *
     * @return 0 : double
     */
    @Override
    public double getInterestRate() {
        return LOAN_RATE;
    }

    /**
     * There is an Interest Rate in this Loan Account
     *
     * @return 0 : double
     */
    @Override
    public boolean hasInterest() {
        return true;
    }

    /**
     * Return UUID of this Loan
     *
     * @return id : UUID
     */
    @Override
    public UUID getAcctId() {
        return this.id;
    }

    /**
     * Return the Customer Name of this Loan
     *
     * @return customerName: Name
     */
    @Override
    public Name getCustomerName() {
        return this.customerName;
    }

    /**
     * Set the Customer Name of this Loan
     *
     * @return boolean
     */
    @Override
    public boolean setCustomerName(Name name) {
        this.customerName = name;
        return true;
    }

    /**
     * Return the type of this Account
     * @return String
     */
    @Override
    public String getAcctType() {
        return Loan;
    }

    @Override
    public String toString() {
        return "This Loan account has unpaid balance: " + this.balance;
    }
}
