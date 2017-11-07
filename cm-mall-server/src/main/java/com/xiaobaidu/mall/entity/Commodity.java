package com.xiaobaidu.mall.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author hefaji
 * @create 2017-09-15 12:10
 **/
public class Commodity implements Serializable {

    private String id;

    //商品编码
    private String code;

    //商品名称
    private String name;

    //商品价格
    private BigDecimal price;

    //商品售价
    private BigDecimal sellPrice;

    //价格单位
    private String priceUnit;

    //首页热门推荐
    private int hot;

    //分类热销
    private int hotSell;

    //商品分类
    private CommType commType;

    //商品介绍
    private String introduce;

    //商品图片
    private CommImages images;

    //是否启用
    private Integer enable;

    //库存
    private Integer stock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public CommType getCommType() {
        return commType;
    }

    public void setCommType(CommType commType) {
        this.commType = commType;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public CommImages getImages() {
        return images;
    }

    public void setImages(CommImages images) {
        this.images = images;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getHotSell() {
        return hotSell;
    }

    public void setHotSell(int hotSell) {
        this.hotSell = hotSell;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
