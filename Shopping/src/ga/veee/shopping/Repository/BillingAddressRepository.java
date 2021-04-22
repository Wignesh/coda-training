package ga.veee.shopping.Repository;

import ga.veee.shopping.Entity.BillingAddress;

import java.io.Serializable;

public class BillingAddressRepository extends Repository<BillingAddress> implements Cloneable, Serializable {

    private static BillingAddressRepository instance;

    protected BillingAddressRepository() {
        super(BillingAddress.class);
    }

    public static BillingAddressRepository getRepository() {
        if (instance == null) {
            instance = new BillingAddressRepository();
        }
        return (BillingAddressRepository) instance.getClone();
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