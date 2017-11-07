package com.xiaobaidu.mall.service;

import com.xiaobaidu.mall.entity.Address;
import com.xiaobaidu.mall.vo.ResponseVo;

/**
 * @author hefaji
 * @create 2017-09-21 17:25
 **/
public interface AddressService {
    ResponseVo save(Address address);

    ResponseVo update(Address address);

    ResponseVo deleteById(String id);

    /**
     * 设置默认
     * @param id
     * @param userId
     */
    ResponseVo setDefault(String id, String userId);


}
