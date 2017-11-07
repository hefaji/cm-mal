package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.CommStock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CommStockMapper extends IQuery {

    int insert(CommStock record);

    CommStock selectByCommCode(String commCode);

    int uploadByVersion(CommStock commStock);

}