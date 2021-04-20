package ga.veee.hibernate.OneToMany;

import java.util.HashSet;

import ga.veee.hibernate.Utility.HibernateUtility;
import org.hibernate.Session;


public class OneToManyClient {
    public static void main(String[] args) {

        Employee emp = new Employee();
        emp.setEname("VIGNESH");
        emp.setEsal(10000);

        Address add1 = new Address();
        add1.setCity("COIMBATORE");
        add1.setStreet("MG STREET");
        add1.setEmp(emp);

        Address add2 = new Address();
        add2.setCity("CHENNAI");
        add2.setStreet("ABC STREET");
        add2.setEmp(emp);

        HashSet<Address> addresses = new HashSet<Address>();
        addresses.add(add1);
        addresses.add(add2);

        emp.setAddresses(addresses);

        Session session = HibernateUtility.getSession();
        session.save(emp);
        //session.save(add1);
        //session.save(add2);

        HibernateUtility.closeSession(null);
    }

}
