package ga.veee.day23;


import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyStreet() {
        return companyStreet;
    }

    public String getCompanyState() {
        return companyState;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public String getCompanyZip() {
        return companyZip;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public LocalDate getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public String getInvoiceComment() {
        return invoiceComment;
    }

    public String getBillToContactName() {
        return billToContactName;
    }

    public String getBillToCompanyName() {
        return billToCompanyName;
    }

    public String getBillToStreet() {
        return billToStreet;
    }

    public String getBillToCity() {
        return billToCity;
    }

    public String getBillToState() {
        return billToState;
    }

    public String getBillToCountry() {
        return billToCountry;
    }

    public String getBillToZip() {
        return billToZip;
    }

    public String getBillToPhone() {
        return billToPhone;
    }

    public String getBillToEmail() {
        return billToEmail;
    }

    public String getShipToContactName() {
        return shipToContactName;
    }

    public String getShipToCompanyName() {
        return shipToCompanyName;
    }

    public String getShipToStreet() {
        return shipToStreet;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public String getShipToState() {
        return shipToState;
    }

    public String getShipToCountry() {
        return shipToCountry;
    }

    public String getShipToZip() {
        return shipToZip;
    }

    public String getShipToPhone() {
        return shipToPhone;
    }

    public String getShipToEmail() {
        return shipToEmail;
    }

    public String getRemarks() {
        return remarks;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public float getSubTotalAfterDiscount() {
        return subTotalAfterDiscount;
    }


    public float getcGSTPercent() {
        return cGSTPercent;
    }

    public float getsGSTPercent() {
        return sGSTPercent;
    }

    public float getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(float shippingCharges) {
        this.shippingCharges = shippingCharges;
        this.calculate();
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
        this.calculate();
    }

    public void setTax(float cGSTPercent, float sGSTPercent) {
        this.cGSTPercent = cGSTPercent;
        this.sGSTPercent = sGSTPercent;
        this.sGSTAmount = this.getSubTotalAfterDiscount() * sGSTPercent / 100;
        this.cGSTAmount = this.getSubTotalAfterDiscount() * cGSTPercent / 100;
    }

    public float getTotalPayable() {
        return totalPayable;
    }

    public void addCompanyInfo(String companyName, String companyStreet, String companyCity, String companyState, String companyCountry, String companyZip, String companyPhone, String companyEmail) {
        this.companyName = companyName;
        this.companyStreet = companyStreet;
        this.companyState = companyState;
        this.companyCity = companyCity;
        this.companyCountry = companyCountry;
        this.companyZip = companyZip;
        this.companyPhone = companyPhone;
        this.companyEmail = companyEmail;
    }

    public void addInvoiceInfo(LocalDate invoiceDate, LocalDate invoiceDueDate, int invoiceId, String invoiceComment, String remarks) {
        this.invoiceDate = invoiceDate;
        this.invoiceDueDate = invoiceDueDate;
        this.invoiceId = invoiceId;
        this.invoiceComment = invoiceComment;
        this.remarks = remarks;
    }

    public void addBillToInfo(String billToContactName, String billToCompanyName, String billToStreet, String billToCity, String billToState, String billToCountry, String billToZip, String billToPhone, String billToEmail) {
        this.billToContactName = billToContactName;
        this.billToCompanyName = billToCompanyName;
        this.billToStreet = billToStreet;
        this.billToCity = billToCity;
        this.billToState = billToState;
        this.billToCountry = billToCountry;
        this.billToZip = billToZip;
        this.billToPhone = billToPhone;
        this.billToEmail = billToEmail;
    }

    public void addShipToInfo(String shipToContactName, String shipToCompanyName, String shipToStreet, String shipToCity, String shipToState, String shipToCountry, String shipToZip, String shipToPhone, String shipToEmail) {
        this.shipToContactName = shipToContactName;
        this.shipToCompanyName = shipToCompanyName;
        this.shipToStreet = shipToStreet;
        this.shipToCity = shipToCity;
        this.shipToState = shipToState;
        this.shipToCountry = shipToCountry;
        this.shipToZip = shipToZip;
        this.shipToPhone = shipToPhone;
        this.shipToEmail = shipToEmail;
    }

    public void addItem(InvoiceItem invoiceItem) {
        this.invoiceItems.add(invoiceItem);
        this.subTotal += invoiceItem.getTotal();
        this.calculate();
    }

    private String companyName;
    private String companyStreet;
    private String companyState;

    public String getCompanyCity() {
        return companyCity;
    }

    private String companyCity;
    private String companyCountry;
    private String companyZip;
    private String companyPhone;
    private String companyEmail;
    private LocalDate invoiceDate, invoiceDueDate;
    private int invoiceId;
    private String invoiceComment;

    private String billToContactName, billToCompanyName, billToStreet, billToCity, billToState, billToCountry, billToZip, billToPhone, billToEmail;
    private String shipToContactName, shipToCompanyName, shipToStreet, shipToCity, shipToState, shipToCountry, shipToZip, shipToPhone, shipToEmail;
    private ArrayList<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();

    public ArrayList<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    private String remarks;
    private float subTotal, subTotalAfterDiscount, cGSTPercent, sGSTPercent, shippingCharges;
    private float discountAmount;

    public float getsGSTAmount() {
        return sGSTAmount;
    }

    public float getcGSTAmount() {
        return cGSTAmount;
    }

    private float sGSTAmount;
    private float cGSTAmount;
    private float totalPayable;

    private void calculate() {
        this.calculateDiscount();
    }

    private void calculateDiscount() {
        this.subTotalAfterDiscount = this.subTotal - this.discountAmount;
        this.calculateTax();
    }

    private void calculateTax() {
        if (this.sGSTPercent > 0 && this.cGSTPercent > 0) {
            this.sGSTAmount = this.getSubTotalAfterDiscount() * this.getsGSTPercent() / 100;
            this.cGSTAmount = this.getSubTotalAfterDiscount() * this.getcGSTPercent() / 100;
        }
        this.calculateTotal();
    }

    private void calculateTotal() {
        this.totalPayable = this.getSubTotalAfterDiscount() + this.getsGSTAmount() + this.getcGSTAmount() + this.getShippingCharges();
    }
}
