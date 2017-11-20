package com.xiaobaidu.mall.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author hefaji
 * @create 2017-09-21 18:47
 **/
public class OrderReq implements Serializable {
    @NotBlank(message="用户地址不能为空")
    private String addressId;

    @NotBlank(message="用户Id不能为空")
    private String userId;
    private String userNickName;

    @NotNull(message="商品不能为空")
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
