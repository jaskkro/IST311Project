import java.awt.*;
import java.awt.event.*;
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
public class NewUser extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 450;
    private JButton CreateUsername;
    private JButton Cancel;
    private JLabel FirstnameLabel;
    private JTextField FirstName;
    private JLabel LastnameLabel;
    private JTextField LastName;
    private JLabel NewUserLabel;
    private JTextField Username;
    private JLabel PasswordLabel;
    private JPasswordField UsernamePassword;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmUsernamePassword;
    private JLabel SecurityQuestionLabel;
    private JTextField SecurityQuestion;
    private JLabel SecurityAnswerLabel;
    private JTextField SecurityAnswer;

    /**
     * Creates new form NewJFrame
     */
    public NewUser() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        FirstName = new JTextField(20);
        LastName = new JTextField(20);
        Username = new JTextField(20);
        UsernamePassword = new JPasswordField();
        confirmUsernamePassword = new JPasswordField();
        SecurityQuestion = new JTextField(20);
        SecurityAnswer = new JTextField(20);

        //JLabels
        FirstnameLabel = new JLabel("First Name:");
        LastnameLabel = new JLabel("Last Name:");
        NewUserLabel = new JLabel("User Name:");
        PasswordLabel = new JLabel("Password:");
        confirmPasswordLabel = new JLabel("Confirm Password:");

        SecurityQuestionLabel = new JLabel("Question:");
        SecurityAnswerLabel = new JLabel("Security Question Answer");

        //Jbuttons
        CreateUsername = new JButton("Submit");
        Cancel = new JButton("Cancel");
        this.add(createPanel()); 
        
        //actionlisteners
        CreateUsername.addActionListener(this);
        Cancel.addActionListener(this);

    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(8, 2));
        panel.add(FirstnameLabel);
        panel.add(FirstName);
        panel.add(LastnameLabel);
        panel.add(LastName);
        panel.add(NewUserLabel);
        panel.add(Username);
        panel.add(PasswordLabel);
        panel.add(UsernamePassword);
        panel.add(confirmPasswordLabel);
        panel.add(confirmUsernamePassword);
        panel.add(SecurityQuestionLabel);
        panel.add(SecurityQuestion);
        panel.add(SecurityAnswerLabel);
        panel.add(SecurityAnswer);
        panel.add(CreateUsername);
        panel.add(Cancel);
        return panel;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == CreateUsername) {

        }
        if (ae.getSource() == Cancel) {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}

