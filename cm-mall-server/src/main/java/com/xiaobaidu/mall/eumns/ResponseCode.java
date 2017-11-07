package com.xiaobaidu.mall.eumns;

/**
 * Created by hefaji on 2017/10/12.
 */
public interface ResponseCode {

    //成功
    String SUCCESS="0";

    //参数非法
    String PARAM_ILLEGAL="001";

    //数据库异常
    String DB_ERROR = "002";

    //其他错误
    String FAILURE="999";
}
