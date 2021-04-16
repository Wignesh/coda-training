package ga.veee.day23.daopack;

import java.io.Serializable;

public class InvoiceTransactionDTO implements Comparable<InvoiceTransactionDTO>, Serializable, Cloneable {
    private int INVOICE_ID;
    private int ITEM_ID;
    private int QTY;

    public InvoiceTransactionDTO(int INVOICE_ID, int ITEM_ID, int QTY, float PRICE) {
        this.INVOICE_ID = INVOICE_ID;
        this.ITEM_ID = ITEM_ID;
        this.QTY = QTY;
        this.PRICE = PRICE;
    }

    @Override
    public String toString() {
        return "InvoiceTransactionDTO{" +
                "INVOICE_ID=" + INVOICE_ID +
                ", ITEM_ID=" + ITEM_ID +
                ", QTY=" + QTY +
                ", PRICE=" + PRICE +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceTransactionDTO that = (InvoiceTransactionDTO) o;

        if (INVOICE_ID != that.INVOICE_ID) return false;
        if (ITEM_ID != that.ITEM_ID) return false;
        if (QTY != that.QTY) return false;
        return Float.compare(that.PRICE, PRICE) == 0;
    }

    @Override
    public int hashCode() {
        int result = INVOICE_ID;
        result = 31 * result + ITEM_ID;
        result = 31 * result + QTY;
        result = 31 * result + (PRICE != +0.0f ? Float.floatToIntBits(PRICE) : 0);
        return result;
    }

    public int getINVOICE_ID() {
        return INVOICE_ID;
    }

    public void setINVOICE_ID(int INVOICE_ID) {
        this.INVOICE_ID = INVOICE_ID;
    }

    public int getITEM_ID() {
        return ITEM_ID;
    }

    public void setITEM_ID(int ITEM_ID) {
        this.ITEM_ID = ITEM_ID;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public float getPRICE() {
        return PRICE;
    }

    public void setPRICE(float PRICE) {
        this.PRICE = PRICE;
    }

    private float PRICE;

    public InvoiceTransactionDTO getClone() {
        try {
            return (InvoiceTransactionDTO) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public InvoiceTransactionDTO() {
    }

    @Override
    public int compareTo(InvoiceTransactionDTO o) {
        return String.valueOf(this.INVOICE_ID).compareTo(String.valueOf(o.INVOICE_ID));
    }
}
