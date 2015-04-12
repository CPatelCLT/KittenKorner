/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.util.ArrayList;
import java.util.List;
import java_beans.Order;
import java_beans.OrderItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author chirag
 */
public class OrderDB {
    public OrderDB() {
        
    }
    
    public ArrayList<OrderItem> getOrderItems(int onum) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT oi FROM OrderItems oi " + "WHERE oi.orderNum = :onum";
        TypedQuery<OrderItem> q = em.createQuery(query, OrderItem.class);
        q.setParameter("onum", onum+"");
        List<OrderItem> oi;
        try {
            oi = q.getResultList();
            if (oi == null || oi.isEmpty()) {
                return null;
            }
        } finally {
            em.close();
        }
        ArrayList<OrderItem> oiNew = new ArrayList<OrderItem>(oi.size());
        oiNew.addAll(oi);
        return oiNew;
    }
    public ArrayList<Order> getOrders(int uid) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT ord FROM Order ord " + "WHERE ord.userID = :uid";
        TypedQuery<Order> q = em.createQuery(query, Order.class);
        q.setParameter("uid", uid+"");
        List<Order> ord;
        try {
            ord = q.getResultList();
            if (ord == null || ord.isEmpty()) {
                return null;
            }
        } finally {
            em.close();
        }
        ArrayList<Order> ordNew = new ArrayList<Order>(ord.size());
        ordNew.addAll(ord);
        return ordNew;
    }
    public void addOrder(Order o, ArrayList<OrderItem> oi) {
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(o); 
            trans.commit(); //OrderNumber assigned here
            int ordnum = getOrdNum(o.getUserID());
            for (int i = 0; i<oi.size(); i++) {
                oi.get(i).setOrderNum(ordnum);
                em.persist(oi.get(i));
                trans.commit();
            }
            
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public int getOrdNum(int uid) {
        ArrayList<Order> ords = getOrders(uid);
        return ords.get(ords.size()-1).getOrderNumber();
    }
    public Order getLastOrder(int uid) {
        ArrayList<Order> userOrders = getOrders(uid);
        return userOrders.get(userOrders.size()-1);
    }
}
