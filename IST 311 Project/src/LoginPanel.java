;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
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
    private InitialFrame f;
    public LoginPanel() {
        
        //initilizing
        setBackground(Color.LIGHT_GRAY);

        //Jtextfields
        username = new JTextField(20);
        password = new JPasswordField(20);

        //JLabels
        u = new JLabel("Username:");
        p = new JLabel("Password:");

        //Jbuttons
        submit = new JButton("Log In");
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

    public void verifyDB() {
    	if (getInfo()==1)
    	{
    		app.setInvisible();
    		new MainUI().setVisible(true);
    	}
        else if (getInfo() == 2)
        {
            JOptionPane.showMessageDialog(null, "Your credential does not match","Authentication Failed",JOptionPane.ERROR_MESSAGE);
        }
        else if (getInfo() == 3)
        {
             JOptionPane.showMessageDialog(null, "No Such User", "Fetal Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(getInfo() == 4)
        {
            JOptionPane.showMessageDialog(null,"Cant read the file","Fetal Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newUser) {
            new NewUser().setVisible(true);
        }
        if (ae.getSource() == submit) {
            //TODO: take data from jtextfield and passwordfield, respectively
        	//databse access
        	//this.loginDB = NewUser.database;
                if(username.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "You did not enter account", "warning", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(String.valueOf(password.getPassword()).equals(""))
                {
                    JOptionPane.showMessageDialog(null, "You did not enter password", "warning", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                verifyDB();
        }
    }

    //Deser to get the validate user information
    private int getInfo() {
        
        Database db = null;
        try
        {
            FileInputStream fi = new FileInputStream (getUsername()+".ser");
            ObjectInputStream oi = new ObjectInputStream(fi);
            db = (Database)oi.readObject();
            oi.close();
            fi.close();
        }
        catch(FileNotFoundException e)
        {
            return 3;
        }
        catch(Exception en)
        {    
            return 4;
            
        }
        
        
        if(db.verifyLoginCredentials(getUsername(),getPassword()))
        {
            return 1;
        }
        else
            return 2;
    }
}

