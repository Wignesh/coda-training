package ga.veee.shopping.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BILLING_ADDRESS", schema = "CODA_TEST", indexes = {
        @Index(name = "BILLING_ADDRESS_BILLING_ID_uindex", columnList = "BILLING_ID", unique = true)
})
public class BillingAddress implements Cloneable, Serializable {
    @Id
    @Column(name = "BILLING_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billingId;
    @Basic
    @Column(name = "FNAME", nullable = false, length = 32)
    private String fname;
    @Basic
    @Column(name = "LNAME", nullable = false, length = 32)
    private String lname;
    @Basic
    @Column(name = "ADDRESS1", nullable = false, length = 32)
    private String address1;
    @Basic
    @Column(name = "ADDRESS2", nullable = false, length = 32)
    private String address2;
    @Basic
    @Column(name = "REGION", nullable = false, length = 32)
    private String region;
    @Basic
    @Column(name = "TOWN", nullable = false, length = 32)
    private String town;
    @Basic
    @Column(name = "ZIP", nullable = false, length = 12)
    private String zip;
    @Basic
    @Column(name = "PHONE", nullable = false, length = 32)
    private String phone;
    @Basic
    @Column(name = "EMAIL", nullable = false, length = 32)
    private String email;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
    private User user;

    public BillingAddress() {
    }

    public int getBillingId() {
        return billingId;
    }

    public int getId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingAddress that = (BillingAddress) o;

        if (billingId != that.billingId) return false;
        if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
        if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (town != null ? !town.equals(that.town) : that.town != null) return false;
        if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = billingId;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BillingAddress(" +
                "billingId = " + billingId + ", " +
                "fname = " + fname + ", " +
                "lname = " + lname + ", " +
                "address1 = " + address1 + ", " +
                "address2 = " + address2 + ", " +
                "region = " + region + ", " +
                "town = " + town + ", " +
                "zip = " + zip + ", " +
                "phone = " + phone + ", " +
                "email = " + email + ")";
    }
}
