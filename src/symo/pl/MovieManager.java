package symo.pl;

import java.util.UUID;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  

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
	          
	    Movie m1=new Movie();
	    m1.setName("hddohddoh33d3");  
	      
	    session.persist(m1);//persisting the object  
	      
	    t.commit();//transaction is committed  
	    session.close();  
	      
	    System.out.println("successfully saved");  

	}

}
