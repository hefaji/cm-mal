package com.xiaobaidu.mall.web;

import com.xiaobaidu.mall.entity.Banner;
import com.xiaobaidu.mall.service.BannerService;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 广告页
 * @author hefaji
 * @create 2017-11-14 12:16
 **/
@RestController
@RequestMapping("/banner")
public class BannerController extends  BaseController{
    @Autowired
    private BannerService bannerService;

    /**
     * 广告页
     * @return
     */
    @RequestMapping(value = "/findBanners")
    public String findBanners(){
        ResponseVo<List<Banner>> responseVo = bannerService.findBanners();
        return buildResponse(responseVo);
    }


}
