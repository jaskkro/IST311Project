import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ethan
 */
public class NewCredentialUI extends JFrame implements ActionListener{
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 450;
    private MainUI Main;
    private JButton CreateCredential;
    private JButton GenPassword;
    private JButton Cancel;
    
    private JLabel CredentialTypeLabel;
    private JTextField CredentialType;
    private JLabel UsernameCredentialLabel;
    private JTextField CredentialUsername;
    
    private JLabel CredentialPasswordLabel;
    private JTextField CredentialPassword;
    
    private JLabel CredentialEmailLabel;
    private JTextField CredentialEmail;

    private JLabel CredentialUserNoteLabel;
    private JTextField CredentialNote;
    
    /**
     * Creates new form NewJFrame
     */
    public NewCredentialUI() {
            this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            this.setVisible(true);
            
            //TextFields
            CredentialUsername = new JTextField(20);
            CredentialPassword = new JTextField(20);
            CredentialType = new JTextField(20);
            CredentialEmail = new JTextField(20);
            CredentialNote = new JTextField(20);
            
            //JLabels
            UsernameCredentialLabel = new JLabel("Username:");
            CredentialPasswordLabel = new JLabel("Password:");
            CredentialTypeLabel = new JLabel("Type:");
            CredentialEmailLabel = new JLabel("Email:");
            CredentialUserNoteLabel = new JLabel("Notes:");
            
            //Jbuttons
            CreateCredential = new JButton("Submit");
            Cancel = new JButton("Cancel");
            GenPassword = new JButton("Generate Random Password");
            CreateCredential.addActionListener(this);
            GenPassword.addActionListener(this);
            Cancel.addActionListener(this);
            this.add(createPanel());
            
            
            

        
    }
    private JPanel createPanel() 
	{
		JPanel panel = new JPanel(new GridLayout(6,2));
                panel.add(UsernameCredentialLabel);
		panel.add(CredentialUsername);
                panel.add(CredentialPasswordLabel);
                panel.add(CredentialPassword);
                panel.add(CredentialTypeLabel);
                panel.add(CredentialType);
                panel.add(CredentialEmailLabel);
                panel.add(CredentialEmail);
                panel.add(CredentialUserNoteLabel);
		panel.add(CredentialNote);
                panel.add(CreateCredential);
                panel.add(GenPassword);
		return panel;
	}
    
         
        public void actionPerformed(ActionEvent ac) {
             if(ac.getSource()== CreateCredential)
            {
                 String credentialType = CredentialType.getText();
                 String username = CredentialUsername.getText();
                 String email = CredentialEmail.getText();
                 String credentialPassword = CredentialPassword.getText();
                 String note = CredentialNote.getText();
                 Credential credential = new Credential(credentialType, username, email, new Password(credentialPassword), note);
             }
             //password button listener
             if(ac.getSource()== GenPassword)
             {
                 String temp_gen = genRandomPwd();
                CredentialPassword.setText(temp_gen);
             }          
        }
        
    public static String genRandomPwd() {

        final int maxNum = 62;
        int i;
        int count = 0;
        char[] str = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < 15) {

            i = Math.abs(r.nextInt(maxNum));

            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }

        return pwd.toString();
    }
}






