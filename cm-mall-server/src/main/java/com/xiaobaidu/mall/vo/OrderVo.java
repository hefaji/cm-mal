package com.xiaobaidu.mall.vo;

import com.xiaobaidu.mall.entity.Address;

import java.io.Serializable;
import java.util.List;

/**
 * @author hefaji
 * @create 2017-10-13 12:12
 **/
public class OrderVo implements Serializable {
    private String orderId;

    private Address address;

    private String userId;

    private String userNickName;

    private String orderTime;

    private String status;

    private List<OrderDetailVo> detailVoList;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetailVo> getDetailVoList() {
        return detailVoList;
    }

    public void setDetailVoList(List<OrderDetailVo> detailVoList) {
        this.detailVoList = detailVoList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
