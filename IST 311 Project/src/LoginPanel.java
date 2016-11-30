
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author Ben
 */
public class LoginPanel extends JPanel implements ActionListener {

    //access to database
    private Database loginDB;

    private JTextField username;
    private JPasswordField password;

    private JLabel u;
    private JLabel p;

    private JButton submit;
    private JButton newUser;

    public LoginPanel() {
        //databse access
        this.loginDB = loginDB;

        //initilizing
        setBackground(Color.LIGHT_GRAY);

        //Jtextfields
        username = new JTextField(20);
        password = new JPasswordField(20);

        //JLabels
        u = new JLabel("Username:");
        p = new JLabel("Password:");

        //Jbuttons
        submit = new JButton("Submit");
        newUser = new JButton("New User");

        //add
        add(u);
        add(username);
        add(p);
        add(password);
        add(submit);
        add(newUser);

        submit.addActionListener(this);
        newUser.addActionListener(this);

    }

    private String getUsername() {
        String temp_user = username.getText();
        return temp_user;
    }

    private String getPassword() {
        String temp_pass = password.getText();
        return temp_pass;
    }

    public void verifyDB(Database DB) {
        DB.verifyLoginCredentials(getUsername(), getPassword());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newUser) {
            new NewUser().setVisible(true);
        }
        if (ae.getSource() == submit) {
            //TODO: take data from jtextfield and passwordfield, respectively
            verifyDB(loginDB);
        }
    }
}
