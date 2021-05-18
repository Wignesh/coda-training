package ga.veee.springbootweb.dao;


import ga.veee.springbootweb.model.UserEntity;

public abstract class UserDAO {
    public abstract void createUser(UserEntity userEntity);
}
