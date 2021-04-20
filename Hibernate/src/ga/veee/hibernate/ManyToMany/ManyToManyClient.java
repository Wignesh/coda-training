package ga.veee.hibernate.ManyToMany;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import ga.veee.hibernate.Utility.HibernateUtility;
import org.hibernate.Session;


public class ManyToManyClient {
	public static void main(String[] args) {
		Student student=new Student();
		student.setSname("ramu");
		student.setMarks(450);
		
		Training t1=new Training();
		t1.setTname("java");
		t1.setStartDate(new Date());
		
		Training t2=new Training();
		t2.setTname("jee");
		t2.setStartDate(new Date());
		
		Set<Training> trainings=new HashSet<Training>();
		trainings.add(t1);
		trainings.add(t2);
		
		student.setTrainings(trainings);
		
		Session session= HibernateUtility.getSession();
		session.save(student);
		//session.save(t1);
		//session.save(t2);
		
		HibernateUtility.closeSession(null);
	}
}
