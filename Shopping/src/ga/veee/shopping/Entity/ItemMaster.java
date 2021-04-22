package ga.veee.shopping.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ITEM_MASTER", schema = "CODA_TEST", indexes = {
        @Index(name = "ITEM_MASTER_ITEM_ID_uindex", columnList = "ITEM_ID", unique = true)
})
public class ItemMaster implements Cloneable, Serializable {
    @Id
    @Column(name = "ITEM_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = 64)
    private String description;
    @Basic
    @Column(name = "PRICE", nullable = false, precision = 0)
    private double price;
    @Basic
    @Column(name = "CATEGORY", nullable = false, length = 32)
    private String category;
    @Basic
    @Column(name = "UNIT", nullable = false, length = 32)
    private String unit;

    public ItemMaster() {
    }

    @Basic
    @Column(name = "IMAGE_URL", nullable = false, length = 160)
    private String imageUrl;

    public ItemMaster(String description, double price, String category, String unit, String imageUrl) {
        this.description = description;
        this.price = price;
        this.category = category;
        this.unit = unit;
        this.imageUrl = imageUrl;
    }

    public ItemMaster(int itemId, String description, double price, String category, String unit, String imageUrl) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
        this.category = category;
        this.unit = unit;
        this.imageUrl = imageUrl;
    }

    public int getItemId() {
        return itemId;
    }

    public int getId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemMaster that = (ItemMaster) o;

        if (itemId != that.itemId) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = itemId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ItemMaster(" +
                "itemId = " + itemId + ", " +
                "description = " + description + ", " +
                "price = " + price + ", " +
                "category = " + category + ", " +
                "unit = " + unit + ", " +
                "imageUrl = " + imageUrl + ")";
    }
}
