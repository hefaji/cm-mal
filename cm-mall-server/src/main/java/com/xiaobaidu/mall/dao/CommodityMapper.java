package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CommodityMapper extends IQuery {


    Commodity selectByPrimaryKey(String id);

    int updateByPrimaryKey(Commodity record);

    /**
     * 获取热门商品
     * @return
     */
    List<Commodity> getHotCommodity();

    /**
     * 根据类型获取商品
     * @param typeId
     * @return
     */
    List<Commodity>getByTypeId(String typeId);

    /**
     * 根据类型获取热销商品
     * @param id
     * @return
     */
    List<Commodity>getHotSellByTypeId(String id);

    /**
     * 根据code获取
     * @param code
     * @return
     */
    Commodity getCommodityByCode (String code);


    Commodity getCommodityById (String Id);

    /**
     * 通过关键字搜索商品，搜索范围，商品名称，类型名称，商品描述
     * @return
     */
    List<Commodity> searchByKeyword(String keyword);

}