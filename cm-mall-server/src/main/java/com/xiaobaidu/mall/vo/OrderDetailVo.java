package com.xiaobaidu.mall.vo;

import com.xiaobaidu.mall.entity.Address;
import com.xiaobaidu.mall.entity.Commodity;

import java.io.Serializable;

/**
 * @author hefaji
 * @create 2017-10-13 12:12
 **/
public class OrderDetailVo implements Serializable {

    private String orderId;

    private Commodity commodity;

    private String commName;

    private int commCount;

    private double commSellPrice;

    public OrderDetailVo(String orderId, String commCode, String commName, int commCount, double commSellPrice) {
        this.orderId = orderId;
        this.commName = commName;
        this.commCount = commCount;
        this.commSellPrice = commSellPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public int getCommCount() {
        return commCount;
    }

    public void setCommCount(int commCount) {
        this.commCount = commCount;
    }

    public double getCommSellPrice() {
        return commSellPrice;
    }

    public void setCommSellPrice(double commSellPrice) {
        this.commSellPrice = commSellPrice;
    }
}
