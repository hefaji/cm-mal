package com.xiaobaidu.mall.service;

import com.xiaobaidu.mall.entity.CommType;
import com.xiaobaidu.mall.entity.Commodity;
import com.xiaobaidu.mall.vo.CommTypeVo;
import com.xiaobaidu.mall.vo.ResponseVo;

import java.util.List;

/**
 * @author hefaji
 * @create 2017-09-15 12:06
 **/

public interface CommodityService {

    /**
     * 获取热门推荐类型
     * @return
     */
    ResponseVo<List<CommType>> getHotCommType();

    /**
     * 根据类型id获取商品
     * @param typeId
     * @return
     */
    ResponseVo<List<Commodity>>getByTypeId(String typeId);

    /**
     * 获取全部类型，及类型下的子类型
     * @return
     */
    ResponseVo<List<CommType>>getAllType();

    /**
     * 获取首页展示的热门商品
     * @return
     */
    ResponseVo<List<Commodity>>getHotCommodity();

    /**
     * 根据分类获取分类页展示（热销，主题一，主题二、普通商品集合）
     * @param typeId
     * @return
     */
    ResponseVo<CommTypeVo> getCommTypeVoByCommType(String typeId);




}
