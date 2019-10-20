import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class CustomerPanel extends JFrame implements ActionListener {

    private JButton checkingBtn, savingBtn, loanBtn, viewTransBtn, viewBalanceBtn;
    private static final String CHECKING_LABEL = "Open Checking";
    private static final String SAVING_LABEL = "Open Saving";
    private static final String LOAN_LABEL = "Request Loan";
    private static final String TRANSACTION_LABEL = "View Transactions";
    private static final String BALANCE_LABEL = "View Balances";


    public CustomerPanel() {
        super("Customer");

        checkingBtn = new JButton(CHECKING_LABEL);
        checkingBtn.setBounds(10,50,200,40);

        savingBtn = new JButton(SAVING_LABEL);
        savingBtn.setBounds(10,100,200,40);

        loanBtn = new JButton(LOAN_LABEL);
        loanBtn.setBounds(10,150,200,40);

        viewTransBtn = new JButton(TRANSACTION_LABEL);
        viewTransBtn.setBounds(10,200,200,40);

        viewBalanceBtn = new JButton(BALANCE_LABEL);
        viewBalanceBtn.setBounds(10, 250, 200, 40);



        checkingBtn.addActionListener(this);
        savingBtn.addActionListener(this);
        loanBtn.addActionListener(this);
        add(checkingBtn);
        add(savingBtn);
        add(loanBtn);
        add(viewTransBtn);
        add(viewBalanceBtn);
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals(CHECKING_LABEL)) {
            CheckingPanel checkingPanel = new CheckingPanel();
            checkingPanel.setVisible(true);
        } else if (cmd.equals(SAVING_LABEL)) {
            SavingPanel savingPanel = new SavingPanel();
            savingPanel.setVisible(true);
        } else if (cmd.equals(LOAN_LABEL)) {
            LoanPanel loanPanel = new LoanPanel();
            loanPanel.setVisible(true);
        }
    }
}
