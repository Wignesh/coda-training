package ga.veee.springbootweb.service;

import ga.veee.springbootweb.dao.UserDAO;
import ga.veee.springbootweb.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("us")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void createUser(UserEntity user) {
        // TODO Auto-generated method stub
        userDAO.createUser(user);
    }
}
