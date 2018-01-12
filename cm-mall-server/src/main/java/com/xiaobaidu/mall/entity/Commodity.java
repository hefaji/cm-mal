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
    private String typeName;
    private String typeId;

    //商品介绍
    private String introduce;

    private String bigImage;

    private String middleImage;

    private String smallImage;

    private String icon;

    //是否启用
    private Integer enable;

    //库存
    private Integer stock;

    //销量
    private Integer sellCount;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getMiddleImage() {
        return middleImage;
    }

    public void setMiddleImage(String middleImage) {
        this.middleImage = middleImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }
}
