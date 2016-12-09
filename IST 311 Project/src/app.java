
import java.util.ArrayList;

//Class for initialization and primary holder of active database and responsibilities
public class app {
  
    //Active database reference for entire program
    public static Database activeDB;
    
    public static  InitialFrame mjf ;
    public static void main(String[] args) {
  
         mjf = new InitialFrame();
        
        
    }
    
    //Assigns active database to application, be it new or loaded from file
    public static void setDatabase(Database toSetDB) {
        activeDB = toSetDB;
    }
    
    public static String getCurrentID(){
        return activeDB.getUserName();
    }
    
    public static void setInvisible()
    {
        mjf.setVisible(false);
    }

    public static ArrayList<Credential> getDBCredentials() {
        return activeDB.getCredentials();
    }
    
    public static void appendCredential(Credential toAdd) {
        activeDB.addNewCredential(toAdd);
    }
}
