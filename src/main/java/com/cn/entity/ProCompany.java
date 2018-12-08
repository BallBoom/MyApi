package com.cn.entity;

import java.sql.Date;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * (ProCompany)实体类
 *
 * @author kai
 * @since 2018-11-25 22:26:26
 */
public class ProCompany implements Serializable {
    private static final long serialVersionUID = 896950861300076926L;
    
    private Integer id;
    
    private String fkCId;

    private String cName;
    
    private String cpName;
    
    private double cpReward;
    
    private String cpDemand;
    
    private Date cpStartT;
    
    private Date cpEndT;
    
    private String cpDetail;

    private Timestamp pubDate;
    
    private boolean cpFlag;

    private ComProStu comProStu;


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

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public double getCpReward() {
        return cpReward;
    }

    public void setCpReward(double cpReward) {
        this.cpReward = cpReward;
    }

    public String getCpDemand() {
        return cpDemand;
    }

    public void setCpDemand(String cpDemand) {
        this.cpDemand = cpDemand;
    }

    public Date getCpStartT() {
        return cpStartT;
    }

    public void setCpStartT(Date cpStartT) {
        this.cpStartT = cpStartT;
    }

    public Date getCpEndT() {
        return cpEndT;
    }

    public void setCpEndT(Date cpEndT) {
        this.cpEndT = cpEndT;
    }

    public String getCpDetail() {
        return cpDetail;
    }

    public void setCpDetail(String cpDetail) {
        this.cpDetail = cpDetail;
    }

    public Timestamp getPubDate() {
        return pubDate;
    }

    public void setPubDate(Timestamp pubDate) {
        this.pubDate = pubDate;
    }

    public boolean getCpFlag() {
        return cpFlag;
    }

    public void setCpFlag(boolean cpFlag) {
        this.cpFlag = cpFlag;
    }

    public ComProStu getComProStu() {
        return comProStu;
    }

    public void setComProStu(ComProStu comProStu) {
        this.comProStu = comProStu;
    }

    @Override
    public String toString() {
        return "ProCompany{" +
                "id=" + id +
                ", fkCId='" + fkCId + '\'' +
                ", cName='" + cName + '\'' +
                ", cpName='" + cpName + '\'' +
                ", cpReward=" + cpReward +
                ", cpDemand='" + cpDemand + '\'' +
                ", cpStartT=" + cpStartT +
                ", cpEndT=" + cpEndT +
                ", cpDetail='" + cpDetail + '\'' +
                ", pubDate=" + pubDate +
                ", cpFlag=" + cpFlag +
                ", comProStu=" + comProStu +
                '}';
    }
}