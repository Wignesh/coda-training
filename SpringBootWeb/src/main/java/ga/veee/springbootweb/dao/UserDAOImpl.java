package ga.veee.springbootweb.dao;

import ga.veee.springbootweb.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createUser(UserEntity userEntity) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(".................session factory.................:" + sessionFactory);
        session.persist(userEntity);
        //	session.beginTransaction().commit();
    }
}
