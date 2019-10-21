import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class BalancePanel extends JFrame implements ActionListener {

    private Map<Long, List<Account>> accounts;
    private Customer[] customer;

    private static final int WIDTH = 150;
    private static final int HEIGHT = 20;
    private JLabel balanceLabel;
    private JButton returnBtn;

    private JTextArea balanceArea;
    private PrintStream standardOut;

    private static final String RETURN_LABEL = "Return";

    public BalancePanel(int frameWidth, int frameHeight,
                        Map<Long, List<Account>> accounts,
                        Customer[] customer) {
        super("Balance Panel");

        balanceLabel = new JLabel("All Transactions");
        balanceLabel.setBounds(50,15,WIDTH,HEIGHT);


        balanceArea = new JTextArea();
        balanceArea.setBounds(50, 50, 400, 400);
        balanceArea.setEditable(false);

        // Keep the Standard Output
        this.standardOut = System.out;

        PrintStream printStream = new PrintStream(new CustomOutputStream(balanceArea));
        System.setOut(printStream);
        System.setErr(printStream);

        returnBtn = new JButton(RETURN_LABEL);
        returnBtn.setBounds(250, 15, WIDTH, HEIGHT);

        returnBtn.addActionListener(this);

        add(balanceLabel);
        add(balanceArea);
        add(returnBtn);

        this.accounts = accounts;
        this.customer = customer;

        getAllBalances();

        setSize(frameWidth,frameHeight);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Return All Balances of current Customer
     */
    void getAllBalances() {
        if (this.customer[0] == null) {
            return;
        }
        if (this.accounts == null) {
            System.out.println("No Balance at the Moment");
        } else {
            long phoneNumber = this.customer[0].getPhoneNumber();
            if (this.accounts.containsKey(phoneNumber)) {
                List<Account> accounts = this.accounts.get(phoneNumber);
                for (Account acct: accounts) {
                    System.out.println(acct);
                }
            } else {
                System.out.println("You have no balance. How about opening a new account?");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals(RETURN_LABEL)) {
            setVisible(false);
        }
    }
}
