package com.cn.entity;

import java.io.Serializable;

/**
 * (StuAchCom)实体类
 *
 * @author kai
 * @since 2018-12-02 15:29:47
 */
public class StuAchCom implements Serializable {
    private static final long serialVersionUID = 357215963824896202L;
    
    private Integer id;
    
    private Integer aId;
    
    private String sId;
    
    private String sName;
    
    private String cId;
    
    private String cName;
    
    private String type;
    
    private Object flag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAId() {
        return aId;
    }

    public void setAId(Integer aId) {
        this.aId = aId;
    }

    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getFlag() {
        return flag;
    }

    public void setFlag(Object flag) {
        this.flag = flag;
    }

}