import java.util.UUID;

/**
 * Saving Account: provide a interest rate
 *
 * @author Hang Xu
 * @date Fall 2019
 */
public class SavingAccount implements Account {
    private double balance;
    private UUID id;
    private Name customerName;

    /**
     * Setup a New Account with an Empty Balance
     */
    public SavingAccount() {
        this.balance = 0;
        this.id = UUID.randomUUID();
    }
    /**
     * Setup a New Account with a Provided Balance
     * @param balance
     */
    public SavingAccount(double balance) {
        this.balance = balance;
        this.id = UUID.randomUUID();
    }

    /**
     * Setup a New Account with a Provided Name and Balance
     * @param name : Name
     * @param balance : double
     */
    public SavingAccount(Name name, double balance) {
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
     * Saving Account Has a Fixed Interest Rate
     *
     * @return INTEREST_RATE : double
     */
    @Override
    public double getInterestRate() {
        return Account.INTEREST_RATE;
    }

    /**
     * Check the Balance and Determine Whether Pays Interests
     *
     * @return boolean
     */
    @Override
    public boolean hasInterest() {
        return this.balance >= Account.INTEREST_MINIMUM_BALANCE;
    }

    /**
     * Return UUID of this Account
     *
     * @return id : UUID
     */
    @Override
    public UUID getAcctId() {
        return this.id;
    }

    /**
     * Return the Customer Name of this Account
     *
     * @return customerName: Name
     */
    @Override
    public Name getCustomerName() {
        return this.customerName;
    }

    /**
     * Set the Customer Name of this Account
     *
     * @return boolean
     */
    @Override
    public boolean setCustomerName(Name name) {
        this.customerName = name;
        return true;
    }
}