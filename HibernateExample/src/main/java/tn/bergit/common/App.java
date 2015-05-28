package tn.bergit.common;

import org.hibernate.Session;

import tn.bergit.persistence.HibernateUtil;


/**
 * 
 * @author amine.berguiga
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Stock stock = new Stock();
        
        stock.setStockCode("1234");
        stock.setStockName("Name of Product");
        
        session.save(stock);
        session.getTransaction().commit();
    }
}
