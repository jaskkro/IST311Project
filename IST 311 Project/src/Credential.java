

import java.time.LocalDate;
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
public class Credential {
    
    private String credentialTitle;
    private String userName;
    private String emailAddress;
    private String dateLastUpdated;
    private Password credentialPassword;
    private String note;
    
    public Credential(String ctl, String un, String ea, Password np, String n){
        credentialTitle = ctl;
        userName = un;
        emailAddress = ea;
        LocalDate dlu = LocalDate.now();
        dateLastUpdated = dlu.toString();
        credentialPassword = np;
        note = n;
    }
    
    //This returns the credential information in an array list that can be extracted where needed
    public ArrayList<String> getCredentialInfo(){
        ArrayList<String> credentialsForReturn = new ArrayList<>();
        
        credentialsForReturn.add(credentialTitle);
        credentialsForReturn.add(userName);
        credentialsForReturn.add(emailAddress);
        credentialsForReturn.add(dateLastUpdated);
        credentialsForReturn.add(credentialPassword.getPassword());
        credentialsForReturn.add(note);
        
        return credentialsForReturn;
    }
    
}
