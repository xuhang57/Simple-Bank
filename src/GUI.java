import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class GUI implements ActionListener {

    public void start() {
        CustomerPanel customerPanel = new CustomerPanel();
        customerPanel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
