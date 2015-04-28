/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
//import java.util.Base64;
//import com.openshift.client.utils.Base64Coder;
import java.util.Random;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Eric
 */
public class PWUtil {
    
    public PWUtil(){
        
    }
    
    public static String hashPassword(String pw) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(pw.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder sb = new StringBuilder(mdArray.length *2);
        for(int x=0; x<mdArray.length; x++){
            int v = mdArray[x] & 0xff;
            if(v<16){
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }
    
    public String getSalt(){
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
        return DatatypeConverter.printBase64Binary(saltBytes);
//        return Base64.getEncoder().encodeToString(saltBytes);
    }
    
    public String hashAndSaltPassword(String pw) throws NoSuchAlgorithmException{
        String salt = getSalt();
        return hashPassword(pw + salt);
    }
    
    public String hashAndSaltPassword(String salt, String pw) throws NoSuchAlgorithmException{
        return hashPassword(pw + salt);
    }
    
}
