import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class Loan implements Account {

    private Money balance;
    private UUID id;
    private Name customerName;
    private LocalDate openDate;

    /**
     * Setup a New Loan with an Empty Balance
     */
    public Loan() {
        this.balance = new Money(0);
        this.id = UUID.randomUUID();
        this.openDate = LocalDate.now();
    }

    /**
     * Setup a New Loan with a Provided Balance
     * @param balance
     */
    public Loan(double balance) {
        this.balance = new Money(balance);
        this.id = UUID.randomUUID();
        this.openDate = LocalDate.now();
    }

    /**
     * Setup a New Loan with a Provided Name and Balance
     * @param name : Name
     * @param balance : double
     */
    public Loan(Name name, double balance) {
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
     * @return this.balance : double
     */
    @Override
    public double getBalance(Currency currency) {
        return this.balance.getAmount(currency);
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

    /**
     * Return how to print this object
     * @return String
     */
    @Override
    public String toString() {
        return "This Loan account has unpaid balance:\n" + this.balance;
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
