package com.xiaobaidu.mall.entity;

import java.math.BigDecimal;

/**
 * @author hefaji
 * @create 2017-09-20 15:15
 **/
public class CommThemeEventDetail {
    private String id;

    private String eventId;

    //商品编码
    private String commCode;

    //商品名称
    private String commName;

    //价格单位
    private String priceUnit;

    //商品介绍
    private String commIntroduce;

    private String bigImage;

    //库存
    private Integer stock;

    private BigDecimal themeSellPrice;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public BigDecimal getThemeSellPrice() {
        return themeSellPrice;
    }

    public void setThemeSellPrice(BigDecimal themeSellPrice) {
        this.themeSellPrice = themeSellPrice;
    }

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

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getCommIntroduce() {
        return commIntroduce;
    }

    public void setCommIntroduce(String commIntroduce) {
        this.commIntroduce = commIntroduce;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
