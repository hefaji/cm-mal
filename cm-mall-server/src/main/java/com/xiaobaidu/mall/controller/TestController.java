package com.xiaobaidu.mall.controller;

import com.xiaobaidu.mall.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hefaji
 * @create 2017-09-14 9:49
 **/
@RestController
public class TestController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping(value="/test")
    public String index(){
//        List<Banner> list =  bannerService.findAll();
//        ResponseVo vo = new ResponseVo(ResponseVo.SUCCESS,list);
//        return JsonUtils.object2String(vo)+"-----server1";
        return null;
    }
}
