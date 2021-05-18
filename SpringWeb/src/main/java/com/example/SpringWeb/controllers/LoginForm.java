package com.example.SpringWeb.controllers;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginForm {

    @NotEmpty
    private String uname;
    @Size(min = 1, max = 8)
    private String upass;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }
}
