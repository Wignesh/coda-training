package ga.veee.shopping.Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static final SessionFactory sessionFactory;
    private static Session session;
    private static Transaction tx;

    private HibernateUtility() {
    }

    private final static ThreadLocal<Session> thread = new ThreadLocal<>();

    static {
        Configuration cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
    }

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

    synchronized public static int closeSession(Exception e) {
        session = thread.get();
        if (e == null) {
            if (session != null && session.isOpen()) {
                int result;
                try {
                    tx.commit();
                    result = 1;
                } catch (Exception exception) {
                    exception.printStackTrace();
                    result = -1;
                } finally {
                    session.close();
                    thread.remove();
                }
                return result;
            }
        } else {
            if (session != null && session.isOpen()) {
                int result;
                try {
                    tx.rollback();
                    result = 1;
                } catch (Exception exception) {
                    exception.printStackTrace();
                    result = -1;
                } finally {
                    session.close();
                    thread.remove();
                }
                return result;
            }
        }
        return 0;

    }
}