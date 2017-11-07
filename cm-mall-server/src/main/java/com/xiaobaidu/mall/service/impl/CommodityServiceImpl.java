package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.dao.CommStockMapper;
import com.xiaobaidu.mall.dao.CommThemeEventMapper;
import com.xiaobaidu.mall.dao.CommTypeMapper;
import com.xiaobaidu.mall.dao.CommodityMapper;
import com.xiaobaidu.mall.entity.CommThemeEvent;
import com.xiaobaidu.mall.entity.CommThemeEventDetail;
import com.xiaobaidu.mall.entity.CommType;
import com.xiaobaidu.mall.entity.Commodity;
import com.xiaobaidu.mall.eumns.ResponseCode;
import com.xiaobaidu.mall.service.CommodityService;
import com.xiaobaidu.mall.util.CollectionUtils;
import com.xiaobaidu.mall.vo.CommTypeVo;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hefaji
 * @create 2017-09-21 10:26
 **/
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommTypeMapper commTypeMapper;

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private CommThemeEventMapper commThemeEventMapper;

    @Autowired
    private CommStockMapper commStockMapper;

    @Override
    public ResponseVo<List<CommType>> getHotCommType() {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            vo.setData(commTypeMapper.findHotType());
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }
        return vo;
    }

    @Override
    public ResponseVo<List<Commodity>> getByTypeId(String typeId) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            vo.setData(commodityMapper.getByTypeId(typeId));
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }
        return vo;
    }

    @Override
    public ResponseVo<List<CommType>> getAllType() {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            vo.setData( commTypeMapper.findAll());
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }
        return vo;
    }

    @Override
    public ResponseVo<List<Commodity>> getHotCommodity() {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            vo.setData( commodityMapper.getHotCommodity());
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }
        return vo;
    }

    @Override
    public ResponseVo<CommTypeVo> getCommTypeVoByCommType(String typeId) {

        ResponseVo respVo = ResponseVo.SUCCESS();
        try {
            CommTypeVo vo = new CommTypeVo();
            //分类下的热销
            List<Commodity> commodityHotList = commodityMapper.getHotSellByTypeId(typeId);
            vo.setHotCommodityList(commodityHotList);
            List<Commodity> commodityList = commodityMapper.getByTypeId(typeId);
            //分类下商品，非热销
            vo.setCommoditiyList(commodityList);

            List<CommThemeEvent> commThemeEvents = commThemeEventMapper.getListByCommTypeId(typeId);
            //填充主题关联商品信息
            buildCommThemeEvent(commThemeEvents);
            if(!CollectionUtils.isEmpty(commThemeEvents)){
                if(commThemeEvents.size()==1){
                    vo.setCommThemeEventFirst(commThemeEvents.get(0));
                }else {
                    vo.setCommThemeEventFirst(commThemeEvents.get(0));
                    vo.setCommThemeEventSecond(commThemeEvents.get(1));
                }
            }

            respVo.setData(vo);
        }catch (Exception e){
            respVo.setCode(ResponseCode.FAILURE);
            respVo.setMsg("系统异常");
        }
        return respVo;



    }

    //遍历主题，填充主题关联商品信息
    private void buildCommThemeEvent(List<CommThemeEvent> commThemeEvents) {
        if(!CollectionUtils.isEmpty(commThemeEvents)){
            for(CommThemeEvent event : commThemeEvents){
                if(!CollectionUtils.isEmpty(event.getDetailList())){
                    for(CommThemeEventDetail eventDetail :event.getDetailList()){
                        Commodity commodity = commodityMapper.getCommodityByCode(eventDetail.getRelateCommodity().getCode());
                        eventDetail.setRelateCommodity(commodity);
                    }
                }

            }
        }
    }

}
