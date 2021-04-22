package ga.veee.shopping.Repository;

import ga.veee.shopping.Entity.InvoiceMaster;

import java.io.Serializable;

public class InvoiceMasterRepository extends Repository<InvoiceMaster> implements Cloneable, Serializable {

    private static InvoiceMasterRepository instance;

    protected InvoiceMasterRepository() {
        super(InvoiceMaster.class);
    }

    public static InvoiceMasterRepository getRepository() {
        if (instance == null) {
            instance = new InvoiceMasterRepository();
        }
        return (InvoiceMasterRepository) instance.getClone();
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