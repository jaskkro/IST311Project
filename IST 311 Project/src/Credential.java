

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Big Bertha
 */
public class Credential {
    
    private Integer ID;
    private String credentialTitle;
    private String userName;
    private String emailAddress;
    private String dateLastUpdated;
    private Password credentialPassword;
    private String note;
    
    public Credential(String ctl, String un, String ea, Password np, String n){
        ID = app.getCurrentID();
        credentialTitle = ctl;
        userName = un;
        emailAddress = ea;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateLastUpdated = sdf.format(new Date());
        credentialPassword = np;
        note = n;
    }
    
    //This returns the credential information in an array list that can be extracted where needed
    //All data fields are provided from this method
    public ArrayList<String> getFullCredInfo(){
        ArrayList<String> credentialsForReturn = new ArrayList();
        
        credentialsForReturn.add(ID.toString());
        credentialsForReturn.add(credentialTitle);
        credentialsForReturn.add(userName);
        credentialsForReturn.add(emailAddress);
        credentialsForReturn.add(dateLastUpdated);
        credentialsForReturn.add(credentialPassword.getPassword());
        credentialsForReturn.add(note);
        
        return credentialsForReturn;
    }
    
    //This method provides an appended array list for use in undetailed main UI table
    public ArrayList<String> getPartialCredInfo(){
        ArrayList<String> credentialsForReturn = new ArrayList();
        
        credentialsForReturn.add(ID.toString());
        credentialsForReturn.add(credentialTitle);
        credentialsForReturn.add(userName);
        //credentialsForReturn.add(emailAddress);
        //credentialsForReturn.add(dateLastUpdated);
        credentialsForReturn.add(credentialPassword.getPassword());
        //credentialsForReturn.add(note);
        
        return credentialsForReturn;
    }
    
}
