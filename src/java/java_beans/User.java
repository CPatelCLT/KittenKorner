/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */
@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String firstName;
    private String lastName;
    @Column(name="emailAddr")
    private String emailAddress;
    @Column(name="address1Field")
    private String address1;
    @Column(name="address2Field")
    private String address2;
    private String city;
    private String state;
    @Column(name="zipPostalCode")
    private String postCode;
    private String country;
    
    public User(){
        
    }
    
    public User(String FN, String LN, String EA, String A1, String A2, String C, String S, String PC, String CO){
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
    
    public int getUserID(){
        return userID;
    }
    
    public void setUserID(int userID){
        this.userID=userID;
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
    
    public void setPostCode(String pc){
        postCode=pc;
    }
    
    public String getPostCode(){
        return postCode;
    }
    
    public void setCountry(String co){
        country=co;
    }
    
    public String getCountry(){
        return country;
    }
    
    
}
