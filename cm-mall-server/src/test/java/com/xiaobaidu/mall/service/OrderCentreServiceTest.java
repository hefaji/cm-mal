package com.xiaobaidu.mall.service;

import com.xiaobaidu.mall.util.JsonUtils;
import com.xiaobaidu.mall.vo.OrderDetailReq;
import com.xiaobaidu.mall.vo.OrderReq;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hefaji
 * @create 2017-11-13 12:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderCentreServiceTest {

    @Autowired
    private OrderCentreService orderCentreService;

    @Test
    public void testJoinOrder(){
        OrderReq orderReq = new OrderReq();
        orderReq.setAddressId("1234");
        orderReq.setUserId("wx");
        orderReq.setUserNickName("微信");

        OrderDetailReq detailReq = new OrderDetailReq();
        detailReq.setCommCode("xfs-vs");
        detailReq.setCommCount(3);

        OrderDetailReq detailReq2 = new OrderDetailReq();
        detailReq2.setCommCode("kf-yl");
        detailReq2.setCommCount(700);

        OrderDetailReq detailReq3 = new OrderDetailReq();
        detailReq3.setCommCode("kqs-nfsq");
        detailReq3.setCommCount(20);

        OrderDetailReq detailReq4 = new OrderDetailReq();
        detailReq4.setCommCode("yg-ylj");
        detailReq4.setCommCount(1);

        List<OrderDetailReq> orderDetailReqs = new ArrayList<>();
        orderDetailReqs.add(detailReq);
        orderDetailReqs.add(detailReq2);
        orderDetailReqs.add(detailReq3);
        orderDetailReqs.add(detailReq4);

        orderReq.setOrderDetailList(orderDetailReqs);

        ResponseVo responseVo = orderCentreService.joinOrder(orderReq);

        System.out.println(JsonUtils.object2String(responseVo));
    }

}
