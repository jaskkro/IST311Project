
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Big Bertha
 */
public class Database {
    
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    private ArrayList<Credential> credentials;
    
    public Database(String fn, String ln, String un, String pw, String q, String a) {
        
        firstName = fn;
        lastName = ln;
        userName = un;
        password = pw;
        securityQuestion = q;
        securityAnswer = a;
        credentials = new ArrayList<>();
    }
    
    //When logging into program, check username and password validity with this
    public boolean verifyLoginCredentials(String us, String pw) {
        return us.equals(userName) && pw.equals(password);
    }
    
    //First step in displaying credentials on Main Menu, use along with getCredential calls in for loop.
    public ArrayList<Credential> getCredentials() {
        return credentials;
    }
    
    //Call this when adding a created credential to the active database in App
    public void addNewCredential(Credential toAdd) {
        credentials.add(toAdd);
    }
}
