package ga.veee.shopping.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "INVOICE_BLOB", schema = "CODA_TEST", indexes = {
        @Index(name = "INVOICE_BLOB_INVOICE_ID_uindex", columnList = "INVOICE_ID", unique = true)
})
public class InvoiceBlob implements Cloneable, Serializable {
    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    private int invoiceId;
    @Basic
    @Column(name = "EXCEL", nullable = true)
    private byte[] excel;
    @Basic
    @Column(name = "PDF", nullable = true)
    private byte[] pdf;

    // Relationships
    @OneToOne
    @JoinColumn(name = "INVOICE_ID", nullable = false, insertable = false, updatable = false)
    private InvoiceMaster invoiceMaster;

    public InvoiceBlob() {
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public int getId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public byte[] getExcel() {
        return excel;
    }

    public void setExcel(byte[] excel) {
        this.excel = excel;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceBlob that = (InvoiceBlob) o;

        if (invoiceId != that.invoiceId) return false;
        if (!Arrays.equals(excel, that.excel)) return false;
        if (!Arrays.equals(pdf, that.pdf)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoiceId;
        result = 31 * result + Arrays.hashCode(excel);
        result = 31 * result + Arrays.hashCode(pdf);
        return result;
    }


    @Override
    public String toString() {
        return "InvoiceBlob(" +
                "invoiceId = " + invoiceId + ", " +
                "excel = " + excel + ", " +
                "pdf = " + pdf + ")";
    }
}
