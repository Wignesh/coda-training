package ga.veee.shop.Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private HibernateUtility() {
    }

    private final static ThreadLocal<Session> thread = new ThreadLocal<Session>();

    static {
        Configuration cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    private static final SessionFactory sessionFactory;
    private static Session session;
    private static Transaction tx;

    synchronized public static Session getSession() {
        try {
            session = thread.get();
            if (session == null || !session.isOpen()) {
                session = sessionFactory.openSession();
                tx = session.beginTransaction();
                thread.set(session);
            }
            return session;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    synchronized public static void closeSession(Exception e) {
        session = thread.get();
        if (e == null) {
            if (session != null && session.isOpen()) {
                tx.commit();
                session.close();
                thread.remove();
            }
        } else {
            if (session != null && session.isOpen()) {
                tx.rollback();
                session.close();
                thread.remove();
            }
        }

    }
}