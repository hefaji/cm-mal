package transactional;

import com.xiaobaidu.mall.dao.*;
import com.xiaobaidu.mall.entity.*;
import com.xiaobaidu.mall.util.CollectionUtils;
import com.xiaobaidu.mall.util.UUIDUtils;
import com.xiaobaidu.mall.vo.OrderDetailReq;
import com.xiaobaidu.mall.vo.OrderReq;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author hefaji
 * @create 2017-10-13 18:07
 **/
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

    public boolean joinOrder(OrderReq orderReq) {

        if (null != orderReq && !CollectionUtils.isEmpty(orderReq.getOrderDetailList())) {
            for (OrderDetailReq detail : orderReq.getOrderDetailList()) {
                //根据商品id获取库存
                CommStock commStock = commStockMapper.selectByCommCode(detail.getCommCode());
                if (null == commStock || commStock.getCount() < detail.getCommCount()) {
                    return false;
                }

                commStock.setCount(commStock.getCount() - detail.getCommCount());
                commStock.setVersion(commStock.getVersion() + 1);
                //插入商品库存
                int updateCount = commStockMapper.uploadByVersion(commStock);
                if (updateCount <= 0) {
                    return false;
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
                    return  false;
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
