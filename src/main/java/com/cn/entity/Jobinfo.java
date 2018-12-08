package com.cn.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * (Jobinfo)实体类
 *
 * @author kai
 * @since 2018-11-25 22:21:11
 */
public class Jobinfo implements Serializable {
    private static final long serialVersionUID = 925281518493020163L;
    
    private Integer id;
    
    private String fkCId;

    private String cName;
    
    private Date jSTime;
    
    private Date jETime;

    private String jPost;
    
    private String jPerson;
    
    private String jPhone;
    
    private String jOthers;

    private Timestamp pubDate;

    private boolean flag;

    private ComJobStu comJobStu;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFkCId() {
        return fkCId;
    }

    public void setFkCId(String fkCId) {
        this.fkCId = fkCId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Date getJSTime() {
        return jSTime;
    }

    public void setJSTime(Date jSTime) {
        this.jSTime = jSTime;
    }

    public Date getJETime() {
        return jETime;
    }

    public void setJETime(Date jETime) {
        this.jETime = jETime;
    }

    public String getjPost() {
        return jPost;
    }

    public void setjPost(String jPost) {
        this.jPost = jPost;
    }

    public String getJPerson() {
        return jPerson;
    }

    public void setJPerson(String jPerson) {
        this.jPerson = jPerson;
    }

    public String getJPhone() {
        return jPhone;
    }

    public void setJPhone(String jPhone) {
        this.jPhone = jPhone;
    }

    public Timestamp getPubDate() {
        return pubDate;
    }

    public void setPubDate(Timestamp pubDate) {
        this.pubDate = pubDate;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getJOthers() {
        return jOthers;
    }

    public void setJOthers(String jOthers) {
        this.jOthers = jOthers;
    }

    @Override
    public String toString() {
        return "Jobinfo{" +
                "id=" + id +
                ", fkCId='" + fkCId + '\'' +
                ", jSTime=" + jSTime +
                ", jETime=" + jETime +
                ", jPost='" + jPost + '\'' +
                ", jPerson='" + jPerson + '\'' +
                ", jPhone='" + jPhone + '\'' +
                ", jOthers='" + jOthers + '\'' +
                '}';
    }
}