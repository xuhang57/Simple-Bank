import java.util.UUID;
/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class CheckingAccount implements Account {
    private Money balance;
    private UUID id;
    private Name customerName;
    private static final String ACCT_TYPE = "Checking";

    /**
     * Setup a New Account with an Empty Balance
     */
    public CheckingAccount() {
        this.balance = new Money(0);
        this.id = UUID.randomUUID();
    }

    /**
     * Setup a New Account with a Provided Balance
     * @param balance
     */
    public CheckingAccount(double balance) {
        this.balance = new Money(balance);
        this.id = UUID.randomUUID();
    }

    /**
     * Setup a New Account with a Provided Name and Balance
     * @param name : Name
     * @param balance : double
     */
    public CheckingAccount(Name name, double balance) {
        this.balance = new Money(balance);
        this.id = UUID.randomUUID();
        this.customerName = name;
    }

    /**
     * Get the Current Balance in this Account using default USD currency
     *
     * @return this.balance : double
     */
    @Override
    public double getBalance() {
        return this.balance.getAmount(Currency.USD);
    }

    /**
     * Get the Current Balance in this Account
     *
     * @param: currency: Currency
     * @return this.balance : double
     */
    @Override
    public double getBalance(Currency currency) {
        return this.balance.getAmount(currency);
    }

    /**
     * No Interest Rate in a Checking Account
     *
     * @return 0 : double
     */
    @Override
    public double getInterestRate() {
        return 0;
    }

    /**
     * Checking Account Does not Pay Interests;
     *
     * @return false : boolean
     */
    @Override
    public boolean hasInterest() {
        return false;
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
        // Currently, we do not do any validation here. But in the future, we can extend this method.
        return true;
    }

    /**
     * Return the type of this Account
     * @return String
     */
    @Override
    public String getAcctType() {
        return CHECKING;
    }

    @Override
    public String toString() {
        return "This Checking account has balance: " + this.balance;
    }

}
