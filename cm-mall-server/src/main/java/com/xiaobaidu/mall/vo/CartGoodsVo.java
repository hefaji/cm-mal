package com.xiaobaidu.mall.vo;

import com.xiaobaidu.mall.entity.ShoppingCart;

import java.io.Serializable;
import java.util.List;

/**
 *购物车商品
 * @author hefaji
 * @create 2017-09-15 12:10
 **/
public class CartGoodsVo implements Serializable {

    private String commCode;

    private String commName;

    private double sellPrice;

    private int count;

    private String image;

    private double totalPrice;

    public String getCommCode() {
        return commCode;
    }

    public void setCommCode(String commCode) {
        this.commCode = commCode;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
