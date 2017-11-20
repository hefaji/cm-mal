package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.dao.OrderCentreMapper;
import com.xiaobaidu.mall.dao.OrderDetailMapper;
import com.xiaobaidu.mall.entity.OrderCentre;
import com.xiaobaidu.mall.eumns.ResponseCode;
import com.xiaobaidu.mall.exception.BaseCode;
import com.xiaobaidu.mall.exception.BusinessException;
import com.xiaobaidu.mall.service.OrderCentreService;
import com.xiaobaidu.mall.util.CollectionUtils;
import com.xiaobaidu.mall.util.DateUtils;
import com.xiaobaidu.mall.util.StringUtils;
import com.xiaobaidu.mall.util.ValidatorUtil;
import com.xiaobaidu.mall.vo.OrderReq;
import com.xiaobaidu.mall.vo.OrderVo;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hefaji
 * @create 2017-10-13 18:04
 **/
@Service
public class OrderCenterServiceImpl implements OrderCentreService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderCenterTransaction orderCenterTransaction;
    @Autowired
    private OrderCentreMapper orderCentreMapper;


    @Override
    public ResponseVo joinOrder(OrderReq orderReq) {
        ResponseVo vo = ValidatorUtil.validator(orderReq);
        if(!vo.getIsSuccess()){
            return vo;
        }
        if(CollectionUtils.isEmpty(orderReq.getOrderDetailList())){
            vo.setCode(BaseCode.PARAM_ILLEGAL);
            vo.setMsg("商品为空");

        }
        try {

            boolean result = orderCenterTransaction.joinOrder(orderReq);
            if(!result){
                vo.setCode(BaseCode.DB_ERROR);
                vo.setMsg("系统异常");
            }
        }catch (BusinessException e){
           vo.setCode(e.getCode());
           vo.setMsg(e.getMsg());
            logger.error("系统异常e:"+e);

        }
        return vo;
    }
    @Override
    public ResponseVo<List<OrderVo>> queryOrderList(String userId, String queryCycle) {
        ResponseVo vo = ResponseVo.SUCCESS();
        if(StringUtils.isEmpty(userId)){
            vo.setCode(BaseCode.PARAM_ILLEGAL);
            vo.setMsg("参数异常：用户id为空");
            return vo;
        }
        if(StringUtils.isEmpty(queryCycle)){
            queryCycle= "A_WEEK";
        }
        Date minDate = getMinDate(queryCycle);
        List<OrderVo> orderVos = orderCentreMapper.queryByMixDate(userId, minDate);
        vo.setData(orderVos);
        return vo;
    }

    @Override
    public ResponseVo<OrderVo> queryOrderById(String id ) {
        ResponseVo vo = ResponseVo.SUCCESS();
        if(StringUtils.isEmpty(id)){
            vo.setCode(BaseCode.PARAM_ILLEGAL);
            vo.setMsg("参数异常：id为空");
            return vo;
        }
        OrderVo orderVo = orderCentreMapper.queryById(id);
        vo.setData(orderVo);
        return vo;
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
