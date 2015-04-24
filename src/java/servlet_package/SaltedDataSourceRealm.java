/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_package;

import java.security.Principal;
import org.apache.catalina.realm.DataSourceRealm;

/**
 *
 * @author chirag
 */
public class SaltedDataSourceRealm  extends DataSourceRealm{
    @Override
    public Principal authenticate(String username, String credentials) {
        
    }
}
