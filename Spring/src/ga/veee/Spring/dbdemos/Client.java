package ga.veee.Spring.dbdemos;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("db-config.xml");

        DbDemo db = (DbDemo) ctx.getBean("dbdemo");

        db.testDb();
    }
}
