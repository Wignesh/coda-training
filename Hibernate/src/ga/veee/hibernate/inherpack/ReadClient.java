package ga.veee.hibernate.inherpack;

import java.util.Iterator;
import java.util.List;

import ga.veee.hibernate.HibernateUtility;
import org.hibernate.Query;
import org.hibernate.Session;


public class ReadClient {
	public static void main(String[] args) {
		Session session= HibernateUtility.getSession();
		
		Query query= session.createQuery("from ShoeFactory");
		Iterator iterator = query.iterate();

		while (iterator.hasNext()){
			System.out.println("knfdkf");
		}
		List<ShoeFactory> factory=query.list();
		System.out.println(factory.size());
		for(ShoeFactory sf:factory) {
			System.out.println(sf.getShoeName());
//			if(sf instanceof BataShoeFactory) {
//				BataShoeFactory
//			}
//			else if(sf instanceof ShoeFactory) {
//				
//			}
//			else if(sf instanceof LakhaniShoeFactory) {
//				
//			}
//			System.out.println(sf);
		}
		
	}
}
