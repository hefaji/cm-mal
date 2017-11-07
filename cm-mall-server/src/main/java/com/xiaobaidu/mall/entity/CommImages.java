package com.xiaobaidu.mall.entity;

import java.util.Date;

public class CommImages {

    private String id;

    private String commCode;

    private String bigImage;

    private String middleImage;

    private String smallImage;

    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommCode() {
        return commCode;
    }

    public void setCommCode(String commCode) {
        this.commCode = commCode;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getMiddleImage() {
        return middleImage;
    }

    public void setMiddleImage(String middleImage) {
        this.middleImage = middleImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "CommImages{" +
                "id='" + id + '\'' +
                ", commCode='" + commCode + '\'' +
                ", bigImage='" + bigImage + '\'' +
                ", middleImage='" + middleImage + '\'' +
                ", smallImage='" + smallImage + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}