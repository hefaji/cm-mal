package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.dao.*;
import com.xiaobaidu.mall.entity.*;
import com.xiaobaidu.mall.exception.BaseCode;
import com.xiaobaidu.mall.exception.BusinessException;
import com.xiaobaidu.mall.util.CollectionUtils;
import com.xiaobaidu.mall.util.UUIDUtils;
import com.xiaobaidu.mall.vo.OrderDetailReq;
import com.xiaobaidu.mall.vo.OrderReq;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author hefaji
 * @create 2017-10-13 18:07
 **/
@Component
public class OrderCenterTransaction {

    @Autowired
    private CommStockMapper commStockMapper;

    @Autowired
    private CommStockDetailMapper commStockDetailMapper;

    @Autowired
    private OrderCentreMapper orderCentreMapper;

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Transactional
    public boolean joinOrder(OrderReq orderReq) {

        if (null != orderReq && !CollectionUtils.isEmpty(orderReq.getOrderDetailList())) {
            for (OrderDetailReq detail : orderReq.getOrderDetailList()) {
                //根据商品id获取库存
                CommStock commStock = commStockMapper.selectByCommCode(detail.getCommCode());
                if (null == commStock || commStock.getCount() < detail.getCommCount()) {
                    throw new BusinessException(BaseCode.INVALID_REQUEST, commStock.getCommName()+"：库存不足,请您选择其他商品");

                }

                commStock.setCount(commStock.getCount() - detail.getCommCount());
                commStock.setVersion(commStock.getVersion() + 1);
                //插入商品库存
                int updateCount = commStockMapper.uploadByVersion(commStock);
                if (updateCount <= 0) {
                    throw new BusinessException(BaseCode.INVALID_REQUEST, commStock.getCommName()+"：库存不足,请选择其他商品");

                }

                //插入库存明细
                CommStockDetail stockDetail = new CommStockDetail();
                stockDetail.setCount(detail.getCommCount());
                stockDetail.setId(UUIDUtils.Gen_UUID());
                stockDetail.setOperation(-1);
                stockDetail.setStockId(commStock.getId());
                stockDetail.setCreateTime(new Date());
                commStockDetailMapper.insert(stockDetail);
            }

            //插入订单

            OrderCentre orderCentre = new OrderCentre();
            orderCentre.setAddressId(orderReq.getAddressId());
            orderCentre.setId(UUIDUtils.Gen_UUID());
            orderCentre.setOrderTime(new Date());
            orderCentre.setCreateTime(new Date());
            orderCentre.setStatus(1);
            orderCentre.setUserId(orderReq.getUserId());
            orderCentre.setUserNickName(orderReq.getUserNickName());
            orderCentre.setUpdateTime(new Date());
            orderCentreMapper.insert(orderCentre);
            //插入订单明细表
            for (OrderDetailReq detail : orderReq.getOrderDetailList()) {
                //根据商品编码，获取当前售价
                Commodity commodity = commodityMapper.getCommodityByCode(detail.getCommCode());
                if(null == commodity){
                    throw new BusinessException(BaseCode.SYSTEM_ERROR, "获取购买商品信息异常，请稍后再试");

                }
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setCommCode(detail.getCommCode());
                orderDetail.setCommCount(detail.getCommCount());
                orderDetail.setCommSellPrice(commodity.getSellPrice());
                orderDetail.setId(UUIDUtils.Gen_UUID());
                orderDetail.setOrderId(orderCentre.getId());
                orderDetail.setCreateTime(new Date());
                orderDetail.setUpdateTime(new Date());
                orderDetailMapper.insert(orderDetail);
            }

            return true;
        }else {
            return  false;
        }
    }
}
