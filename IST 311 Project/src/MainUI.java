
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.String;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MainUI extends JFrame implements ActionListener,TableModelListener{
  
    private static ArrayList<Credential> tableCreds = app.getDBCredentials();
    private static String[] credsToDisplay;
    private static DefaultTableModel model;
  
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 400;
    private static boolean changed = false;
    private JButton CreateNewCredential;
    private JButton Logout;
    private JFrame ui;
    private JPopupMenu pm;
    private static JTable table;
    private static JButton save;
    private JMenuItem d;
    private JButton search;
    public MainUI() throws GeneralSecurityException, UnsupportedEncodingException {

    app.createCrypt();
    setCredDisplay();
    save = new JButton("Save");
    save.setEnabled(false);
    save.addActionListener(this);
    
    table = new JTable(model);
    getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
    table.getModel().addTableModelListener(this);
    //Create new credential handling
    CreateNewCredential = new JButton("Create New Credential");
    
    CreateNewCredential.addActionListener(new ActionListener() {
          @Override
          
          public void actionPerformed(ActionEvent ae) {
             new NewCredentialUI().setVisible(true);
             
          }
    });
    search = new JButton("Search");
    //Logout handling
    Logout = new JButton("Logout");
    
    Logout.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int answer = JOptionPane.showConfirmDialog (null, "Would You Like to Save your credentials?","Warning",JOptionPane.YES_NO_CANCEL_OPTION);
            if(answer==JOptionPane.YES_OPTION)
            {
                savingCredential();
                ui.dispose();
                 app.main(new String[0]);
            }
            else if (answer ==JOptionPane.NO_OPTION)
            {
                ui.dispose();
                 app.main(new String[0]);
            }
            else if (answer == JOptionPane.CANCEL_OPTION)
            {
                
            }
        }
    } 
   );
       
    JPanel jp = new JPanel();
    jp.add(CreateNewCredential);
    jp.add(Logout);
    jp.add(save);
    jp.add(search);
    search.addActionListener(this);

    
    pm = new JPopupMenu();
    d = new JMenuItem("Deleted");
    pm.add(d);
    d.addActionListener(this);    
    table.setComponentPopupMenu(pm);
    table.setCellSelectionEnabled(true);
    ListSelectionModel cellSelectionModel = table.getSelectionModel();
    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    
    ui = this;
    

    
    
    this.add(jp, BorderLayout.SOUTH);
    this.setTitle("Password Manager");
    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
    
    private static void updateTableCreds(){
        tableCreds = app.getDBCredentials();
    }
    
    public static void setCredDisplay(){
        updateTableCreds();
        
           // String[][] displayingCreds = {{""}};
        String [] info = null;
        if(tableCreds.size() > 0) 
        {
           for(int i = 0;i<tableCreds.size();i++)
           {
                info = new String[4];
               for(int j = 0;j<tableCreds.get(i).getPartialCredInfo().size();j++)
               //model.setValueAt(tableCreds.get(i).getPartialCredInfo().get(j),i,j);
               {info[j] = tableCreds.get(i).getPartialCredInfo().get(j);}
                  
                addRows(info[0],info[1],info[2],info[3]);
           }
           
        }
        model = new DefaultTableModel(null, new Object[] {"ID", "Title", "Username", "Password" });
       
    }
    
    
    
    public void rmRows() throws ArrayIndexOutOfBoundsException
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                app.activeDB.getCredentials().remove(table.getSelectedRow());
                model.removeRow(table.getSelectedRow());
                System.out.println(table.getSelectedRow());
                
                save.setEnabled(true);
                changed = true;
            }
            
        });
                
   
    }
    public static void addRows(String id,String title,String userName,String password)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                model.addRow(new Object[]{id,title,userName,password} );
                save.setEnabled(true);
                changed = true;
            }
            
        });
                
   
    }
    @Override

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==d)
        {rmRows();}
        else if(e.getSource()==save)
        {
            savingCredential();
            save.setEnabled(false);
            changed = false;
        }
        else if(e.getSource()==search)
        {
            String id = JOptionPane.showInputDialog(null, "Enter Username:", "Searching",JOptionPane.QUESTION_MESSAGE);
            search(id);
        }
        
    }

    private void savingCredential() {
        try
        {
            FileOutputStream fos = new FileOutputStream(app.activeDB.getUserName()+".ser");
            ObjectOutputStream oos = new ObjectOutputStream (fos);
            oos.writeObject(app.activeDB);
            oos.close();
            fos.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Cant be save!", "Fetal Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    
    }

    @Override
    public  void tableChanged(TableModelEvent e) {


                            int row = e.getFirstRow();
                            int col = e.getColumn();
                            if(row<0||col<0)
                            {
                                return;
                            }
        try {
            // System.out.println(row + " " + col);
            updateArrayList(row,col);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
                            save.setEnabled(true);
                            changed = true;
             }
             


  


    private void updateArrayList(int row, int col) throws FileNotFoundException, IOException, GeneralSecurityException {
        if(col == 0)
        {
           app.activeDB.getCredentials().get(row).setID(table.getValueAt(row, col).toString());
        }
        if(col == 1)
        {
            app.activeDB.getCredentials().get(row).setCredentialTitle(table.getValueAt(row, col).toString());
        }
        if(col == 2)
        {
            app.activeDB.getCredentials().get(row).setUserName(table.getValueAt(row, col).toString());
        }
        if(col == 3)
        {
            app.activeDB.getCredentials().get(row).setCredentialPassword(new Password(table.getValueAt(row, col).toString()));
        }
    }

    private void search(String id) {
        boolean found = false;
        for(int i = 0; i< app.activeDB.getCredentials().size();i++)
        {
            if(app.activeDB.getCredentials().get(i).getUserName().equals(id))
            {
                new searchResult(app.activeDB.getCredentials().get(i).toString());
                found = true;
            }
            
        }
        if (!found)
            JOptionPane.showMessageDialog(null, "No such credentials", "Not found", JOptionPane.PLAIN_MESSAGE);
    }




}