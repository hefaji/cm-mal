package com.xiaobaidu.mall.web;

import com.xiaobaidu.mall.entity.CommType;
import com.xiaobaidu.mall.entity.Commodity;
import com.xiaobaidu.mall.service.CommodityService;
import com.xiaobaidu.mall.vo.CommTypeVo;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品服务
 * @author hefaji
 * @create 2017-11-14 12:16
 **/
@RestController
@RequestMapping("/commodity")
public class CommodityController extends  BaseController{
    @Autowired
    private CommodityService commodityService;

    /**
     * 获取热门分类
     * @return
     */
    @RequestMapping(value = "/queryHotCommType")
    public String getHotCommType(){
        ResponseVo<List<CommType>> hotCommTypes = commodityService.getHotCommType();

        return buildResponse(hotCommTypes);
    }

    /**
     * 获取热门分类
     * @return
     */
    @RequestMapping(value = "/getCommoditysByTypeId")
    public String getCommoditysByTypeId(String typeId){
        ResponseVo<List<Commodity>> responseVo = commodityService.getByTypeId(typeId);
        return buildResponse(responseVo);
    }

    /**
     * 获取热门分类
     * @return
     */
    @RequestMapping(value = "/getAllTypes")
    public String getAllTypes(String typeId){
        ResponseVo<List<CommType>> responseVo = commodityService.getAllType();
        return buildResponse(responseVo);
    }

    /**
     * 获取热门商品
     */
    @RequestMapping(value = "/getHotCommoditys")
    public String getHotCommoditys(){
        ResponseVo<List<Commodity>> responseVo = commodityService.getHotCommodity();
        return buildResponse(responseVo);
    }


    @RequestMapping(value = "/getCommTypeVoByCommType")
    public String getCommTypeVoByCommType(String typeId){
        ResponseVo<CommTypeVo> responseVo = commodityService.getCommTypeVoByCommType(typeId);
        return buildResponse(responseVo);
    }
}
