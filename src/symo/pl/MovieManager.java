package symo.pl;

import java.util.Date;
import java.util.UUID;
import org.hibernate.Criteria;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
  

public class MovieManager {

	public static void main(String[] args) {
		//creating configuration object  
	    Configuration cfg = new Configuration();  
	    cfg.configure("symo/pl/hibernate.cfg.xml");//populates the data of the configuration file	    
	    //cfg.configure();
	      
	    //creating ServiceRegistry object	    
	    ServiceRegistry serviceRegistry;
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	    
	    //creating SessionFactory object
	    SessionFactory sessionFactory;
	    sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	      
	    //creating session object  
	    Session session=sessionFactory.openSession();  
	      
	    //creating transaction object  
	    Transaction t=session.beginTransaction(); 	    
	    
	    Criteria criteria = session.createCriteria(User.class);	    
	    criteria.add(Restrictions.eq("login", "lukaszt"));	    	    
	    User u1 = (User) criteria.uniqueResult();	    
	    if (u1!=null) {
	    	System.out.println("User found:");
	    	System.out.println(u1.getUuid() + " - " + u1.getLogin());
	    }

	    //System.out.println("awsAccessKeyId: " + UUID.randomUUID().toString().replace("-", ""));
	    
	    // Create user
	    //User u2 = new User();
	    //u2.setLogin("lukaszt");
	    //u2.setPassword("bubu");
	    //session.persist(u2);//persisting the object
	    
	    // Create session
	    //UserSession s2 = new UserSession();	    
	    //s2.setAccessKey(UUID.randomUUID().toString().replace("-", ""));
	    //s2.setOwner(u1.getUuid());
	    //s2.setExpirationDate(new Date());
	    //session.persist(s2);
	    
	    // Create movie
	    Movie m1 = new Movie();
	    m1.setTitle("Zjawa");
	    //m1.setDescription("kozackie kino");
	    m1.setOwner(u1.getUuid());
	    m1.setWatched(false);
	    session.persist(m1);//persisting the object
	      
	    t.commit();//transaction is committed  
	    session.close();  
	      
	    System.out.println("successfully saved");  

	}

}
