package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.dao.BannerMapper;
import com.xiaobaidu.mall.entity.Banner;
import com.xiaobaidu.mall.eumns.ResponseCode;
import com.xiaobaidu.mall.service.BannerService;
import com.xiaobaidu.mall.vo.ResponseVo;
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
    public ResponseVo<List<Banner>> findAll() {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            vo.setData(bannerMapper.selectAll());
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }
        return vo;
    }

    @Override
    public ResponseVo<List<Banner>> findBanners() {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            vo.setData(bannerMapper.findBanners());
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }
        return vo;
    }
}
