package ga.veee.day23.daopack;

import java.io.Serializable;

public class InvoiceMasterDTO implements Comparable<InvoiceMasterDTO>, Serializable, Cloneable {
    public InvoiceMasterDTO(int INVOICE_ID, String INVOICE_DATE, int CUSTOMER_ID, int BILLING_ADDRESS) {
        this.INVOICE_ID = INVOICE_ID;
        this.INVOICE_DATE = INVOICE_DATE;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.BILLING_ADDRESS = BILLING_ADDRESS;
    }

    public InvoiceMasterDTO getClone() {
        try {
            return (InvoiceMasterDTO) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int INVOICE_ID;
    private String INVOICE_DATE;
    private int CUSTOMER_ID;
    private int BILLING_ADDRESS;

    public InvoiceMasterDTO() {
    }

    @Override
    public int compareTo(InvoiceMasterDTO o) {
        return String.valueOf(this.INVOICE_ID).compareTo(String.valueOf(o.INVOICE_ID));
    }

    public int getINVOICE_ID() {
        return INVOICE_ID;
    }

    public void setINVOICE_ID(int INVOICE_ID) {
        this.INVOICE_ID = INVOICE_ID;
    }

    public String getINVOICE_DATE() {
        return INVOICE_DATE;
    }

    public void setINVOICE_DATE(String INVOICE_DATE) {
        this.INVOICE_DATE = INVOICE_DATE;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public int getBILLING_ADDRESS() {
        return BILLING_ADDRESS;
    }

    public void setBILLING_ADDRESS(int BILLING_ADDRESS) {
        this.BILLING_ADDRESS = BILLING_ADDRESS;
    }

    @Override
    public String toString() {
        return "InvoiceMasterDTO{" +
                "INVOICE_ID=" + INVOICE_ID +
                ", INVOICE_DATE=" + INVOICE_DATE +
                ", CUSTOMER_ID=" + CUSTOMER_ID +
                ", BILLING_ADDRESS=" + BILLING_ADDRESS +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceMasterDTO that = (InvoiceMasterDTO) o;

        if (INVOICE_ID != that.INVOICE_ID) return false;
        if (CUSTOMER_ID != that.CUSTOMER_ID) return false;
        if (BILLING_ADDRESS != that.BILLING_ADDRESS) return false;
        return INVOICE_DATE != null ? INVOICE_DATE.equals(that.INVOICE_DATE) : that.INVOICE_DATE == null;
    }

    @Override
    public int hashCode() {
        int result = INVOICE_ID;
        result = 31 * result + (INVOICE_DATE != null ? INVOICE_DATE.hashCode() : 0);
        result = 31 * result + CUSTOMER_ID;
        result = 31 * result + BILLING_ADDRESS;
        return result;
    }
}
