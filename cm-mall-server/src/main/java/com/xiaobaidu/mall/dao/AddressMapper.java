package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AddressMapper extends IQuery {

    int deleteByPrimaryKey(String id);

    int insert(Address record);

    Address selectByPrimaryKey(String id);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);

    void removeDefaultAddress(String userId);

    void setDefaultAddress(String id);

}