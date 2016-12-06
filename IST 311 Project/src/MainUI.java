import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainUI extends JFrame {
  DefaultTableModel model = new DefaultTableModel(new Object[][] {
      { "some", "text", "fill", "in" }, { "any", "text", "for" ,"credentials" }, { "even", "more" },
      { "text", "strings" }, { "and", "other" }, { "text", "values" } },
      new Object[] { "Username", "Password","Type","Notes" });
  private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 400;
  private JButton CreateNewCredential;
  private JButton Logout;

  public MainUI() {
    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTable table = new JTable(model);
    getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
    CreateNewCredential = new JButton("Create New Credential");
    CreateNewCredential.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
             new NewCredentialUI().setVisible(true);
          }
    });
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
}