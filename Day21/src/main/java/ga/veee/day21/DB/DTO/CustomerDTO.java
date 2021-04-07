package ga.veee.day21.DB.DTO;

import java.io.Serializable;

public class CustomerDTO implements Serializable, Cloneable {
    private static CustomerDTO customerDTO;
    private int CUSTOMER_ID;
    private String CUSTOMER_NAME;
    private String CUSTOMER_ADDRESS;
    private String CUSTOMER_PHONE;
    private String CUSTOMER_EMAIL;
    private String CUSTOMER_GST_NNO;

    synchronized public static CustomerDTO getCustomerDTO() {
        if (customerDTO == null) {
            customerDTO = new CustomerDTO();
        }
        return customerDTO.getCloneCustomerDTO();
    }

    private CustomerDTO getCloneCustomerDTO() {
        try {
            return (CustomerDTO) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private CustomerDTO() {

    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public String getCUSTOMER_NAME() {
        return CUSTOMER_NAME;
    }

    public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
    }

    public String getCUSTOMER_ADDRESS() {
        return CUSTOMER_ADDRESS;
    }

    public void setCUSTOMER_ADDRESS(String CUSTOMER_ADDRESS) {
        this.CUSTOMER_ADDRESS = CUSTOMER_ADDRESS;
    }

    public String getCUSTOMER_PHONE() {
        return CUSTOMER_PHONE;
    }

    public void setCUSTOMER_PHONE(String CUSTOMER_PHONE) {
        this.CUSTOMER_PHONE = CUSTOMER_PHONE;
    }

    public String getCUSTOMER_EMAIL() {
        return CUSTOMER_EMAIL;
    }

    public void setCUSTOMER_EMAIL(String CUSTOMER_EMAIL) {
        this.CUSTOMER_EMAIL = CUSTOMER_EMAIL;
    }

    public String getCUSTOMER_GST_NNO() {
        return CUSTOMER_GST_NNO;
    }

    public void setCUSTOMER_GST_NNO(String CUSTOMER_GST_NNO) {
        this.CUSTOMER_GST_NNO = CUSTOMER_GST_NNO;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "CUSTOMER_ID=" + CUSTOMER_ID +
                ", CUSTOMER_NAME='" + CUSTOMER_NAME + '\'' +
                ", CUSTOMER_ADDRESS='" + CUSTOMER_ADDRESS + '\'' +
                ", CUSTOMER_PHONE='" + CUSTOMER_PHONE + '\'' +
                ", CUSTOMER_EMAIL='" + CUSTOMER_EMAIL + '\'' +
                ", CUSTOMER_GST_NNO='" + CUSTOMER_GST_NNO + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDTO that = (CustomerDTO) o;

        if (CUSTOMER_ID != that.CUSTOMER_ID) return false;
        if (CUSTOMER_NAME != null ? !CUSTOMER_NAME.equals(that.CUSTOMER_NAME) : that.CUSTOMER_NAME != null)
            return false;
        if (CUSTOMER_ADDRESS != null ? !CUSTOMER_ADDRESS.equals(that.CUSTOMER_ADDRESS) : that.CUSTOMER_ADDRESS != null)
            return false;
        if (CUSTOMER_PHONE != null ? !CUSTOMER_PHONE.equals(that.CUSTOMER_PHONE) : that.CUSTOMER_PHONE != null)
            return false;
        if (CUSTOMER_EMAIL != null ? !CUSTOMER_EMAIL.equals(that.CUSTOMER_EMAIL) : that.CUSTOMER_EMAIL != null)
            return false;
        return CUSTOMER_GST_NNO != null ? CUSTOMER_GST_NNO.equals(that.CUSTOMER_GST_NNO) : that.CUSTOMER_GST_NNO == null;
    }

    @Override
    public int hashCode() {
        int result = CUSTOMER_ID;
        result = 31 * result + (CUSTOMER_NAME != null ? CUSTOMER_NAME.hashCode() : 0);
        result = 31 * result + (CUSTOMER_ADDRESS != null ? CUSTOMER_ADDRESS.hashCode() : 0);
        result = 31 * result + (CUSTOMER_PHONE != null ? CUSTOMER_PHONE.hashCode() : 0);
        result = 31 * result + (CUSTOMER_EMAIL != null ? CUSTOMER_EMAIL.hashCode() : 0);
        result = 31 * result + (CUSTOMER_GST_NNO != null ? CUSTOMER_GST_NNO.hashCode() : 0);
        return result;
    }
}
