/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java_beans.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.TypedQuery;

/**
 * @author    : Eric Knowles
 * @author    : Chirag Patel
 */
public class UserDB {
    

    public UserDB() {

    }

    public void setupUserDB(){
        ArrayList<User> userList = new ArrayList<User>();
        User usr = new User("John", "Doe", "john.doe@gmail.com", "123 Anywhere Ln", "Apt 1", "Anytown", "WH", "12345", "USA", "password");
        User usr2 = new User("Jane", "Doe", "jane.doe@gmail.com", "456 Nowhere Ln", "Apt 2", "Notown", "NW", "54321", "USA", "password");
        userList.add(usr);
        userList.add(usr2);
        for(int i=0; i<userList.size(); i++){
            addUser(userList.get(i));
        }
    }
    
    
    public ArrayList<User> getAllUsers() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from User u";
        TypedQuery<User> u = em.createQuery(qString, User.class);
        
        List<User> users;
        
        try{
            users = u.getResultList();
            if(users == null || users.isEmpty()){
                return null;
            }
        }
        finally{
            em.close();
        }
        ArrayList<User> userList = new ArrayList(users.size());
        userList.addAll(users);
        return userList;
    }
    public User getUser(int userID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from User u "+"WHERE u.userID = :userID";
        TypedQuery<User> u = em.createQuery(qString, User.class);
        u.setParameter("userID", userID);
        
        User user = null;
        try{
            user = u.getSingleResult();
        } catch(NoResultException e){
            System.out.println(e);
        }finally{
            em.close();
        }
        return user;

    }
    public User getUserByEmail(String emailAddr) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from User u "+"WHERE u.emailAddress = :emailAddr";
        TypedQuery<User> u = em.createQuery(qString, User.class);
        u.setParameter("emailAddr", emailAddr);
        
        User user = null;
        try{
            user = u.getSingleResult();
        } catch(NoResultException e){
            System.out.println(e);
        }finally{
            em.close();
        }
        return user;

    }
    public void addUser(String firstName, String lastName, String email, String address1, String address2, String city, String state, String zipcode, String country, String password){
        User user = new User(firstName, lastName, email, address1, address2, city, state, zipcode, country, password);
        addUser(user);
    }
    
    public void addUser(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(user);
            trans.commit();
        }catch(Exception ex){
            System.out.println(ex);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    /*
    public void updateUser(String firstName, String lastName, String email, String address1, String address2, String city, String state, int zipcode, String country){
        User user = new User(firstName, lastName, email, address1, address2, city, state, zipcode, country);
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.merge(user);
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
    public void updateUser(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.merge(user);
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
    public void deleteUser(String firstName, String lastName, String email, String address1, String address2, String city, String state, int zipcode, String country){
        User user = new User(firstName, lastName, email, address1, address2, city, state, zipcode, country);
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.remove(user);
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
    public void deleteUser(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.remove(user);
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }finally{
            em.close();
        }
    }
    */
}
