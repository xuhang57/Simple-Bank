import java.util.List;
import java.util.UUID;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
interface Account {
    /** static final interest rate */
    double INTEREST_RATE = 0.02;
    double INTEREST_MINIMUM_BALANCE = 300;
    double LOAN_RATE = 0.2;

    String CHECKING = "Checking";
    String SAVING = "Saving";
    String Loan = "Loan";

    /**
     * Return the balance in the account
     *
     * @return double
     */
    double getBalance();

    /**
     * Return the balance in the account
     *
     * @param currency: Currency
     * @return double
     */
    double getBalance(Currency currency);

    /**
     * Return the interest rate in the account
     *
     *  @return double
     */
    double getInterestRate();

    /**
     * Return whether this account needs to pay interest to the customers
     *
     * @return boolean
     */
    boolean hasInterest();

    /**
     * Return the ID of this Account
     *
     * @return int
     */
    UUID getAcctId();

    /**
     * Return the Customer Name of this Account
     * @return Name
     */
    Name getCustomerName();

    /**
     * Set the Customer Name of this Account
     * @param name: Name
     * @return boolean
     */
    boolean setCustomerName(Name name);

    /**
     * Return Account Type as a String
     * @return String
     */
    String getAcctType();
}
