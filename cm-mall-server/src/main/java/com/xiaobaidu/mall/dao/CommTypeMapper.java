package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.CommType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CommTypeMapper extends IQuery {
    List<CommType> findHotType();
    //获取所有一级分类，及分类下的子分类
    List<CommType> findAll();
}