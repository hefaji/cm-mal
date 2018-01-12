package com.xiaobaidu.mall.web;

import com.xiaobaidu.mall.entity.ShoppingCart;
import com.xiaobaidu.mall.service.ShoppingCartService;
import com.xiaobaidu.mall.vo.CartVo;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 购物车
 * @author hefaji
 * @create 2017-11-14 12:16
 **/
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController extends  BaseController{
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 我的购物车
     * @return
     */
    @RequestMapping(value = "/my")
    public String myShoppingCart(String userId){
        ResponseVo<CartVo> responseVo = shoppingCartService.selectByUserId(userId);
        return buildResponse(responseVo);
    }

    /**
     * 加入购物车
     * @return
     */
    @RequestMapping(value = "/add")
    public String addShoppingCart(ShoppingCart shoppingCart){
        ResponseVo<List<ShoppingCart>> responseVo = shoppingCartService.save(shoppingCart);
        return buildResponse(responseVo);
    }

    /**
     * 删除购物车
     * @return
     */
    @RequestMapping(value = "/delete")
    public String deleteShoppingCart(String id){
        ResponseVo<List<ShoppingCart>> responseVo = shoppingCartService.delete(id);
        return buildResponse(responseVo);
    }

    /**
     * 重新编辑购物车
     * @return
     */
    @RequestMapping(value = "/update")
    public String updateShoppingCart(ShoppingCart shoppingCart){
        ResponseVo<List<ShoppingCart>> responseVo = shoppingCartService.update(shoppingCart);
        return buildResponse(responseVo);
    }


}
