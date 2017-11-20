package com.xiaobaidu.mall.web;

import com.xiaobaidu.mall.entity.Address;
import com.xiaobaidu.mall.entity.Banner;
import com.xiaobaidu.mall.service.AddressService;
import com.xiaobaidu.mall.service.BannerService;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 收件地址
 * @author hefaji
 * @create 2017-11-14 12:16
 **/
@RestController
@RequestMapping("/address")
public class AddressController extends  BaseController{

    @Autowired
    private AddressService addressService;

    /**
     * 我的收件地址
     * @param userId
     * @return
     */
    @RequestMapping(value = "/my")
    public String my(String userId){
        ResponseVo responseVo = addressService.queryByUserId(userId);
        return buildResponse(responseVo);
    }

    @RequestMapping(value = "/add")
    public String addAddress(Address address){
        ResponseVo responseVo = addressService.save(address);
        return buildResponse(responseVo);
    }

    @RequestMapping(value = "/edit")
    public String editAddress(Address address){
        ResponseVo responseVo = addressService.update(address);
        return buildResponse(responseVo);
    }


    @RequestMapping(value = "/delete")
    public String deleteAddress(String id){
        ResponseVo responseVo = addressService.deleteById(id);
        return buildResponse(responseVo);
    }

    @RequestMapping(value = "/setDefault")
    public String setDefault(String id,String userId){
        ResponseVo responseVo = addressService.setDefault(id,userId);
        return buildResponse(responseVo);
    }
}
