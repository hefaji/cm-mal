package com.xiaobaidu.mall.web;

import com.xiaobaidu.mall.service.OrderCentreService;
import com.xiaobaidu.mall.vo.OrderReq;
import com.xiaobaidu.mall.vo.OrderVo;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单中心
 * @author hefaji
 * @create 2017-11-14 12:16
 **/
@RestController
@RequestMapping("/orderCenter")
public class OrderCenterController extends  BaseController{
    @Autowired
    private OrderCentreService orderCentreService;

    /**
     * 下单
     * @return
     */
    @RequestMapping(value = "/join")
    public String join(OrderReq orderReq){
        ResponseVo responseVo = orderCentreService.joinOrder(orderReq);
        return buildResponse(responseVo);
    }


    @RequestMapping(value = "/queryById")
    public String queryById(String id){
        ResponseVo<OrderVo> responseVo = orderCentreService.queryOrderById(id);
        return buildResponse(responseVo);
    }


    @RequestMapping(value = "/queryOrderList")
    public String queryOrderList(String userId,String queryCycle){
        ResponseVo<List<OrderVo>> responseVo = orderCentreService.queryOrderList(userId, queryCycle);
        return buildResponse(responseVo);
    }
}
