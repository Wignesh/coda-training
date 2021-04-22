package ga.veee.shopping.Entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "User", indexes = {
        @Index(name = "USER_USER_ID_uindex", columnList = "USER_ID", unique = true),
        @Index(name = "USER_USER_NAME_uindex", columnList = "USER_NAME", unique = true)
})
@Entity
public class User implements Cloneable, Serializable {
    @Id
    @Column(name = "USER_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Basic
    @Column(name = "USER_NAME", nullable = false, length = 24, unique = true)
    private String userName;
    @Basic
    @Column(name = "USER_PASSWORD", nullable = false, length = 24)
    private String userPassword;
    @Basic
    @Column(name = "FLAG", nullable = false)
    @ColumnDefault("0")
    private int flag;

    // Relationships
    @OneToMany(mappedBy = "user")
    private Set<InvoiceMaster> invoiceMasters;
    @OneToMany(mappedBy = "user")
    private Set<BillingAddress> billingAddresses;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(int userId, String userName, String userPassword, int flag) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.flag = flag;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (flag != user.flag) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(user.userPassword) : user.userPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + flag;
        return result;
    }


    @Override
    public String toString() {
        return "User(" +
                "userId = " + userId + ", " +
                "userName = " + userName + ", " +
                "userPassword = " + userPassword + ", " +
                "flag = " + flag + ")";
    }
}
