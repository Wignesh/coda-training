package ga.veee.day21.DB.DTO;

import java.io.Serializable;
import java.sql.Date;

public class InvoiceMasterDTO implements Serializable, Cloneable {

    private static InvoiceMasterDTO invoiceMasterDTO;
    private int INVOICE_ID;
    private Date INVOICE_DATE;
    private int CUSTOMER_ID;

    synchronized public static InvoiceMasterDTO getInvoiceMasterDTO() {
        if (invoiceMasterDTO == null) {
            invoiceMasterDTO = new InvoiceMasterDTO();
        }
        return invoiceMasterDTO.getCloneInvoiceMasterDTO();
    }

    private InvoiceMasterDTO getCloneInvoiceMasterDTO() {
        try {
            return (InvoiceMasterDTO) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private InvoiceMasterDTO() {

    }

    public int getINVOICE_ID() {
        return INVOICE_ID;
    }

    public void setINVOICE_ID(int INVOICE_ID) {
        this.INVOICE_ID = INVOICE_ID;
    }

    public Date getINVOICE_DATE() {
        return INVOICE_DATE;
    }

    public void setINVOICE_DATE(Date INVOICE_DATE) {
        this.INVOICE_DATE = INVOICE_DATE;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    @Override
    public String toString() {
        return "InvoiceMasterDTO{" +
                "INVOICE_ID=" + INVOICE_ID +
                ", INVOICE_DATE='" + INVOICE_DATE + '\'' +
                ", COSTUMER_ID=" + CUSTOMER_ID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceMasterDTO that = (InvoiceMasterDTO) o;

        if (INVOICE_ID != that.INVOICE_ID) return false;
        if (CUSTOMER_ID != that.CUSTOMER_ID) return false;
        return INVOICE_DATE != null ? INVOICE_DATE.equals(that.INVOICE_DATE) : that.INVOICE_DATE == null;
    }

    @Override
    public int hashCode() {
        int result = INVOICE_ID;
        result = 31 * result + (INVOICE_DATE != null ? INVOICE_DATE.hashCode() : 0);
        result = 31 * result + CUSTOMER_ID;
        return result;
    }
}
