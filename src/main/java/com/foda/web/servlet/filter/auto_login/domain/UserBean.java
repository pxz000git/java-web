package com.foda.web.servlet.filter.auto_login.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ author pxz
 * @ date 2018/12/7 0007-下午 2:07
 */
public class UserBean implements Serializable{
    private String username;
    private String password;
    private String email;
    private String tel;
    private String address;
    private Date birthday;

    public UserBean() {
    }

    public UserBean(String username, String password, String email, String tel, String address, Date birthday) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
