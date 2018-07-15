package trng.hibernat.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
  
public class HibernateUtils {
  
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
		try {
	            Configuration configuration = new Configuration();
	            configuration.configure("hibernate.cfg.xml");
	            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	            SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
	            return sessionFactory;
		} catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void displayCustomerMenu() {
    	System.out.println("1. ADD \n 2. DELETE \n 3. UPDATE \n 4. LOAD based on ID \n 5. GET list of customer from a zipCode \n "
    			+ "6. GET monthly sales data for a given year \n 7. GET customer summary report for a month \n 8.Exit menu ");
    }
    
    public static void displayOrderMenu() {
    	System.out.println("1. ADD \n 2. DELETE \n 3. UPDATE \n 4. LOAD based on ID \n 5. GET an order entry by giving order object \n 6. Exit menu ");
    }
}
