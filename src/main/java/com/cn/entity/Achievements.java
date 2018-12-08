package com.cn.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (Achievements)实体类
 *
 * @author kai
 * @since 2018-11-25 18:05:33
 */
public class Achievements implements Serializable {
    private static final long serialVersionUID = 153950122371954771L;
    
    private Integer id;
    
    private String fkSId;
    
    private String aName;
    
    private Date aTime;
    
    private Integer aPersons;
    
    private String worksName;
    
    private String aComplete;
    
    private String isReward;
    
    private String isPatent;
    
    private String aProve;


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

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public Date getATime() {
        return aTime;
    }

    public void setATime(Date aTime) {
        this.aTime = aTime;
    }

    public Integer getAPersons() {
        return aPersons;
    }

    public void setAPersons(Integer aPersons) {
        this.aPersons = aPersons;
    }

    public String getWorksName() {
        return worksName;
    }

    public void setWorksName(String worksName) {
        this.worksName = worksName;
    }

    public String getAComplete() {
        return aComplete;
    }

    public void setAComplete(String aComplete) {
        this.aComplete = aComplete;
    }

    public String getIsReward() {
        return isReward;
    }

    public void setIsReward(String isReward) {
        this.isReward = isReward;
    }

    public String getIsPatent() {
        return isPatent;
    }

    public void setIsPatent(String isPatent) {
        this.isPatent = isPatent;
    }

    public String getAProve() {
        return aProve;
    }

    public void setAProve(String aProve) {
        this.aProve = aProve;
    }

}