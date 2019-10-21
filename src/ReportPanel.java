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
public class ReportPanel extends JFrame implements ActionListener {
    private Map<Long, List<Transaction>> transactions;

    private static final int WIDTH = 150;
    private static final int HEIGHT = 20;
    private JLabel transLabel;
    private JButton returnBtn;

    private JTextArea transArea;
    private PrintStream standardOut;

    private static final String RETURN_LABEL = "Return";

    public ReportPanel(int frameWidth, int frameHeight,
                       Map<Long, List<Transaction>> transactions) {
        super("Fully Report Panel");

        transLabel = new JLabel("All Transactions Today");
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

        getAllTransactions();

        setSize(frameWidth,frameHeight);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void getAllTransactions() {
        if (this.transactions == null) {
            System.out.println("No Transaction at the Moment");
        } else {
            for (Map.Entry<Long, List<Transaction>> entry: this.transactions.entrySet()) {
                List<Transaction> allTrans = entry.getValue();
                for (Transaction tran: allTrans) {
                    System.out.println(tran);
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
