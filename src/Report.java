import java.util.List;
import java.util.Map;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class Report {
    private Map<Long, List<Transaction>> transactions;
    private Map<Long, Customer> customers;

    public Report(Map<Long, List<Transaction>> transactions, Map<Long, Customer> customers) {
        this.transactions = transactions;
        this.customers = customers;
    }

    /**
     * Generate a Daily Report, including all transactions
     */
    public void dailyReport() {
        for (Map.Entry<Long, Customer> entry: this.customers.entrySet()) {
            long phoneNumber = entry.getKey();
            Customer customer = entry.getValue();
            Name customerName = customer.getName();
            if (this.transactions.containsKey(phoneNumber)) {
                List<Transaction> allTrans = this.transactions.get(phoneNumber);
                for (Transaction trans: allTrans) {
                    System.out.println("Customer " + customerName + "has " + trans);
                }

            } else {
                System.out.println("Customer " + customerName + " has no transaction");
            }
        }
        System.out.println("All transactions shown above!");
    }
}
