package ga.veee.day23;


public class InvoiceItem {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public InvoiceItem(String description, String imageURL, int quantity, int itemId, float unitPrice) {
        this.description = description;
        this.imageURL = imageURL;
        this.quantity = quantity;
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.total = quantity * unitPrice;
    }

    private String description;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    private String imageURL;
    private int quantity, itemId;
    private float unitPrice, total;

}
