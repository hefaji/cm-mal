package com.xiaobaidu.mall.service;

import com.xiaobaidu.mall.entity.Banner;
import com.xiaobaidu.mall.vo.ResponseVo;

import java.util.List;
import java.util.PrimitiveIterator;

/**
 * @author hefaji
 * @create 2017-09-14 11:52
 **/
public interface BannerService {

    ResponseVo<List<Banner>> findAll();

    /**
     * 获取前五条广告图片
     * @return
     */
    ResponseVo<List<Banner>> findBanners();
}
