package com.xiaobaidu.mall.vo;

import com.xiaobaidu.mall.entity.Address;
import com.xiaobaidu.mall.entity.Commodity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author hefaji
 * @create 2017-10-13 12:12
 **/
public class OrderDetailVo implements Serializable {

    private String orderId;

    private Commodity commodity;

    private Integer commCount;

    private BigDecimal commSellPrice;

    public OrderDetailVo(String orderId,  Integer commCount, BigDecimal commSellPrice,String commCode) {
        this.orderId = orderId;
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

    public Integer getCommCount() {
        return commCount;
    }

    public void setCommCount(Integer commCount) {
        this.commCount = commCount;
    }

    public BigDecimal getCommSellPrice() {
        return commSellPrice;
    }

    public void setCommSellPrice(BigDecimal commSellPrice) {
        this.commSellPrice = commSellPrice;
    }

}
