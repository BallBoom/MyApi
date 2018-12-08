package com.cn.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (Contest)实体类
 *
 * @author kai
 * @since 2018-11-25 22:09:33
 */
public class Contest implements Serializable {
    private static final long serialVersionUID = 238516983978519446L;
    
    private Integer id;
    
    private String fkSId;
    
    private String cName;
    
    private Date cDate;
    
    private String cGrade;
    
    private String cLever;
    
    private String cProve;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFkSId() {
        return fkSId;
    }

    public void setFkSId(String fkSId) {
        this.fkSId = fkSId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public Date getCDate() {
        return cDate;
    }

    public void setCDate(Date cDate) {
        this.cDate = cDate;
    }

    public String getCGrade() {
        return cGrade;
    }

    public void setCGrade(String cGrade) {
        this.cGrade = cGrade;
    }

    public String getCLever() {
        return cLever;
    }

    public void setCLever(String cLever) {
        this.cLever = cLever;
    }

    public String getCProve() {
        return cProve;
    }

    public void setCProve(String cProve) {
        this.cProve = cProve;
    }

}