package ga.veee.day21.DB.DTO;

import java.io.Serializable;

public class InvoiceTransactionDTO implements Serializable, Cloneable {
    private static InvoiceTransactionDTO invoiceTransactionDTO;
    private int INVOICE_ID;
    private int ITEM_ID;
    private int QTY;

    synchronized public static InvoiceTransactionDTO getInvoiceTransactionDTO() {
        if (invoiceTransactionDTO == null) {
            invoiceTransactionDTO = new InvoiceTransactionDTO();
        }
        return invoiceTransactionDTO.getCloneInvoiceTransactionDTO();
    }

    private InvoiceTransactionDTO getCloneInvoiceTransactionDTO() {
        try {
            return (InvoiceTransactionDTO) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private InvoiceTransactionDTO() {

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

    @Override
    public String toString() {
        return "InvoiceTransactionDTO{" +
                "INVOICE_ID=" + INVOICE_ID +
                ", ITEM_ID=" + ITEM_ID +
                ", QTY=" + QTY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceTransactionDTO that = (InvoiceTransactionDTO) o;

        if (INVOICE_ID != that.INVOICE_ID) return false;
        if (ITEM_ID != that.ITEM_ID) return false;
        return QTY == that.QTY;
    }

    @Override
    public int hashCode() {
        int result = INVOICE_ID;
        result = 31 * result + ITEM_ID;
        result = 31 * result + QTY;
        return result;
    }
}
