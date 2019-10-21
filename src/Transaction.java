/**
 * @author Hang Xu
 * @date Fall 2019
 *
 * Transaction: an Abstraction of a transaction made by a Customer
 * Currently, we open have three types of transactions:
 * 1. Open a Checking Account
 * 2. Open a Saving Account
 * 3. Request a Loan from the Bank
 */
public class Transaction {
    private Customer customer;
    private Account account;
    private static final String CHECKING = "Checking";
    private static final String SAVING = "Saving";
    private static final String LOAN = "Loan";

    Transaction(Customer customer, Account account) {
        this.customer = customer;
        this.account = account;
    }

    /**
     * Override the print result of a Transaction object.
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("customer name:\n");
        sb.append(this.customer.getName());
        sb.append(" customer phone number:\n");
        sb.append(this.customer.getPhoneNumber());
        sb.append(" customer action:\n");
        if (this.account.getAcctType().equals(CHECKING)) {
            sb.append("Opened a checking account with the id is\n").append(this.account.getAcctId());
            sb.append(" and opened at").append(this.account.getAccountOpenDate());
        }
        if (this.account.getAcctType().equals(SAVING)) {
            sb.append("Opened a saving account with the id is\n").append(this.account.getAcctId());
            sb.append(" and opened at\n").append(this.account.getAccountOpenDate());
        }
        if (this.account.getAcctType().equals(LOAN)) {
            sb.append("Requested a loan with the id is \n").append(this.account.getAcctId());
            sb.append(" and opened at\n").append(this.account.getAccountOpenDate());
        }
        return sb.toString();
    }
}
