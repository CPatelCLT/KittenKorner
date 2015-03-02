/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_files;

import java.io.Serializable;

/**
 *
 * @author Eric
 */
public class User implements Serializable {
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int postCode;
    private String country;
    
    public User(){
        
    }
    
    public User(String FN, String LN, String EA, String A1, String A2, String C, String S, int PC, String CO){
        firstName=FN;
        lastName=LN;
        emailAddress=EA;
        address1=A1;
        address2=A2;
        city=C;
        state=S;
        postCode=PC;
        country=CO;
    }
    
    public void setFirstName(String fn){
        firstName=fn;
    }    
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setLastName(String ln){
        lastName=ln;
    } 
    
    public String getLastName(){
        return lastName;
    }
    
    public void setEmailAddress(String ea){
        emailAddress=ea;
    }
    
    public String getEmailAddress(){
        return emailAddress;
    }
    
    public void setAddress1(String a1){
        address1=a1;
    }
    
    public String getAddress1(){
        return address1;
    }
    
    public void setAddress2(String a2){
        address2=a2;
    }
    
    public String getAddress2(){
        return address2;
    }
    
    public void setCity(String c){
        city=c;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setState(String s){
        state=s;
    }
    
    public String getState(){
        return state;
    }
    
    public void setPostCode(int pc){
        postCode=pc;
    }
    
    public int getPostCode(){
        return postCode;
    }
    
    public void setCountry(String co){
        country=co;
    }
    
    public String getCountry(){
        return country;
    }
    
    
}