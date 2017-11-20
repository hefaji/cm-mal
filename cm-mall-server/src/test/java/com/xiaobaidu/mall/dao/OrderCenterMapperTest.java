package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.CommThemeEvent;
import com.xiaobaidu.mall.entity.CommType;
import com.xiaobaidu.mall.entity.Commodity;
import com.xiaobaidu.mall.entity.OrderCentre;
import com.xiaobaidu.mall.service.CommodityService;
import com.xiaobaidu.mall.util.DateUtils;
import com.xiaobaidu.mall.util.JsonUtils;
import com.xiaobaidu.mall.vo.CommTypeVo;
import com.xiaobaidu.mall.vo.OrderVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author hefaji
 * @create 2017-09-15 15:06
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderCenterMapperTest {
    @Autowired
    private OrderCentreMapper orderCentreMapper;


    @Test
    public void testFindById(){
        Date now  = new Date();
        now.setHours(0);
        now.setMinutes(0);
        now.setSeconds(0);
        Date mixTime =  DateUtils.addWeeks(now , -1);

        List<OrderVo> orders = orderCentreMapper.queryByMixDate("wx", mixTime);
        System.out.println("result -----------"+JsonUtils.object2String(orders));
    }

}
