package app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class LoginForm {
    @Id
    private int uid;

    public final int getUid() {
        return uid;
    }

    public final void setUid(int uid) {
        this.uid = uid;
    }

    @NotEmpty
    private String uname;

    @Size(min = 1, max = 8)
    private String upass;

    public final String getUname() {
        return uname;
    }

    public final void setUname(String uname) {
        this.uname = uname;
    }

    public final String getUpass() {
        return upass;
    }

    public final void setUpass(String upass) {
        this.upass = upass;
    }
}
