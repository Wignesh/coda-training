package ga.veee.day23.daopack;

import java.io.Serializable;

public class BillingAddressDTO implements Comparable<BillingAddressDTO>, Serializable, Cloneable {
    private int id, cutId;
    private String fname;

    @Override
    public String toString() {
        return "BillingAddressDTO{" +
                "id=" + id +
                ", cutId=" + cutId +
                ", fname='" + fname + '\'' +
                ", laname='" + laname + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", region='" + region + '\'' +
                ", town='" + town + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingAddressDTO that = (BillingAddressDTO) o;

        if (id != that.id) return false;
        if (cutId != that.cutId) return false;
        if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
        if (laname != null ? !laname.equals(that.laname) : that.laname != null) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (town != null ? !town.equals(that.town) : that.town != null) return false;
        if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cutId;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (laname != null ? laname.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCutId() {
        return cutId;
    }

    public void setCutId(int cutId) {
        this.cutId = cutId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLaname() {
        return laname;
    }

    public void setLaname(String laname) {
        this.laname = laname;
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

    public BillingAddressDTO() {
    }

    public BillingAddressDTO(int id, int cutId, String fname, String laname, String address1, String address2, String region, String town, String zip, String phone, String email) {
        this.id = id;
        this.cutId = cutId;
        this.fname = fname;
        this.laname = laname;
        this.address1 = address1;
        this.address2 = address2;
        this.region = region;
        this.town = town;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    private String laname;
    private String address1;
    private String address2;
    private String region;
    private String town;
    private String zip;
    private String phone;
    private String email;

    @Override
    public int compareTo(BillingAddressDTO o) {
        return this.fname.compareTo(o.fname);

    }

    public BillingAddressDTO getClone() {
        try {
            return (BillingAddressDTO) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
