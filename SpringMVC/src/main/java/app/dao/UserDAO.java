package app.dao;

import app.model.LoginForm;


public interface UserDAO {
    public void createUser(LoginForm user);
}
