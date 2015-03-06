/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp_db;

import java.util.ArrayList;
import java_files.*;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */
public class UserDB {
    
    private ArrayList<User> userList;
    public UserDB() {
        userList = new ArrayList<User>();
        User usr = new User("John", "Doe", "john.doe@gmail.com", "123 Anywhere Ln", "Apt 2", "Anytown", "WH", 12345, "USA");
        userList.add(usr);
    }
    public ArrayList<User> getUserList () {
        return userList;
    }
    public User getUser(String emailAddress) {
        for(int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmailAddress().equals(emailAddress)) {
                return userList.get(i);
            }
        }
        return null;
    }
}
