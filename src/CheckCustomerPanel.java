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
public class CheckCustomerPanel extends JFrame implements ActionListener {

    private Map<Long, List<Transaction>> transactions;
    private Long phoneNumber;

    private static final int WIDTH = 150;
    private static final int HEIGHT = 20;
    private JLabel transLabel;
    private JButton returnBtn;

    private JTextArea transArea;
    private PrintStream standardOut;

    private static final String RETURN_LABEL = "Return";

    public CheckCustomerPanel(int frameWidth, int frameHeight,
                              Map<Long, List<Transaction>> transactions,
                              Map<Long, Customer> customers,
                              Long phoneNumber) {
        super("Check Customer Panel");

        Name customerName = new Name("Unknown");
        if (phoneNumber != null && customers.containsKey(phoneNumber)) {
            customerName = customers.get(phoneNumber).getName();
        }
        transLabel = new JLabel(customerName + "'s Transactions");
        transLabel.setBounds(50,15,WIDTH,HEIGHT);


        transArea = new JTextArea();
        transArea.setBounds(50, 50, 400, 400);
        transArea.setEditable(false);

        // Keep the Standard Output
        this.standardOut = System.out;

        PrintStream printStream = new PrintStream(new CustomOutputStream(transArea));
        System.setOut(printStream);
        System.setErr(printStream);

        returnBtn = new JButton(RETURN_LABEL);
        returnBtn.setBounds(250, 15, WIDTH, HEIGHT);

        returnBtn.addActionListener(this);

        add(transLabel);
        add(transArea);
        add(returnBtn);

        this.transactions = transactions;
        this.phoneNumber = phoneNumber;

        getTransactions();

        setSize(frameWidth,frameHeight);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void getTransactions() {
        if (this.phoneNumber == null) {
            System.out.println("Please type a Phone Number");
        } else {
            if (this.transactions == null) {
                System.out.println("We just opened today! Come back later");
            } else {
                if (this.transactions.containsKey(this.phoneNumber)) {
                    List<Transaction> allTrans = this.transactions.get(this.phoneNumber);
                    for (Transaction tran: allTrans) {
                        System.out.println(tran);
                    }
                } else {
                    System.out.println("Customer does not exist");
                }
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
