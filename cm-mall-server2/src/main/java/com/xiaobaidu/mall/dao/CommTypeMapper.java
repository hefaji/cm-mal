package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.CommType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CommTypeMapper extends IQuery {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comm_type
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comm_type
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    int insert(CommType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comm_type
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    CommType selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comm_type
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    List<CommType> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comm_type
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    int updateByPrimaryKey(CommType record);
}