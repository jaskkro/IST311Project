
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.GeneralSecurityException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Big Bertha
 */
public class Password implements Serializable{
    
    private String value;
    private String oldValue = "";
    private String name;
    private static Integer currentCt = 0;
    
    public Password(String val) throws FileNotFoundException, IOException, GeneralSecurityException{
        value = val;
        name = app.activeDB.getUserName() + currentCt.toString();
        currentCt++;
        writeToFile();
    }
    
    //Returns password value as a string
    public String getPassword() throws IOException, GeneralSecurityException{
        app.encrypter.decrypt(name + ".txt", name + ".txt");
        FileReader load = new FileReader(name + ".txt");
        BufferedReader bufferedLoad = new BufferedReader(load);
        value = bufferedLoad.readLine();
        bufferedLoad.close();
        app.encrypter.encrypt(2, name + ".txt", name + ".txt");
        return value;
    }
    
    //Use when checking any previous value (not yet)
    public String getOldPassword(){
        if (oldValue.equals(""))
            return "N/A";
        return oldValue;
    }
    
    private void writeToFile() throws FileNotFoundException, IOException, GeneralSecurityException {
        PrintWriter save = new PrintWriter(name + ".txt");
        save.print(value);
        save.close();
        app.encrypter.encrypt(2, name + ".txt", name + ".txt");
        value = null;
    }
    
    
}
