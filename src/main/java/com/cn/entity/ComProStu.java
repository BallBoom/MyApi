package com.cn.entity;

import java.io.Serializable;

/**
 * (ComProStu)实体类
 *
 * @author kai
 * @since 2018-11-28 15:54:35
 */
public class ComProStu implements Serializable {
    private static final long serialVersionUID = -93953333812553684L;
    
    private Integer id;
    
    private Integer pId;
    
    private String pName;
    
    private String cId;
    
    private String cName;
    
    private String sId;
    
    private String sName;
    
    private String pState;
    
    private String cComment;
    
    private boolean flag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
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

    public String getPState() {
        return pState;
    }

    public void setPState(String pState) {
        this.pState = pState;
    }

    public String getCComment() {
        return cComment;
    }

    public void setCComment(String cComment) {
        this.cComment = cComment;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}