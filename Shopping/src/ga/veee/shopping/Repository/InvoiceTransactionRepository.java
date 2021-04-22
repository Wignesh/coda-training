package ga.veee.shopping.Repository;

import ga.veee.shopping.Entity.InvoiceTransaction;

import java.io.Serializable;

public class InvoiceTransactionRepository extends Repository<InvoiceTransaction> implements Cloneable, Serializable {

    private static InvoiceTransactionRepository instance;

    protected InvoiceTransactionRepository() {
        super(InvoiceTransaction.class);
    }

    public static InvoiceTransactionRepository getRepository() {
        if (instance == null) {
            instance = new InvoiceTransactionRepository();
        }
        return (InvoiceTransactionRepository) instance.getClone();
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