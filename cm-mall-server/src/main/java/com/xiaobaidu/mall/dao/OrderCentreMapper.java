package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.OrderCentre;
import com.xiaobaidu.mall.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface OrderCentreMapper extends IQuery {

    int insert(OrderCentre record);

    OrderCentre selectByPrimaryKey(String id);

    List<OrderCentre> selectAll();

    int updateByPrimaryKey(OrderCentre record);

    List<OrderVo> queryByMixDate(@Param("userId") String userId, @Param("mixDate") Date mixDate);

    OrderVo queryById(String id);
}