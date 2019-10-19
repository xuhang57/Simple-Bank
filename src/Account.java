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

    /**
     * Return the balance in the account
     *
     * @return double
     */
    double getBalance();

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

//    /**
//     * Return All Accounts associated with a Customer's phone number
//     * @param phoneNumber: long
//     * @return List<Account>
//     */
//    List<Account> getCustomerAccounts(long phoneNumber);
}