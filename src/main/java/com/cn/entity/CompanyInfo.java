package com.cn.entity;

import java.io.Serializable;

/**
 * (CompanyInfo)实体类
 *
 * @author kai
 * @since 2018-11-24 23:46:19
 */
public class CompanyInfo implements Serializable {
    private static final long serialVersionUID = 148767880454952704L;
    
    private Integer id;
    
    private String uPhone;
    
    private String cId;
    
    private String cName;
//    联系人
    private String cContact;
//    联系人电话
    private String cPhone;
    
    private String cEmail;
//    QQ
    private String cQq;
    
    private String cBusiness;
    
    private String cTechnology;
    
    private String cProduct;
    
    private String cAddress;
    
    private String cPostCode;
    
    private String cPhoto;
    
    private String cWeb;
    
    private String cPlant;
    
    private boolean flag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUPhone() {
        return uPhone;
    }

    public void setUPhone(String uPhone) {
        this.uPhone = uPhone;
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

    public String getCContact() {
        return cContact;
    }

    public void setCContact(String cContact) {
        this.cContact = cContact;
    }

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCQq() {
        return cQq;
    }

    public void setCQq(String cQq) {
        this.cQq = cQq;
    }

    public String getCBusiness() {
        return cBusiness;
    }

    public void setCBusiness(String cBusiness) {
        this.cBusiness = cBusiness;
    }

    public String getCTechnology() {
        return cTechnology;
    }

    public void setCTechnology(String cTechnology) {
        this.cTechnology = cTechnology;
    }

    public String getCProduct() {
        return cProduct;
    }

    public void setCProduct(String cProduct) {
        this.cProduct = cProduct;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getCPostCode() {
        return cPostCode;
    }

    public void setCPostCode(String cPostCode) {
        this.cPostCode = cPostCode;
    }

    public String getCPhoto() {
        return cPhoto;
    }

    public void setCPhoto(String cPhoto) {
        this.cPhoto = cPhoto;
    }

    public String getCWeb() {
        return cWeb;
    }

    public void setCWeb(String cWeb) {
        this.cWeb = cWeb;
    }

    public String getCPlant() {
        return cPlant;
    }

    public void setCPlant(String cPlant) {
        this.cPlant = cPlant;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "id=" + id +
                ", uPhone='" + uPhone + '\'' +
                ", cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", cContact='" + cContact + '\'' +
                ", cPhone='" + cPhone + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", cQq='" + cQq + '\'' +
                ", cBusiness='" + cBusiness + '\'' +
                ", cTechnology='" + cTechnology + '\'' +
                ", cProduct='" + cProduct + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", cPostCode='" + cPostCode + '\'' +
                ", cPhoto='" + cPhoto + '\'' +
                ", cWeb='" + cWeb + '\'' +
                ", cPlant='" + cPlant + '\'' +
                ", flag=" + flag +
                '}';
    }
}