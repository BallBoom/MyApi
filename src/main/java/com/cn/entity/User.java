package com.cn.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author kai
 * @since 2018-11-17 18:05:05
 */
public class User implements Serializable {
    private static final long serialVersionUID = -57592904278190283L;
    
    private Integer id;
    
    private String uName;
    
    private String uPassword;
    
    private Integer roleId;
    
    private String uQq;
    
    private String uEmail;
    
    private String uPhone;
    
    private Date uRegister;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUQq() {
        return uQq;
    }

    public void setUQq(String uQq) {
        this.uQq = uQq;
    }

    public String getUEmail() {
        return uEmail;
    }

    public void setUEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getUPhone() {
        return uPhone;
    }

    public void setUPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public Date getURegister() {
        return uRegister;
    }

    public void setURegister(Date uRegister) {
        this.uRegister = uRegister;
    }

}