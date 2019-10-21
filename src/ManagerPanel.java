import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class ManagerPanel extends JFrame implements ActionListener {

    private int frameWidth, frameHeight;
    private Map<Long, Customer> customers;
    private Map<Long, List<Transaction>> transactions;
    private Map<Long, List<Account>> accounts;

    private JLabel phoneNumberLabel;
    private JTextField phoneNumberField;
    private JButton checkCustomerBtn, viewFullyReportBtn, viewUpdatedReportBtn, returnBtn;
    private static final int WIDTH = 240;
    private static final int HEIGHT = 40;
    private static final String CHECK_LABEL = "Check a Customer";
    private static final String FULLY_LABEL = "View a Fully Daily Report";
    private static final String UPDATE_LABEL = "View a Updated Daily Report";
    private static final String RETURN_LABEL = "Return to Landing";
    private static final String PHONE_LABEL = "Customer Phone Number";

    public ManagerPanel(int frameWidth, int frameHeight, Map<Long, Customer> customers,
                        Map<Long, List<Transaction>> transactions, Map<Long, List<Account>> accounts) {
        super("Manager Panel");

        viewFullyReportBtn = new JButton(FULLY_LABEL);
        viewFullyReportBtn.setBounds(10, 50, WIDTH, HEIGHT);

        checkCustomerBtn = new JButton(CHECK_LABEL);
        checkCustomerBtn.setBounds(10, 100, WIDTH, HEIGHT);

        phoneNumberLabel = new JLabel(PHONE_LABEL);
        phoneNumberLabel.setBounds(280, 50, 200, HEIGHT);

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(280, 100, 200, HEIGHT);

        viewUpdatedReportBtn = new JButton(UPDATE_LABEL);
        viewUpdatedReportBtn.setBounds(10, 150, WIDTH, HEIGHT);

        returnBtn = new JButton(RETURN_LABEL);
        returnBtn.setBounds(10, 200, WIDTH, HEIGHT);

        returnBtn.addActionListener(this);
        viewFullyReportBtn.addActionListener(this);
        checkCustomerBtn.addActionListener(this);

        add(checkCustomerBtn);
        add(viewFullyReportBtn);
        add(phoneNumberField);
        add(phoneNumberLabel);
        add(viewUpdatedReportBtn);
        add(returnBtn);

        setSize(frameWidth, frameHeight);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.customers = customers;
        this.accounts = accounts;
        this.transactions = transactions;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals(RETURN_LABEL)) {
            setVisible(false);
        } else if (cmd.equals(FULLY_LABEL)) {
            ReportPanel reportPanel = new ReportPanel(this.frameWidth, this.frameHeight, this.transactions);
            reportPanel.setVisible(true);
        } else if (cmd.equals(CHECK_LABEL)) {
            Long phoneNumber = null;
            if (this.phoneNumberField.getText().length() != 0) {
                phoneNumber = Long.parseLong(this.phoneNumberField.getText());
            }
            CheckCustomerPanel checkCustomerPanel = new CheckCustomerPanel(this.frameWidth, this.frameHeight,
                    this.transactions, this.customers, phoneNumber);
            checkCustomerPanel.setVisible(true);
        }

    }
}