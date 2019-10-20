import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class CheckingPanel extends JFrame implements ActionListener {
    private JLabel firstNameLabel, lastNameLabel, phoneNumberLabel, amountLabel;
    private JTextField firstNameField, lastNameField, phoneNumberField, amountField;
    private JButton createBtn;
    private static final int WIDTH = 150;
    private static final int HEIGHT = 20;

    public CheckingPanel() {
        super("Open a new Checking Account");

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

        amountLabel = new JLabel("Deposit Amount");
        amountLabel.setBounds(50,165,WIDTH,HEIGHT);
        amountField = new JTextField();
        amountField.setBounds(50,190,WIDTH,HEIGHT);

        createBtn = new JButton("Open");
        createBtn.setBounds(250,100,100,40);

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

        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        System.out.println(amountField.getText());
        setVisible(false);
    }
}
