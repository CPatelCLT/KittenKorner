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
import java_beans.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author chirag
 */
public class OrderDB {
    ProductDB pdb = new ProductDB();
    public OrderDB() {
        
    }
    
//    public ArrayList<OrderItem> getOrderItems(int onum) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        String query = "SELECT oi FROM OrderItem oi " + "WHERE oi.orderNumber = :onum";
//        TypedQuery<OrderItem> q = em.createQuery(query, OrderItem.class);
//        q.setParameter("onum", onum+"");
//        List<OrderItem> oi;
//        try {
//            oi = q.getResultList();
//            if (oi == null || oi.isEmpty()) {
//                return null;
//            }
//        } finally {
//            em.close();
//        }
//        ArrayList<OrderItem> oiNew = new ArrayList<OrderItem>(oi.size());
//        oiNew.addAll(oi);
//        for (int i = 0; i<oiNew.size(); i++) {
//            oiNew.get(i).setProduct(pdb.getProduct(Integer.parseInt(oiNew.get(i).getProduct().getProductCode())));
//        }
//        return oiNew;
//    }
    public ArrayList<Order> getOrders(User usr) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT ord FROM Order ord " + "WHERE ord.user = :uid";
        TypedQuery<Order> q = em.createQuery(query, Order.class);
        q.setParameter("uid", usr);
        List<Order> ord;
        try {
            ord = q.getResultList();
            if (ord == null || ord.isEmpty()) {
                return null;
            }
        } finally {
            em.close();
        }
        ArrayList<Order> ordNew = new ArrayList(ord.size());
        ordNew.addAll(ord);
        return ordNew;
    }
    public Order getOrderByNum(int ordNum) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT ord FROM Order ord " + "WHERE ord.orderNumber = :ordNum";
        TypedQuery<Order> q = em.createQuery(query, Order.class);
        q.setParameter("ordNum", ordNum);
        Order ord;
        try {
            ord = q.getSingleResult();
        } finally {
            em.close();
        }
        return ord;
    }
    public void addOrder(Order o) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        System.out.println(o);
        trans.begin();
        try {
            em.persist(o); 
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
//    public void addOrderItems(int uid, OrderItem oi) {
//        int ordNum = getOrdNum(uid);
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        EntityTransaction trans = em.getTransaction();
//        trans.begin();
//        try {
//            oi.setOrderNum(ordNum);
//            em.persist(oi);
//            trans.commit();
//        } catch (Exception e) {
//            System.out.println(e);
//            trans.rollback();
//        } finally {
//            em.close();
//        }
//    }
    public int getOrdNum(User usr) {
        ArrayList<Order> ords = getOrders(usr);
        return ords.get(ords.size()-1).getOrderNumber();
    }
    public Order getLastOrder(User usr) {
        ArrayList<Order> userOrders = getOrders(usr);
        return userOrders.get(userOrders.size()-1);
    }
}
