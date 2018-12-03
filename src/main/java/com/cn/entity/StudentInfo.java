package com.cn.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (StudentInfo)实体类
 *
 * @author kai
 * @since 2018-11-23 00:14:44
 */
public class StudentInfo implements Serializable {
    private static final long serialVersionUID = 780457234231566015L;
    
    private Integer id;
    
    private String uPhone;
    
    private String sId;
    
    private String sName;
    
    private String sSex;
    
    private String sSchool;
    
    private String sProfession;
    
    private String sClass;
    
    private String sRemarks;
    
    private String sStatus;
    
    private String sExpertise;
//    学生证图片
    private String sProve;
    
    private boolean flag;
    //      推荐信
    private StuLetter stuLetter;

    //     社会实践信息
    private List<Practice> practiceList;
//      竞赛信息
    private List<Contest> contestsList;
//      成果信息
    private List<Achievements> achievementsList;


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

    public String getSSex() {
        return sSex;
    }

    public void setSSex(String sSex) {
        this.sSex = sSex;
    }

    public String getSSchool() {
        return sSchool;
    }

    public void setSSchool(String sSchool) {
        this.sSchool = sSchool;
    }

    public String getSProfession() {
        return sProfession;
    }

    public void setSProfession(String sProfession) {
        this.sProfession = sProfession;
    }

    public String getSClass() {
        return sClass;
    }

    public void setSClass(String sClass) {
        this.sClass = sClass;
    }

    public String getSRemarks() {
        return sRemarks;
    }

    public void setSRemarks(String sRemarks) {
        this.sRemarks = sRemarks;
    }

    public String getSStatus() {
        return sStatus;
    }

    public void setSStatus(String sStatus) {
        this.sStatus = sStatus;
    }

    public String getSExpertise() {
        return sExpertise;
    }

    public void setSExpertise(String sExpertise) {
        this.sExpertise = sExpertise;
    }

    public String getsProve() {
        return sProve;
    }

    public void setsProve(String sProve) {
        this.sProve = sProve;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<Practice> getPracticeList() {
        return practiceList;
    }

    public void setPracticeList(List<Practice> practiceList) {
        this.practiceList = practiceList;
    }

    public List<Contest> getContestsList() {
        return contestsList;
    }

    public void setContestsList(List<Contest> contestsList) {
        this.contestsList = contestsList;
    }

    public List<Achievements> getAchievementsList() {
        return achievementsList;
    }

    public void setAchievementsList(List<Achievements> achievementsList) {
        this.achievementsList = achievementsList;
    }

    public StuLetter getStuLetter() {
        return stuLetter;
    }

    public void setStuLetter(StuLetter stuLetter) {
        this.stuLetter = stuLetter;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", uPhone='" + uPhone + '\'' +
                ", sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sSchool='" + sSchool + '\'' +
                ", sProfession='" + sProfession + '\'' +
                ", sClass='" + sClass + '\'' +
                ", sRemarks='" + sRemarks + '\'' +
                ", sStatus='" + sStatus + '\'' +
                ", sExpertise='" + sExpertise + '\'' +
                ", sProve='" + sProve + '\'' +
                ", flag=" + flag +
                '}';
    }
}