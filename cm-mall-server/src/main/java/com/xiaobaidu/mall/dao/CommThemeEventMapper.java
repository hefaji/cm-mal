package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.CommThemeEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CommThemeEventMapper extends IQuery {
    List<CommThemeEvent> getListByCommTypeId(String commTypeId);
}