package Shop.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "INVOICE_MASTER", schema = "CODA", catalog = "")
public class InvoiceMasterEntity {
    private int invoiceId;
    private Timestamp invoiceDate;
    private Integer customerId;
    private Integer billingAddress;

    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Basic
    @Column(name = "INVOICE_DATE", nullable = true)
    public Timestamp getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Timestamp invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Basic
    @Column(name = "CUSTOMER_ID", nullable = true)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "BILLING_ADDRESS", nullable = true)
    public Integer getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Integer billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceMasterEntity that = (InvoiceMasterEntity) o;

        if (invoiceId != that.invoiceId) return false;
        if (invoiceDate != null ? !invoiceDate.equals(that.invoiceDate) : that.invoiceDate != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (billingAddress != null ? !billingAddress.equals(that.billingAddress) : that.billingAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoiceId;
        result = 31 * result + (invoiceDate != null ? invoiceDate.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
        return result;
    }
}
