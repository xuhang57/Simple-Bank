import java.time.LocalDate;
import java.util.UUID;

/**
 * Saving Account: provide a interest rate
 *
 * @author Hang Xu
 * @date Fall 2019
 */
public class SavingAccount implements Account {
    private Money balance;
    private UUID id;
    private Name customerName;
    private LocalDate openDate;


    /**
     * Setup a New Account with an Empty Balance
     */
    SavingAccount() {
        this.balance = new Money(0);
        this.id = UUID.randomUUID();
        this.openDate = LocalDate.now();
    }
    /**
     * Setup a New Account with a Provided Balance
     * @param balance: double
     */
    SavingAccount(double balance) {
        this.balance = new Money(balance);
        this.id = UUID.randomUUID();
        this.openDate = LocalDate.now();
    }

    /**
     * Setup a New Account with a Provided Name and Balance
     * @param name : Name
     * @param balance : double
     */
    SavingAccount(Name name, double balance) {
        this.balance = new Money(balance);
        this.id = UUID.randomUUID();
        this.customerName = name;
        this.openDate = LocalDate.now();
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
     * @param currency: Currency
     * @return this.balance : double
     */
    @Override
    public double getBalance(Currency currency) {
        return this.balance.getAmount(currency);
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
     * Using default currency to determine the requirement
     *
     * @return boolean
     */
    @Override
    public boolean hasInterest() {
        return this.balance.getAmount(Currency.USD) >= Account.INTEREST_MINIMUM_BALANCE;
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

    /**
     * Return the type of this Account
     * @return String
     */
    @Override
    public String getAcctType() {
        return SAVING;
    }

    /**
     * Return how to print this Object
     * @return String
     */
    @Override
    public String toString() {
        return "This Saving account has balance:\n" + this.balance;
    }

    /**
     * Return the open date of this Account
     * @return LocalDate
     */
    @Override
    public LocalDate getAccountOpenDate() {
        return this.openDate;
    }
}
