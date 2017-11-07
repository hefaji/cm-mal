package com.xiaobaidu.mall.service.impl;

import com.xiaobaidu.mall.dao.AddressMapper;
import com.xiaobaidu.mall.entity.Address;
import com.xiaobaidu.mall.eumns.ResponseCode;
import com.xiaobaidu.mall.service.AddressService;
import com.xiaobaidu.mall.util.UUIDUtils;
import com.xiaobaidu.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author hefaji
 * @create 2017-09-21 17:29
 **/
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public ResponseVo save(Address address) {
        ResponseVo vo = ResponseVo.SUCCESS();

        address.setId(UUIDUtils.Gen_UUID());
        address.setCreateTime(new Date());
        try {
            addressMapper.insert(address);
        }catch (Exception e){
           vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }
        return vo;
    }

    @Override
    public ResponseVo update(Address address) {
        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            addressMapper.updateByPrimaryKey(address);
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }
        return vo;

    }

    @Override
    public ResponseVo deleteById(String id) {

        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            addressMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }
        return vo;
    }

    @Override
    @Transactional
    public ResponseVo setDefault(String id,String userId) {

        ResponseVo vo = ResponseVo.SUCCESS();
        try {
            //清除原有的所有为非默认
            addressMapper.removeDefaultAddress(userId);
            //设置当前用户
            addressMapper.setDefaultAddress(id);
        }catch (Exception e){
            vo.setCode(ResponseCode.DB_ERROR);
            vo.setMsg("系统异常");
        }
        return vo;
    }
}
