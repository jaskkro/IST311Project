
import java.security.SecureRandom;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
class GeneratePwd {
            
    public static String genRandomPwd() {

    final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz~!@#$%^&*()_";
    SecureRandom rnd = new SecureRandom();
        StringBuffer sb = new StringBuffer(16);
        Random r = new Random();
    for( int i = 0; i < 16; i++ ) 
      sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
