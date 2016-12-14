import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static final int FRAME_WIDTH = 550;
    private static final int FRAME_HEIGHT = 450;
    private MainUI Main;
    private JButton CreateCredential;
    private JButton GenPassword;
    private JButton Cancel;
    
    private JLabel CredentialTypeLabel;
    private JTextField CredentialTitle;
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
            CredentialTitle = new JTextField(20);
            CredentialUsername = new JTextField(20);
            CredentialPassword = new JTextField(20);
            CredentialEmail = new JTextField(20);
            CredentialNote = new JTextField(20);
            
            //JLabels
            CredentialTypeLabel = new JLabel("Title:");
            UsernameCredentialLabel = new JLabel("Username:");
            CredentialPasswordLabel = new JLabel("Password:");
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
            this.setTitle("New Credential");
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                   
    }
    private JPanel createPanel() 
	{
		JPanel panel = new JPanel(new GridLayout(6,2));
                panel.add(UsernameCredentialLabel);
		panel.add(CredentialUsername);
                panel.add(CredentialPasswordLabel);
                panel.add(CredentialPassword);
                panel.add(CredentialTypeLabel);
                panel.add(CredentialTitle);
                panel.add(CredentialEmailLabel);
                panel.add(CredentialEmail);
                panel.add(CredentialUserNoteLabel);
		panel.add(CredentialNote);
                panel.add(CreateCredential);
                panel.add(GenPassword);
		return panel;
	}
    
         //Submit new credential pressed
        public void actionPerformed(ActionEvent ac) {
             if(ac.getSource()== CreateCredential)
            {
                 String credentialTitle = CredentialTitle.getText();
                 String username = CredentialUsername.getText();
                 String email = CredentialEmail.getText();
                 String credentialPassword = CredentialPassword.getText();
                 String note = CredentialNote.getText();
                 if(credentialTitle.equals(""))
                 {
                     JOptionPane.showMessageDialog(null, "You did not enter credential title", "Warning ",JOptionPane.ERROR_MESSAGE);
                     return;
                 }
                  if(username.equals(""))
                 {
                     JOptionPane.showMessageDialog(null, "You did not enter user name", "Warning ",JOptionPane.ERROR_MESSAGE);
                     return;                     
                 }
                  if(email.equals(""))
                 {
                     JOptionPane.showMessageDialog(null, "You did not enter email", "Warning ",JOptionPane.ERROR_MESSAGE);
                     return;                     
                 }
                  if(credentialPassword .equals(""))
                 {
                     JOptionPane.showMessageDialog(null, "You did not enter credential password ", "Warning ",JOptionPane.ERROR_MESSAGE);
                     return;                     
                 }
                  
                
                 Credential credential;
                 try {
                     credential = new Credential(credentialTitle, username, email, new Password(credentialPassword), note);
                     app.appendCredential(credential);
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(NewCredentialUI.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException ex) {
                     Logger.getLogger(NewCredentialUI.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (GeneralSecurityException ex) {
                     Logger.getLogger(NewCredentialUI.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 MainUI.addRows(email,credentialTitle,username,credentialPassword);
                 this.dispose();
                // System.out.println(app.activeDB.getCredentials().toString());
                 //this.Cancel.doClick();


             }
             //password button listener
             if(ac.getSource()== GenPassword)
             {
                 String temp_gen = GeneratePwd.genRandomPwd();
                 CredentialPassword.setText(temp_gen);
             }          
        }

}






