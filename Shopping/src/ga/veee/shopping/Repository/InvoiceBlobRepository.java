package ga.veee.shopping.Repository;

import ga.veee.shopping.Entity.InvoiceBlob;

import java.io.Serializable;


public class InvoiceBlobRepository extends Repository<InvoiceBlob> implements Cloneable, Serializable {

    private static InvoiceBlobRepository instance;

    protected InvoiceBlobRepository() {
        super(InvoiceBlob.class);
    }

    public static InvoiceBlobRepository getRepository() {
        if (instance == null) {
            instance = new InvoiceBlobRepository();
        }
        return (InvoiceBlobRepository) instance.getClone();
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