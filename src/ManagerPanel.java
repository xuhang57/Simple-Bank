import com.sun.org.apache.regexp.internal.RE;

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

    private JButton viewTransBtn, checkCustomerBtn, viewFullyReportBtn, viewUpdatedReportBtn, returnBtn;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 40;
    private static final String TRANS_LABEL = "View All Transactions";
    private static final String CHECK_LABEL = "Check a Customer";
    private static final String FULLY_LABEL = "View a Fully Daily Report";
    private static final String UPDATE_LABEL = "View a Updated Daily Report";
    private static final String RETURN_LABEL = "Return to Landing";

    public ManagerPanel(int frameWidth, int frameHeight, Map<Long, Customer> customers,
                        Map<Long, List<Transaction>> transactions, Map<Long, List<Account>> accounts) {
        super("Manager Panel");

        viewTransBtn = new JButton(TRANS_LABEL);
        viewTransBtn.setBounds(10, 50, WIDTH, HEIGHT);

        checkCustomerBtn = new JButton(CHECK_LABEL);
        checkCustomerBtn.setBounds(10, 100, WIDTH, HEIGHT);

        viewFullyReportBtn = new JButton(FULLY_LABEL);
        viewFullyReportBtn.setBounds(10, 150, WIDTH, HEIGHT);

        viewUpdatedReportBtn = new JButton(UPDATE_LABEL);
        viewUpdatedReportBtn.setBounds(10, 200, WIDTH, HEIGHT);

        returnBtn = new JButton(RETURN_LABEL);
        returnBtn.setBounds(10, 250, WIDTH, HEIGHT);

        returnBtn.addActionListener(this);

        add(viewTransBtn);
        add(checkCustomerBtn);
        add(viewFullyReportBtn);
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
        }

    }
}