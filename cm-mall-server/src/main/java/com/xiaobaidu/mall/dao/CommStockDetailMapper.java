package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.CommStock;
import com.xiaobaidu.mall.entity.CommStockDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommStockDetailMapper extends IQuery {

    int insert(CommStockDetail detail);



}