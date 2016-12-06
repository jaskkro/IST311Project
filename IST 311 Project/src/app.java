public class app {
  
    private static Database activeDB;
    public static  InitialFrame mjf ;
    public static void main(String[] args) {
  
         mjf = new InitialFrame();
        
        
    }
    
    public static void setDatabase(Database newdb) {
        activeDB = newdb;
    }
    
    public static void setInvisible()
    {
        mjf.setVisible(false);
    }
}
