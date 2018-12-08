package com.cn.entity;

import java.io.Serializable;

/**
 * (Practice)实体类
 * @author kai
 *
 * @since 2018-11-25 22:10:43
 */
public class Practice implements Serializable {
    private static final long serialVersionUID = -98465107615811672L;
    
    private Integer id;
    
    private String fkSId;
    
    private String pName;
    
    private String pRole;
    
    private String pContent;
    
    private String pScore;
    
    private String pProve;


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

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPRole() {
        return pRole;
    }

    public void setPRole(String pRole) {
        this.pRole = pRole;
    }

    public String getPContent() {
        return pContent;
    }

    public void setPContent(String pContent) {
        this.pContent = pContent;
    }

    public String getPScore() {
        return pScore;
    }

    public void setPScore(String pScore) {
        this.pScore = pScore;
    }

    public String getPProve() {
        return pProve;
    }

    public void setPProve(String pProve) {
        this.pProve = pProve;
    }

}