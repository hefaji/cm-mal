package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.dao.CommodityMapper;
import com.xiaobaidu.mall.dao.ShoppingCartMapper;
import com.xiaobaidu.mall.entity.Commodity;
import com.xiaobaidu.mall.entity.ShoppingCart;
import com.xiaobaidu.mall.exception.BaseCode;
import com.xiaobaidu.mall.service.ShoppingCartService;
import com.xiaobaidu.mall.util.CollectionUtils;
import com.xiaobaidu.mall.util.UUIDUtils;
import com.xiaobaidu.mall.vo.CartGoodsVo;
import com.xiaobaidu.mall.vo.CartVo;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hefaji
 * @create 2017-09-21 12:13
 **/
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private CommodityMapper commodityMapper;


    @Override
    public ResponseVo save(ShoppingCart entity) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            if(StringUtils.isEmpty(entity.getCommCode())){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：商品编码为空");
                return vo;
            }

            if(StringUtils.isEmpty(entity.getUserId())){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：用户id为空");
                return vo;
            }

            if(entity.getCommCount()<=0){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：商品数量必须大于0");
                return vo;
            }

            //防止篡改，直接获取数据库价格
            Commodity commodity = commodityMapper.getCommodityByCode(entity.getCommCode());
            if(null == commodity){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：获取不到该商品信息");
                return vo;
            }
            entity.setCommSellPrice(commodity.getSellPrice());
            entity.setId(UUIDUtils.Gen_UUID());
            entity.setCreateTime(new Date());
            shoppingCartMapper.insert(entity);
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            logger.error("系统异常e:"+e);
        }
        return vo;


    }

    @Override
    public ResponseVo delete(String id) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            if(StringUtils.isEmpty(id)){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：id为空");
                return vo;
            }

            shoppingCartMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            logger.error("系统异常e:"+e);
        }
        return vo;

    }

    @Override
    public ResponseVo update(ShoppingCart entity) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            if(StringUtils.isEmpty(entity.getId())){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：id为空");
                return vo;
            }
            if(StringUtils.isEmpty(entity.getCommCode())){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：商品编码为空");
                return vo;
            }

            if(StringUtils.isEmpty(entity.getUserId())){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：用户id为空");
                return vo;
            }

            if(entity.getCommCount()<=0){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：商品数量必须大于0");
                return vo;
            }

            //防止篡改，直接获取数据库价格
            Commodity commodity = commodityMapper.getCommodityByCode(entity.getCommCode());
            if(null == commodity){
                vo.setCode(BaseCode.PARAM_ILLEGAL);
                vo.setMsg("参数异常：获取不到该商品信息");
                return vo;
            }
            entity.setCommSellPrice(commodity.getSellPrice());
            entity.setUpdateTime(new Date());
            shoppingCartMapper.insert(entity);
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
        }
        return vo;


    }

    @Override
    public ResponseVo<CartVo> selectByUserId(String userId) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            CartVo cartVo = new CartVo();
            List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectByUserId(userId);
            List<CartGoodsVo> cartGoodsVos = new ArrayList<>();
            if(!CollectionUtils.isEmpty(shoppingCarts)){
                    double totalPrice = 0.00;
                int totalSum = 0;
                for(ShoppingCart shoppingCart : shoppingCarts){
                    totalPrice += shoppingCart.getCommCount() * shoppingCart.getCommSellPrice().doubleValue();
                    totalSum +=shoppingCart.getCommCount();
                    CartGoodsVo goodsVo = new CartGoodsVo();
                    goodsVo.setCommCode(shoppingCart.getCommCode());
                    goodsVo.setCount(shoppingCart.getCommCount());
                    goodsVo.setSellPrice(shoppingCart.getCommSellPrice().doubleValue());
                    goodsVo.setTotalPrice(formatDouble(shoppingCart.getCommCount() * shoppingCart.getCommSellPrice().doubleValue()));
                    //根据commcode获取商品信息
                    Commodity commodity = commodityMapper.getCommodityByCode(shoppingCart.getCommCode());
                    if(null != commodity){
                        goodsVo.setCommName(commodity.getName());
                        goodsVo.setImage(commodity.getBigImage());
                    }
                    cartGoodsVos.add(goodsVo);
                }
                cartVo.setTotalSum(totalSum);
                cartVo.setTotalPrice(totalPrice);
                cartVo.setGoodsList(cartGoodsVos);
            }else {
                cartVo.setTotalPrice(0.00);
                cartVo.setTotalSum(0);
                cartVo.setGoodsList(cartGoodsVos);
            }
            vo.setData(cartVo);
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

    /**
     * 保留2位小数
     * @param value
     * @return
     */
    private double formatDouble(double value){
        BigDecimal bigDecimal   =   BigDecimal.valueOf(value);
        return bigDecimal.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
