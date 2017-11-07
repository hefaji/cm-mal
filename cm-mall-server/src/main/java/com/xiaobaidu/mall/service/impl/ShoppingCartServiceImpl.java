package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.dao.ShoppingCartMapper;
import com.xiaobaidu.mall.entity.ShoppingCart;
import com.xiaobaidu.mall.eumns.ResponseCode;
import com.xiaobaidu.mall.service.ShoppingCartService;
import com.xiaobaidu.mall.util.UUIDUtils;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author hefaji
 * @create 2017-09-21 12:13
 **/
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public ResponseVo save(ShoppingCart entity) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            entity.setId(UUIDUtils.Gen_UUID());
            entity.setCreateTime(new Date());
            shoppingCartMapper.insert(entity);
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
        }
        return vo;


    }

    @Override
    public ResponseVo delete(String id) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            shoppingCartMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
        }
        return vo;

    }

    @Override
    public ResponseVo update(ShoppingCart entity) {

        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            entity.setUpdateTime(new Date());
            shoppingCartMapper.updateByPrimaryKey(entity);
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);

        }
        return vo;


    }

    @Override
    public ResponseVo<List<ShoppingCart>> selectByUserId(String userId) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            vo.setData(shoppingCartMapper.selectByUserId(userId));
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
        }
        return vo;
    }
}
