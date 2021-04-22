package ga.veee.shopping.Repository;

import ga.veee.shopping.Entity.User;

import java.io.Serializable;

public class UserRepository extends Repository<User> implements Cloneable, Serializable {

    private static UserRepository instance;

    protected UserRepository() {
        super(User.class);
    }

    public static UserRepository getRepository() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return (UserRepository) instance.getClone();
    }


    private Object getClone() {
        try {
            return super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
