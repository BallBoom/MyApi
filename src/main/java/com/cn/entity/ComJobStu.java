package com.cn.entity;

import java.io.Serializable;

/**
 * (ComJobStu)实体类
 *
 * @author kai
 * @since 2018-11-29 11:55:23
 */
public class ComJobStu implements Serializable {
    private static final long serialVersionUID = -19580375834649281L;
    
    private Integer id;
    
    private Integer jId;

    private String jPost;
    
    private String cId;
    
    private String cName;
    
    private String sId;
    
    private String sName;
    
    private boolean flag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJId() {
        return jId;
    }

    public void setJId(Integer jId) {
        this.jId = jId;
    }

    public String getjPost() {
        return jPost;
    }

    public void setjPost(String jPost) {
        this.jPost = jPost;
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

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}