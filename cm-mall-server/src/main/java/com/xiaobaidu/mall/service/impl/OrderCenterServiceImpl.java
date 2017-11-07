package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.eumns.OrderQueryCycle;
import com.xiaobaidu.mall.eumns.ResponseCode;
import com.xiaobaidu.mall.service.OrderCentreService;
import com.xiaobaidu.mall.util.DateUtils;
import com.xiaobaidu.mall.vo.OrderReq;
import com.xiaobaidu.mall.vo.OrderVo;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import transactional.OrderCenterTransaction;

import java.util.Date;
import java.util.List;

/**
 * @author hefaji
 * @create 2017-10-13 18:04
 **/
public class OrderCenterServiceImpl implements OrderCentreService {

    @Autowired
    private OrderCenterTransaction orderCenterTransaction;

    @Override
    public ResponseVo joinOrder(OrderReq orderReq) {
        ResponseVo vo = ResponseVo.SUCCESS();

        boolean result = orderCenterTransaction.joinOrder(orderReq);
        if(!result){
            vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }

        return vo;
    }
    @Override
    public ResponseVo<List<OrderVo>> queryOrderList(String userId, String queryCycle) {
        Date minDate = getMinDate(queryCycle);


        return null;
    }

    /**
     * 通过时间周期，获取周期内时间最小范围
     * @return
     */
    private Date getMinDate(String queryCycle){

        Date now  = new Date();
        now.setHours(0);
        now.setMinutes(0);
        now.setSeconds(0);
        Date mixTime = null;

        switch (queryCycle){
            case "A_WEEK" :
                mixTime =  DateUtils.addWeeks(now , -1);
                break;

            case "A_MONTH" :
                mixTime = DateUtils.addMonths(now ,-1);
                break;

            case "THREE_MONTHS" :
                mixTime = DateUtils.addMonths(now ,-3);
                break;

            case "HALF_YEAR" :
                mixTime = DateUtils.addMonths(now ,-6);
                break;
            default:
                mixTime =  DateUtils.addWeeks(now , -1);
                break;

        }
        return mixTime;
    }
}
