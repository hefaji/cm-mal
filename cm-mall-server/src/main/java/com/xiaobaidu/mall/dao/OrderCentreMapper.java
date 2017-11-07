package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.OrderCentre;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
@Mapper
public interface OrderCentreMapper extends IQuery {

    int insert(OrderCentre record);

    OrderCentre selectByPrimaryKey(String id);

    List<OrderCentre> selectAll();

    int updateByPrimaryKey(OrderCentre record);

    List<OrderCentre> queryByMixDate(String userId,Date mixDate);
}