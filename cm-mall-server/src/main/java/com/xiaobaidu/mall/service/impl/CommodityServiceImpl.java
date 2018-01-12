package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.dao.CommThemeEventMapper;
import com.xiaobaidu.mall.dao.CommTypeMapper;
import com.xiaobaidu.mall.dao.CommodityMapper;
import com.xiaobaidu.mall.entity.CommThemeEvent;
import com.xiaobaidu.mall.entity.CommThemeEventDetail;
import com.xiaobaidu.mall.entity.CommType;
import com.xiaobaidu.mall.entity.Commodity;
import com.xiaobaidu.mall.exception.BaseCode;
import com.xiaobaidu.mall.service.CommodityService;
import com.xiaobaidu.mall.util.CollectionUtils;
import com.xiaobaidu.mall.util.JsonUtils;
import com.xiaobaidu.mall.vo.CommTypeVo;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author hefaji
 * @create 2017-09-21 10:26
 **/
@Service
public class CommodityServiceImpl implements CommodityService {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CommTypeMapper commTypeMapper;

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private CommThemeEventMapper commThemeEventMapper;

    @Override
    public ResponseVo<List<CommType>> getHotCommType() {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            List<CommType> hotTypes = commTypeMapper.findHotType();
            vo.setData(hotTypes);
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

    @Override
    public ResponseVo<List<Commodity>> getByTypeId(String typeId) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            if(StringUtils.isEmpty(typeId)){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：商品类型为空");
            }
            vo.setData(commodityMapper.getByTypeId(typeId));
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

    @Override
    public ResponseVo<List<CommType>> getAllType() {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            vo.setData( commTypeMapper.findAll());
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

    @Override
    public ResponseVo<List<Commodity>> getHotCommodity() {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            vo.setData( commodityMapper.getHotCommodity());
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

    @Override
    public ResponseVo<CommTypeVo> getCommTypeVoByCommType(String typeId) {

        ResponseVo respVo = ResponseVo.SUCCESS();
        try {
            if(StringUtils.isEmpty(typeId)){
                respVo.setCode(BaseCode.PARAM_ILLEGAL);
                respVo.setMsg("参数异常：商品类型为空");
            }
            CommTypeVo vo = buildCommTypeVo(typeId);

            respVo.setData(vo);
        }catch (Exception e){
            respVo.setCode(BaseCode.SYSTEM_ERROR);
            respVo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return respVo;



    }

    @Override
    public ResponseVo<List<CommTypeVo>> getCommTypeVosByParentId(String typeId,String subTypeId) {
        ResponseVo respVo = ResponseVo.SUCCESS();
        boolean isExists = false;
        try {
            if(StringUtils.isEmpty(typeId)){
                respVo.setCode(BaseCode.PARAM_ILLEGAL);
                respVo.setMsg("参数异常：商品类型为空");
            }
          //获取分类下的子分类
            List<CommType> hotChildren = commTypeMapper.findHotChildrenTypeById(typeId);
            List<CommTypeVo> commTypeVos = new ArrayList<>();
            if(!CollectionUtils.isEmpty(hotChildren)){

                for(int i = 0 ;i < hotChildren.size(); i++) {
                    //判断是否含subTypeId
                    if (hotChildren.get(i).getId().equals(subTypeId)) {
                        isExists  =true;
                        break;
                    }
                }

                for(int i = 0 ;i < hotChildren.size(); i++){
                    CommTypeVo commTypeVo = new CommTypeVo();
                    //包含子分类id，则加载子分类商品信息，否则默认加载第一个
                    String id = hotChildren.get(i).getId();
                    if(isExists){
                        if(id.equals(subTypeId)){
                            commTypeVo =  buildCommTypeVo(hotChildren.get(i).getId());
                        }
                    }else{
                        if(i == 0){
                            commTypeVo =  buildCommTypeVo(hotChildren.get(i).getId());
                        }
                    }

                    commTypeVo.setTypeId(id);
                    commTypeVo.setTypeName(hotChildren.get(i).getName());
                    commTypeVo.setImage(hotChildren.get(i).getImage());
                    commTypeVos.add(commTypeVo);
                }
            }
            respVo.setData(commTypeVos);
        }catch (Exception e){
            respVo.setCode(BaseCode.SYSTEM_ERROR);
            respVo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return respVo;

    }

    @Override
    public ResponseVo<Commodity> getCommodityById(String id) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            if(StringUtils.isEmpty(id)){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：商品Id为空");
            }
            vo.setData(commodityMapper.getCommodityById(id));
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

    @Override
    public ResponseVo<Commodity> getCommodityByCode(String code) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            if(StringUtils.isEmpty(code)){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：商品编码为空");
            }
            vo.setData(commodityMapper.getCommodityByCode(code));
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

    private CommTypeVo buildCommTypeVo(String typeId){
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
        vo.setIsCurrt(true);
        return vo;
    }

    //遍历主题，填充主题关联商品信息
    private void buildCommThemeEvent(List<CommThemeEvent> commThemeEvents) {
        if(!CollectionUtils.isEmpty(commThemeEvents)){
            for(CommThemeEvent event : commThemeEvents){
                if(!CollectionUtils.isEmpty(event.getDetails())){
                    for(CommThemeEventDetail eventDetail :event.getDetails()){
                        Commodity commodity = commodityMapper.getCommodityByCode(eventDetail.getCommCode());
                        if(null != commodity){
                            eventDetail.setBigImage(commodity.getBigImage());
                            eventDetail.setCommIntroduce(commodity.getIntroduce());
                            eventDetail.setCommName(commodity.getName());
                            eventDetail.setPriceUnit(commodity.getPriceUnit());
                            eventDetail.setStock(commodity.getStock());
                        }

                    }
                }

            }
        }
    }




}
