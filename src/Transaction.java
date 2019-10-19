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

    public Transaction(Customer customer, Account account) {
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
        sb.append("customer name: ");
        sb.append(this.customer.getName());
        sb.append(" customer phone number: ");
        sb.append(this.customer.getPhoneNumber());
        sb.append(" customer action: ");
        if (this.account.getAcctType() == CHECKING) {
            sb.append("opened a checking account and the id is " + this.account.getAcctId());
        }
        if (this.account.getAcctType() == SAVING) {
            sb.append("opened a saving account and the id is " + this.account.getAcctId());
        }
        if (this.account.getAcctType() == LOAN) {
            sb.append("requested a loan and the id is " + this.account.getAcctId());
        }
        return sb.toString();
    }
}
