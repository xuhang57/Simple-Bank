import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class LoanPanel extends JFrame implements ActionListener {

    private Map<Long, Customer> customers;
    private Map<Long, List<Transaction>> transactions;
    private Map<Long, List<Account>> accounts;
    private Customer[] customer;

    private JLabel firstNameLabel, lastNameLabel, phoneNumberLabel, amountLabel;
    private JTextField firstNameField, lastNameField, phoneNumberField, amountField;
    private JButton createBtn;
    private static final int WIDTH = 150;
    private static final int HEIGHT = 20;
    private static final String REQ_LABEL = "Request Loan";

    public LoanPanel(int frameWidth, int frameHeight, Map<Long, Customer> customers,
                     Map<Long, List<Transaction>> transactions,
                     Map<Long, List<Account>> accounts, Customer[] customer) {
        super("Request a Loan");

        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(50,15,WIDTH,HEIGHT);

        firstNameField = new JTextField();
        firstNameField.setBounds(50,40,WIDTH,HEIGHT);

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(50,65,WIDTH,HEIGHT);

        lastNameField = new JTextField();
        lastNameField.setBounds(50,90,WIDTH,HEIGHT);

        phoneNumberLabel = new JLabel("10 Digit Phone Number");
        phoneNumberLabel.setBounds(50,115,WIDTH,HEIGHT);

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(50,140,WIDTH,HEIGHT);

        amountLabel = new JLabel("Loan Amount");
        amountLabel.setBounds(50,165,WIDTH,HEIGHT);
        amountField = new JTextField();
        amountField.setBounds(50,190,WIDTH,HEIGHT);

        createBtn = new JButton("Request");
        createBtn.setBounds(250,100,WIDTH,HEIGHT);

        createBtn.addActionListener(this);

        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(amountField);
        add(amountLabel);
        add(createBtn);

        setSize(frameWidth,frameHeight);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.customers = customers;
        this.accounts = accounts;
        this.transactions = transactions;
        this.customer = customer;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals(REQ_LABEL)) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            Name customerName = new Name(firstName, lastName);
            String phoneNumberStr= phoneNumberField.getText();
            long phoneNumber = Long.parseLong(phoneNumberStr);
            Customer customer = new Customer(customerName, phoneNumber);
            this.customers.put(phoneNumber, customer);
            String depositAmountStr = amountField.getText();
            double depositAmount = Double.parseDouble(depositAmountStr);
            Loan loan = new Loan(customerName, depositAmount);
            List<Account> account = this.accounts.getOrDefault(phoneNumber, new ArrayList<>());
            account.add(loan);
            this.accounts.put(phoneNumber, account);
            Transaction transaction = new Transaction(customer, loan);
            List<Transaction> trans = this.transactions.getOrDefault(phoneNumber, new ArrayList<>());
            trans.add(transaction);
            this.transactions.put(phoneNumber, trans);
            this.customer[0] = customer;
        }
        setVisible(false);
    }
}
