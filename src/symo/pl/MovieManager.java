package symo.pl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;  

public class MovieManager {

	public static void main(String[] args) {
		//creating configuration object  
	    Configuration cfg = new Configuration();  
	    cfg.configure("symo/pl/hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();  
	      
	    //creating transaction object  
	    Transaction t=session.beginTransaction(); 
	    
	    //User u1 =  (User) session.get(User.class, "252ADC11-13F8-4E1B-BF9C-80D24243234D");
	    
	    //Criteria cr = session.createCriteria(User.class);
	    //cr.add(Restrictions.eq("login", "lukasztk"));
	    //List results = cr.list();
	    
	    Criteria criteria = session.createCriteria(User.class);	    
	    criteria.add(Restrictions.eq("login", "lukaszt"));
	    
	    //Movie m1 = (Movie) criteria.uniqueResult();
	    User u1 = (User) criteria.uniqueResult();
	    
	    if (u1!=null) {
	    	System.out.println("User found:");
	    	System.out.println(u1.getUuid() + " - " + u1.getLogin());
	    }

	    
	    Movie m1=new Movie();
	    m1.setName("myMovieOKhoho");
	    m1.setOwner(u1.getUuid());
	    
	      
	    session.persist(m1);//persisting the object
	    //session.persist(u1);//persisting the object  
	      
	    t.commit();//transaction is committed  
	    session.close();  
	      
	    System.out.println("successfully saved");  

	}

}
