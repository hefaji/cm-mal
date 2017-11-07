package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.dao.BannerMapper;
import com.xiaobaidu.mall.entity.Banner;
import com.xiaobaidu.mall.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hefaji
 * @create 2017-09-14 11:53
 **/
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> findAll() {
        return bannerMapper.selectAll();
    }
}
