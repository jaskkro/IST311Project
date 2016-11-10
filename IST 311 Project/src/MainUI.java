import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainUI extends JFrame {
  DefaultTableModel model = new DefaultTableModel(new Object[][] {
      { "some", "text", "fill", "in" }, { "any", "text", "for" ,"credentials" }, { "even", "more" },
      { "text", "strings" }, { "and", "other" }, { "text", "values" } },
      new Object[] { "Credential Type", "Credential Username","Credential Password","Credential Custom" });
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
    this.add(CreateNewCredential, BorderLayout.SOUTH);
    
    

  }


}