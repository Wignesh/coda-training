package ga.veee.shopping.Repository;

import ga.veee.shopping.Entity.ItemMaster;
import ga.veee.shopping.Entity.User;

import java.io.Serializable;

public class ItemMasterRepository extends Repository<ItemMaster> implements Cloneable, Serializable {

    private static ItemMasterRepository instance;

    protected ItemMasterRepository() {
        super(ItemMaster.class);
    }

    public static ItemMasterRepository getRepository() {
        if (instance == null) {
            instance = new ItemMasterRepository();
        }
        return (ItemMasterRepository) instance.getClone();
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
