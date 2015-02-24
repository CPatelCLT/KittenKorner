/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp_db;

import java.util.ArrayList;
import java_files.*;

/**
 *
 * @author Eric
 */
public class UserDB {
    
    private ArrayList<User> userList;
    private void populateDB () {
        User usr = new User("John", "Doe", "john.doe@gmail.com", "123 Anywhere Ln", "", "Anytown", "WH", 12345, "USA");
        userList.add(usr);
    }
    public ArrayList<User> getUserList () {
        return userList;
    }
}
