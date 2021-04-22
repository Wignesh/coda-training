package ga.veee.shopping.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INVOICE_TRANSACTION", schema = "CODA_TEST", indexes = {
        @Index(name = "INVOICE_TRANSACTION_TRANSACTION_ID_uindex", columnList = "TRANSACTION_ID", unique = true)
})
public class InvoiceTransaction implements Cloneable, Serializable {
    @Column(name = "INVOICE_ID", nullable = false)
    private int invoiceId;
    @Basic
    @Column(name = "ITEM_ID", nullable = false)
    private int itemId;
    @Basic
    @Column(name = "QTY", nullable = false)
    private int qty;
    @Basic
    @Column(name = "PRICE", nullable = false, precision = 0)
    private double price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID", nullable = false, unique = true)
    private int transactionId;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "TRANSACTION_ID", nullable = false, insertable = false, updatable = false)
    private InvoiceMaster invoiceMaster;

    public InvoiceTransaction() {
    }


    public int getInvoiceId() {
        return invoiceId;
    }
    public int getId() {
        return transactionId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceTransaction that = (InvoiceTransaction) o;

        if (itemId != that.itemId) return false;
        if (qty != that.qty) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (transactionId != that.transactionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = itemId;
        result = 31 * result + qty;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + transactionId;
        return result;
    }

    @Override
    public String toString() {
        return "InvoiceTransaction(" +
                "transactionId = " + transactionId + ", " +
                "invoiceId = " + invoiceId + ", " +
                "itemId = " + itemId + ", " +
                "qty = " + qty + ", " +
                "price = " + price + ")";
    }
}
