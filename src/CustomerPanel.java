import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class CustomerPanel extends JFrame implements ActionListener {

    private int frameWidth, frameHeight;
    private Map<Long, Customer> customers;
    private Map<Long, List<Transaction>> transactions;
    private Map<Long, List<Account>> accounts;
    private Customer[] customer;

    private JButton checkingBtn, savingBtn, loanBtn, viewTransBtn, viewBalanceBtn, returnBtn;
    private static final String CHECKING_LABEL = "Open Checking";
    private static final String SAVING_LABEL = "Open Saving";
    private static final String LOAN_LABEL = "Request Loan";
    private static final String TRANSACTION_LABEL = "View Transactions";
    private static final String BALANCE_LABEL = "View Balances";
    private static final String RETURN_LABEL = "Return to Landing";
    private static final int WIDTH = 300;
    private static final int HEIGHT = 40;


    CustomerPanel(int frameWidth, int frameHeight, Map<Long, Customer> customers,
                  Map<Long, List<Transaction>> transactions,
                  Map<Long, List<Account>> accounts, Customer[] customer) {
        super("Customer");

        checkingBtn = new JButton(CHECKING_LABEL);
        checkingBtn.setBounds(10,50,WIDTH, HEIGHT);

        savingBtn = new JButton(SAVING_LABEL);
        savingBtn.setBounds(10, 100, WIDTH, HEIGHT);

        loanBtn = new JButton(LOAN_LABEL);
        loanBtn.setBounds(10,150, WIDTH, HEIGHT);

        viewTransBtn = new JButton(TRANSACTION_LABEL);
        viewTransBtn.setBounds(10,200, WIDTH, HEIGHT);

        viewBalanceBtn = new JButton(BALANCE_LABEL);
        viewBalanceBtn.setBounds(10, 250, WIDTH, HEIGHT);

        returnBtn = new JButton(RETURN_LABEL);
        returnBtn.setBounds(10, 300, WIDTH, HEIGHT);

        checkingBtn.addActionListener(this);
        savingBtn.addActionListener(this);
        loanBtn.addActionListener(this);
        viewTransBtn.addActionListener(this);
        viewBalanceBtn.addActionListener(this);
        returnBtn.addActionListener(this);

        add(checkingBtn);
        add(savingBtn);
        add(loanBtn);
        add(viewTransBtn);
        add(viewBalanceBtn);
        add(returnBtn);

        setSize(frameWidth,frameHeight);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;

        this.customers = customers;
        this.transactions = transactions;
        this.accounts = accounts;
        // Current Customer
        this.customer = customer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals(CHECKING_LABEL)) {
            CheckingPanel checkingPanel = new CheckingPanel(this.frameWidth, this.frameHeight,
                    this.customers, this.transactions, this.accounts, this.customer);
            checkingPanel.setVisible(true);
        } else if (cmd.equals(SAVING_LABEL)) {
            SavingPanel savingPanel = new SavingPanel(this.frameWidth, this.frameHeight,
                    this.customers, this.transactions, this.accounts, this.customer);
            savingPanel.setVisible(true);
        } else if (cmd.equals(LOAN_LABEL)) {
            LoanPanel loanPanel = new LoanPanel(this.frameWidth, this.frameHeight,
                    this.customers, this.transactions, this.accounts, this.customer);
            loanPanel.setVisible(true);
        } else if (cmd.equals(TRANSACTION_LABEL)) {
            TransactionPanel transactionPanel = new TransactionPanel(this.frameWidth, this.frameHeight,
                    this.transactions, this.customer);
            transactionPanel.setVisible(true);
        } else if(cmd.equals(BALANCE_LABEL)) {
            BalancePanel balancePanel = new BalancePanel(this.frameWidth, this.frameHeight,
                    this.accounts, this.customer);
            balancePanel.setVisible(true);
        } else if (cmd.equals(RETURN_LABEL)) {
            setVisible(false);
        }
    }
}
