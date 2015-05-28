package tn.berit.test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tn.bergit.common.Stock;

 

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	 private static Configuration config;
     private static SessionFactory factory;
     private static Session session;	
     private static Transaction tx;
	
 
	@Before
	public void initialize() throws Exception {
		config 			 = new Configuration().configure(new File("src/main/resources/hibernate.cfg.xml"));
        factory 		 = config.buildSessionFactory();
        session 		 = factory.openSession();
        tx = null;
	}
	
	@Test
	public void testDB() throws Exception{
		
		Stock item = new Stock("codeStock", "stock Name----");
		session.save(item);
		try {
			tx = session.beginTransaction();
			session.flush();
			tx.commit();
		}
		catch (Exception e) {
		 if (tx != null) {
			 assertTrue("ERROR insert",false);
		     tx.rollback();
		  }
		  throw e;
		}
		finally 
		{ 
			assertTrue("ALL it's Ok!!!",true);	
		   session.close(); 
	    } 
		factory.close(); 
		
		
	}

	@After
	public void afterTestDB() throws Exception {
	}
    
    
    
    
}
