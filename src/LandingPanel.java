import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class LandingPanel extends JFrame implements ActionListener {

    private int frameWidth, frameHeight;
    private Map<Long, Customer> customers = new HashMap<>();
    private Map<Long, List<Transaction>> transactions = new HashMap<>();
    private Map<Long, List<Account>> accounts = new HashMap<>();


    private JLabel landingLabel;
    private JButton managerBtn, customerBtn;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 40;
    private static final String MANAGER = "Manager";
    private static final String CUSTOMER = "Customer";

    /**
     * The Landing Frame determining whether shows the Manager Panel or the Customer Panel to the user
     * @param frameWidth: int
     * @param frameHeight: int
     */
    public LandingPanel(int frameWidth, int frameHeight) {
        super("Fancy Bank");

        landingLabel = new JLabel("Are you a Manager or a Customer?");
        landingLabel.setBounds(50, 15, WIDTH, HEIGHT);

        managerBtn = new JButton(MANAGER);
        managerBtn.setBounds(50, 100, WIDTH, HEIGHT);

        customerBtn = new JButton(CUSTOMER);
        customerBtn.setBounds(50, 185, WIDTH, HEIGHT);

        managerBtn.addActionListener(this);
        customerBtn.addActionListener(this);

        add(landingLabel);
        add(managerBtn);
        add(customerBtn);

        setSize(frameWidth,frameHeight);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    /**
     * ActionListener's Handler
     * @param e : ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        //System.out.println(this.customers);
        if (cmd.equals(MANAGER)) {
            ManagerPanel managerPanel = new ManagerPanel(this.frameWidth, this.frameHeight,
                    this.customers, this.transactions, this.accounts);
            managerPanel.setVisible(true);
        } else {
            CustomerPanel customerPanel = new CustomerPanel(this.frameWidth, this.frameHeight,
                    this.customers, this.transactions, this.accounts);
            customerPanel.setVisible(true);
        }
    }
}
