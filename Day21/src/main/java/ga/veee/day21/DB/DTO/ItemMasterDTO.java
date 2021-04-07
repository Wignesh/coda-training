package ga.veee.day21.DB.DTO;

import java.io.Serializable;

public class ItemMasterDTO implements Serializable, Cloneable {
    private int ITEM_ID;
    private String DESCRIPTION;
    private float PRICE;

    private static ItemMasterDTO itemMasterDTO;

    synchronized public static ItemMasterDTO getItemDTO() {
        if (itemMasterDTO == null) {
            itemMasterDTO = new ItemMasterDTO();
        }
        return itemMasterDTO.getCloneItemDTO();
    }

    private ItemMasterDTO getCloneItemDTO() {
        try {
            return (ItemMasterDTO) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ItemMasterDTO() {

    }

    @Override
    public String toString() {
        return "ITEM{" +
                "ITEM_ID=" + ITEM_ID +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", PRICE=" + PRICE +
                '}';
    }

    public final int getITEM_ID() {
        return ITEM_ID;
    }

    public final void setITEM_ID(int ITEM_ID) {
        this.ITEM_ID = ITEM_ID;
    }

    public final String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public final void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public final float getPRICE() {
        return PRICE;
    }

    public final void setPRICE(float PRICE) {
        this.PRICE = PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemMasterDTO itemMasterDTO = (ItemMasterDTO) o;

        if (ITEM_ID != itemMasterDTO.ITEM_ID) return false;
        if (Float.compare(itemMasterDTO.PRICE, PRICE) != 0) return false;
        return DESCRIPTION != null ? DESCRIPTION.equals(itemMasterDTO.DESCRIPTION) : itemMasterDTO.DESCRIPTION == null;
    }

    @Override
    public int hashCode() {
        int result = ITEM_ID;
        result = 31 * result + (DESCRIPTION != null ? DESCRIPTION.hashCode() : 0);
        result = 31 * result + (PRICE != +0.0f ? Float.floatToIntBits(PRICE) : 0);
        return result;
    }
}
