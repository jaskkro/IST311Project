
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class searchResult {
    private JFrame f;
    private JTextArea jta;
    public searchResult(String info)
    {
        f = new JFrame("Result");
        f.setSize(300,300);
        
        jta = new JTextArea(info);
        jta.setEditable(false);
        
        f.add(jta);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
    }
}
