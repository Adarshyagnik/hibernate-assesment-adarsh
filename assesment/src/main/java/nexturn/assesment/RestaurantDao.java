package nexturn.assesment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class RestaurantDao {

	public void generateBill() {
		//Implement the method
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml"); //Loads hibernate.cfg.xml

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

		Metadata metadata = new MetadataSources(reg).addAnnotatedClass(Bill.class).addAnnotatedClass(Customer.class).getMetadataBuilder()
				.build();
//		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();

		Session session = factory.openSession();
		
		Transaction txTransaction=session.beginTransaction();
		
		
		Customer customer=new Customer();
		customer.setCustomerName("peter");
		customer.setPhoneNo(999999999);
		customer.setCity("Newyork");
		
		Bill bill=new Bill();
		bill.setBillId("B1001");
		bill.setBillAmount(2500.00);
		bill.setBillCurrency("USD");
		customer.setBill(bill);
		
		session.save(customer);
		session.save(bill);
		txTransaction.commit();
		
		session.close();
		factory.close();
		
	}
	


}
