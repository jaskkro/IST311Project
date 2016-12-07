import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.String;

public class MainUI extends JFrame {
  
    private static ArrayList<Credential> tableCreds = app.getDBCredentials();
    private static String[] credsToDisplay;
    private static DefaultTableModel model;
  
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 400;
    
    private JButton CreateNewCredential;
    private JButton Logout;

    public MainUI() {
        
    setCredDisplay();
      
    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTable table = new JTable(model);
    getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
    
    //Create new credential handling
    CreateNewCredential = new JButton("Create New Credential");
    
    CreateNewCredential.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
             new NewCredentialUI().setVisible(true);
          }
    });
    
    //Logout handling
    Logout = new JButton("Logout");
    
    Logout.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null, "Logout Successful");
            System.exit(0);        
        }       
    });
       
    JPanel jp = new JPanel();
    jp.add(CreateNewCredential);
    jp.add(Logout);
    this.add(jp, BorderLayout.SOUTH);
    
  }
    
    private static void updateTableCreds(){
        tableCreds = app.getDBCredentials();
    }
    
    public static void setCredDisplay(){
        updateTableCreds();
        
            String[][] displayingCreds = {{""}};
        if(tableCreds.size() > 0) {
            displayingCreds = new String[tableCreds.size()-1][tableCreds.get(0).getFullCredInfo().size()-1];
            
            for(int i = 0; i < tableCreds.size() - 1; i++) {
                //String[] newCredInfo = new String[tableCreds.get(i).getPartialCredInfo().size()-1];
                //String[] newCredInfo = tableCreds.get(i).getPartialCredInfo().toArray();
                //for(int y = 0; y < tableCreds.get(i).getPartialCredInfo().size()-1; y++) {
                //    newCredInfo = (String[]) tableCreds.get(i).getPartialCredInfo().toArray();
                //}
                String[] holder = {"","","",""};
                displayingCreds[i] = tableCreds.get(i).getPartialCredInfo().toArray(holder);
            }
            
            
            
        }
        model = new DefaultTableModel(displayingCreds, new Object[] {"ID", "Title", "Username", "Password" });
    }
    
    
}