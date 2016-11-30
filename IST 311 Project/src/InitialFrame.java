import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ben
 */

public class InitialFrame extends JFrame {

    public InitialFrame() {
        super("PManagement");

        LoginPanel lp = new LoginPanel();
        add(lp);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 150);
        setResizable(false);
        setVisible(true);
    }

}
