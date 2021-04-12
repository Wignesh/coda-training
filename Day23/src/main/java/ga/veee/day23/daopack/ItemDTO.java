package ga.veee.day23.daopack;

import java.io.Serializable;

public class ItemDTO implements Comparable<ItemDTO>, Serializable, Cloneable {
    private int itemId;
    private String description, category, unit, imageUrl;
    float price;

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", unit='" + unit + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                '}';
    }

    public ItemDTO(int itemId, String description, String category, String unit, String imageUrl, float price) {
        super();
        this.itemId = itemId;
        this.description = description;
        this.category = category;
        this.unit = unit;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public ItemDTO() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemDTO itemDTO = (ItemDTO) o;

        if (itemId != itemDTO.itemId) return false;
        if (Float.compare(itemDTO.price, price) != 0) return false;
        if (description != null ? !description.equals(itemDTO.description) : itemDTO.description != null) return false;
        if (category != null ? !category.equals(itemDTO.category) : itemDTO.category != null) return false;
        if (unit != null ? !unit.equals(itemDTO.unit) : itemDTO.unit != null) return false;
        return imageUrl != null ? imageUrl.equals(itemDTO.imageUrl) : itemDTO.imageUrl == null;
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }

    public int getItemId() {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int compareTo(ItemDTO o) {
        return this.description.compareTo(o.description);
    }

    public ItemDTO getClone() {
        try {
            return (ItemDTO) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
