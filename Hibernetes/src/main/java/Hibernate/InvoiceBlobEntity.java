package Hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "INVOICE_BLOB", schema = "CODA", catalog = "")
public class InvoiceBlobEntity {
    private Integer invoiceId;
    private byte[] excel;
    private byte[] pdf;

    @Basic
    @Column(name = "INVOICE_ID", nullable = true)
    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
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

        if (invoiceId != null ? !invoiceId.equals(that.invoiceId) : that.invoiceId != null) return false;
        if (!Arrays.equals(excel, that.excel)) return false;
        if (!Arrays.equals(pdf, that.pdf)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoiceId != null ? invoiceId.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(excel);
        result = 31 * result + Arrays.hashCode(pdf);
        return result;
    }
}
