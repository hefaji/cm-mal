package com.xiaobaidu.mall.vo;

import com.xiaobaidu.mall.entity.CommImages;
import com.xiaobaidu.mall.entity.CommThemeEvent;
import com.xiaobaidu.mall.entity.CommType;
import com.xiaobaidu.mall.entity.Commodity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 分类商品展示,热销商品、主题商品1、主题商品2、除热销外商品集合
 * @author hefaji
 * @create 2017-09-15 12:10
 **/
public class CommTypeVo implements Serializable {

    //分类id
    private String typeId;

    private String typeName;

    private String image;

    private boolean isCurrt = false;
    //热销
    private List<Commodity> hotCommodityList;

    //普通分类集合
    private List<Commodity>commoditiyList;

    //主题商品1
    private CommThemeEvent commThemeEventFirst;

    //主题商品2
    private CommThemeEvent commThemeEventSecond;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public List<Commodity> getHotCommodityList() {
        return hotCommodityList;
    }

    public void setHotCommodityList(List<Commodity> hotCommodityList) {
        this.hotCommodityList = hotCommodityList;
    }

    public List<Commodity> getCommoditiyList() {
        return commoditiyList;
    }

    public void setCommoditiyList(List<Commodity> commoditiyList) {
        this.commoditiyList = commoditiyList;
    }

    public CommThemeEvent getCommThemeEventFirst() {
        return commThemeEventFirst;
    }

    public void setCommThemeEventFirst(CommThemeEvent commThemeEventFirst) {
        this.commThemeEventFirst = commThemeEventFirst;
    }

    public CommThemeEvent getCommThemeEventSecond() {
        return commThemeEventSecond;
    }

    public void setCommThemeEventSecond(CommThemeEvent commThemeEventSecond) {
        this.commThemeEventSecond = commThemeEventSecond;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getIsCurrt() {
        return isCurrt;
    }

    public void setIsCurrt(boolean currt) {
        isCurrt = currt;
    }
}
