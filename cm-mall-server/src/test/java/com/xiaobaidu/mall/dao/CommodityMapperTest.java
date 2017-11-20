package com.xiaobaidu.mall.dao;

import com.xiaobaidu.mall.entity.CommThemeEvent;
import com.xiaobaidu.mall.entity.CommType;
import com.xiaobaidu.mall.entity.Commodity;
import com.xiaobaidu.mall.service.CommodityService;
import com.xiaobaidu.mall.util.JsonUtils;
import com.xiaobaidu.mall.vo.CommTypeVo;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author hefaji
 * @create 2017-09-15 15:06
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityMapperTest {
    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private CommTypeMapper commTypeMapper;

    @Autowired
    private CommThemeEventMapper commThemeEventMapper;

    @Autowired
    private CommodityService commodityService;

    @Test
    public void testFindById(){

        Commodity commodity = commodityMapper.selectByPrimaryKey("1");
        System.out.println("result -----------"+JsonUtils.object2String(commodity));

    }

    @Test
    public void testFindhotCommType(){

        List<CommType> hotType = commTypeMapper.findHotType();
        System.out.println("result----------"+JsonUtils.object2String(hotType));
    }

    @Test
    public void testFindAllType(){
        List<CommType> hotType = commTypeMapper.findAll();
        System.out.println("result----------"+JsonUtils.object2String(hotType));
    }

    @Test
    public void testGetListByCommTypeId(){
        List<CommThemeEvent> list = commThemeEventMapper.getListByCommTypeId("21");
        System.out.println("result----------"+JsonUtils.object2String(list));
    }

    @Test
    public void  testCommTypeVoByCommType(){
        ResponseVo<CommTypeVo> commTypeVo = commodityService.getCommTypeVoByCommType("2");
        System.out.println("result----------"+JsonUtils.object2String(commTypeVo));
    }

    @Test
    public void testSearchByKeyword(){
        List<Commodity> commodities = commodityMapper.searchByKeyword("中华");
        System.out.println("result----------"+JsonUtils.object2String(commodities));

    }
}
