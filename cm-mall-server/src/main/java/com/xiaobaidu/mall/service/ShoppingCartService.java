package com.xiaobaidu.mall.service;

import com.xiaobaidu.mall.entity.ShoppingCart;
import com.xiaobaidu.mall.vo.ResponseVo;

import java.util.List;

/**
 * 购物车服务
 * Created by hefaji on 2017/9/21.
 */
public interface ShoppingCartService {

    ResponseVo save(ShoppingCart entity);

    ResponseVo delete(String id);

    ResponseVo update(ShoppingCart entity);

    ResponseVo<List<ShoppingCart>> selectByUserId(String userId);

}
