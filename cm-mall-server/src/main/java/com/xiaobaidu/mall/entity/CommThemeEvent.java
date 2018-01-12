package com.xiaobaidu.mall.entity;

import com.xiaobaidu.mall.util.CollectionUtils;

import java.util.Date;
import java.util.List;

public class CommThemeEvent {

    private String id;

    private String commType;

    private String name;

    private String introduce;

    private String image;

    private Date startTime;

    private Date endTime;

    /**
     * 有多少商品
     */
    private int count;

    //明细
    private List<CommThemeEventDetail> details;

    private Integer status;

    private Integer pos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<CommThemeEventDetail> getDetails() {
        return details;
    }

    public void setDetails(List<CommThemeEventDetail> details) {
        this.details = details;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public int getCount() {
        if(CollectionUtils.isEmpty(details)){
            return 0;
        }else {
            return details.size();
        }
    }

    public void setCount(int count) {
        this.count = count;
    }
}