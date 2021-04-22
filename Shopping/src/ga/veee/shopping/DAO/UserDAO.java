package ga.veee.shopping.DAO;

import ga.veee.shopping.Entity.User;

public interface UserDAO<T, I> {
    int updateFlag(String name, String password, int flag);

    User userExists(String name, String password);
}
