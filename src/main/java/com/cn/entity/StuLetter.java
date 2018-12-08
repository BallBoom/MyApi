package com.cn.entity;

import java.io.Serializable;

/**
 * (StuLetter)实体类
 *
 * @author kai
 * @since 2018-12-02 15:40:08
 */
public class StuLetter implements Serializable {
    private static final long serialVersionUID = 212311695266817415L;
    
    private Integer id;
    
    private String fkSId;
    
    private String letPhoto;


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

    public String getLetPhoto() {
        return letPhoto;
    }

    public void setLetPhoto(String letPhoto) {
        this.letPhoto = letPhoto;
    }


    @Override
    public String toString() {
        return "StuLetter{" +
                "id=" + id +
                ", fkSId='" + fkSId + '\'' +
                ", letPhoto='" + letPhoto + '\'' +
                '}';
    }
}