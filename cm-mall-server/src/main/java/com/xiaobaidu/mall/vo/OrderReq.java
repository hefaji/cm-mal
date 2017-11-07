package com.xiaobaidu.mall.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author hefaji
 * @create 2017-09-21 18:47
 **/
public class OrderReq implements Serializable {
    private String addressId;
    private String userId;
    private String userNickName;

    private List<OrderDetailReq> orderDetailList;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public List<OrderDetailReq> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailReq> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
