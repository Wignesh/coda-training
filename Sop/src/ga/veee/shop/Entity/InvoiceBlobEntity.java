package ga.veee.shop.Entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "INVOICE_BLOB", schema = "CODA", catalog = "")
public class InvoiceBlobEntity {
    private int invoiceId;
    private byte[] excel;
    private byte[] pdf;

    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Basic
    @Column(name = "EXCEL", nullable = true)
    public byte[] getExcel() {
        return excel;
    }

    public void setExcel(byte[] excel) {
        this.excel = excel;
    }

    @Basic
    @Column(name = "PDF", nullable = true)
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

        InvoiceBlobEntity that = (InvoiceBlobEntity) o;

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
}
