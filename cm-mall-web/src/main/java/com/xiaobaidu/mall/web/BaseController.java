package com.xiaobaidu.mall.web;

import com.xiaobaidu.mall.util.JsonUtils;

/**
 * @author hefaji
 * @create 2017-11-14 14:31
 **/
public class BaseController {
    public String buildResponse(Object object){
        return JsonUtils.object2String(object);
    }
}
