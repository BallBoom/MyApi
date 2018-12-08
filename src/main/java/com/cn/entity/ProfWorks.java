package com.cn.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (ProfWorks)实体类
 *
 * @author kai
 * @since 2018-12-03 17:01:01
 */
public class ProfWorks implements Serializable {
    private static final long serialVersionUID = 413704414886998064L;
    
    private Integer id;
    
    private String fkSId;
    
    private String wName;
    
    private String wIntroduction;
    
    private Date wDate;
    
    private String wPhoto;


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

    public String getWName() {
        return wName;
    }

    public void setWName(String wName) {
        this.wName = wName;
    }

    public String getWIntroduction() {
        return wIntroduction;
    }

    public void setWIntroduction(String wIntroduction) {
        this.wIntroduction = wIntroduction;
    }

    public Date getWDate() {
        return wDate;
    }

    public void setWDate(Date wDate) {
        this.wDate = wDate;
    }

    public String getWPhoto() {
        return wPhoto;
    }

    public void setWPhoto(String wPhoto) {
        this.wPhoto = wPhoto;
    }

}