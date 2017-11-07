package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ShoppingCartMapper extends IQuery {

    int deleteByPrimaryKey(String id);

    int insert(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(String id);

    List<ShoppingCart> selectAll();

    int updateByPrimaryKey(ShoppingCart record);

    List<ShoppingCart> selectByUserId(String id);

}