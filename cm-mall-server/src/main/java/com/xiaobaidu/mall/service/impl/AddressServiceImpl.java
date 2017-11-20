package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.dao.AddressMapper;
import com.xiaobaidu.mall.entity.Address;
import com.xiaobaidu.mall.eumns.ResponseCode;
import com.xiaobaidu.mall.exception.BaseCode;
import com.xiaobaidu.mall.service.AddressService;
import com.xiaobaidu.mall.util.StringUtils;
import com.xiaobaidu.mall.util.UUIDUtils;
import com.xiaobaidu.mall.util.ValidatorUtil;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author hefaji
 * @create 2017-09-21 17:29
 **/
@Service
public class AddressServiceImpl implements AddressService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public ResponseVo save(Address address) {
        ResponseVo vo = ValidatorUtil.validator(address);
        if(!vo.getIsSuccess()){
            return  vo;
        }
        address.setId(UUIDUtils.Gen_UUID());
        address.setCreateTime(new Date());
        try {
            addressMapper.insert(address);
        }catch (Exception e){
           vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

    @Override
    public ResponseVo update(Address address) {
        ResponseVo vo = ValidatorUtil.validator(address);
        if(!vo.getIsSuccess()){
            return  vo;
        }
        if(StringUtils.isEmpty(address.getId())){
            vo.setCode(BaseCode.PARAM_ILLEGAL);
            vo.setMsg("参数异常：id为空");
            return vo;
        }
        try {
            addressMapper.updateByPrimaryKey(address);
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;

    }

    @Override
    public ResponseVo deleteById(String id) {

        ResponseVo vo = ResponseVo.SUCCESS();
        if(StringUtils.isEmpty(id)){
            vo.setCode(BaseCode.PARAM_ILLEGAL);
            vo.setMsg("参数异常：id为空");
            return vo;
        }
        try {
            addressMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

    @Override
    @Transactional
    public ResponseVo setDefault(String id,String userId) {

        ResponseVo vo = ResponseVo.SUCCESS();
        if(StringUtils.isEmpty(id) && StringUtils.isEmpty(userId)){
            vo.setCode(BaseCode.PARAM_ILLEGAL);
            vo.setMsg("参数异常：用户id为空或用户id为空");
            return vo;
        }
        try {
            //清除原有的所有为非默认
            addressMapper.removeDefaultAddress(userId);
            //设置当前用户
            addressMapper.setDefaultAddress(id);
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

    @Override
    public ResponseVo queryByUserId(String userId) {

        ResponseVo vo = ResponseVo.SUCCESS();
        if(StringUtils.isEmpty(userId)){
            vo.setCode(BaseCode.PARAM_ILLEGAL);
            vo.setMsg("参数异常：用户id为空");
            return vo;
        }
        try {
            List<Address> addresses = addressMapper.queryByUserId(userId);
            vo.setData(addresses);
        }catch (Exception e){
            vo.setCode(BaseCode.DB_ERROR);
            vo.setMsg("系统异常");
            logger.error("系统异常e:"+e);
        }
        return vo;
    }

}
