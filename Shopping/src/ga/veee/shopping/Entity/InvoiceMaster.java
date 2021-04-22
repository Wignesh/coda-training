package ga.veee.shopping.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "INVOICE_MASTER", schema = "CODA_TEST")
public class InvoiceMaster implements Cloneable, Serializable {
    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;
    @Basic
    @Column(name = "INVOICE_DATE", nullable = true)
    private Timestamp invoiceDate;
    @Basic
    @Column(name = "USER_ID", nullable = false)
    private int userId;
    @Basic
    @Column(name = "BILLING_ADDRESS_ID", nullable = false)
    private int billingAddressId;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false, insertable = false,updatable = false)
    private User user;

    @OneToMany(mappedBy = "invoiceMaster")
    private Set<InvoiceTransaction> invoiceTransactions;

    @OneToOne(mappedBy = "invoiceMaster")
    private InvoiceBlob invoiceBlob;

    public int getInvoiceId() {
        return invoiceId;
    }

    public InvoiceMaster() {
    }

    public int getId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Timestamp getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Timestamp invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(int billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceMaster that = (InvoiceMaster) o;

        if (invoiceId != that.invoiceId) return false;
        if (userId != that.userId) return false;
        if (billingAddressId != that.billingAddressId) return false;
        if (invoiceDate != null ? !invoiceDate.equals(that.invoiceDate) : that.invoiceDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoiceId;
        result = 31 * result + (invoiceDate != null ? invoiceDate.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + billingAddressId;
        return result;
    }

    @Override
    public String toString() {
        return "InvoiceMaster(" +
                "invoiceId = " + invoiceId + ", " +
                "invoiceDate = " + invoiceDate + ", " +
                "userId = " + userId + ", " +
                "billingAddressId = " + billingAddressId + ")";
    }
}
