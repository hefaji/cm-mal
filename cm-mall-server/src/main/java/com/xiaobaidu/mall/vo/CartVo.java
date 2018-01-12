package com.xiaobaidu.mall.vo;

import com.xiaobaidu.mall.entity.CommThemeEvent;
import com.xiaobaidu.mall.entity.Commodity;
import com.xiaobaidu.mall.entity.ShoppingCart;

import java.io.Serializable;
import java.util.List;

/**
 *购物车
 * @author hefaji
 * @create 2017-09-15 12:10
 **/
public class CartVo implements Serializable {

    //总数量
   private Integer totalSum;

   //总价格
   private double totalPrice;

    /**
     * 商品明细集合
     */
   private List<CartGoodsVo> goodsList;

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartGoodsVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<CartGoodsVo> goodsList) {
        this.goodsList = goodsList;
    }
}
