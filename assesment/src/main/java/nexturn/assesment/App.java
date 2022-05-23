package nexturn.assesment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure("hibernate.cfg.xml"); //Loads hibernate.cfg.xml

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

		Metadata metadata = new MetadataSources(reg).addAnnotatedClass(Bill.class).addAnnotatedClass(Customer.class).getMetadataBuilder()
				.build();
//		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();

		Session session = factory.openSession();
		
		Transaction txTransaction=session.beginTransaction();
		
    	Customer customer=new Customer();
    	Bill bill=new Bill();
    	RestaurantDao restaurantDAO=new RestaurantDao();
    	restaurantDAO.generateBill();
    	
    	session.close();
    	factory.close();
    }
    


    
}
