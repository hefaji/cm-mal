package com.xiaobaidu.mall.service;

import com.xiaobaidu.mall.vo.OrderReq;
import com.xiaobaidu.mall.vo.OrderVo;
import com.xiaobaidu.mall.vo.ResponseVo;

import java.util.List;

/**
 * 订单中心
 * @author hefaji
 * @create 2017-09-21 17:25
 **/
public interface OrderCentreService {

    /**
     * 加入订单
     * @param orderReq
     * @return
     */
    ResponseVo joinOrder(OrderReq orderReq);


    /**
     * 查询规定时间内的订单
     * @param userId
     * @param queryCycle
     * @return
     */
    ResponseVo<List<OrderVo>> queryOrderList(String userId,String queryCycle);



}
