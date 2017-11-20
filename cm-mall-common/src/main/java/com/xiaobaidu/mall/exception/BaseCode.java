package com.xiaobaidu.mall.exception;

/**
 * @author hefaji
 * @create 2017-11-14 11:35
 **/
public interface BaseCode {

    int SUCCESS = 0;

    int PARAM_ILLEGAL = 1;
    int DB_ERROR = 2;
    int NEED_LOGIN = 5;
    int INSUFFICIENT_PRIVILEGES = 6;
    int SESSION_EXPIRED = 7;
    int INVALID_REQUEST = 111;
    int INVALID_ARGS = 8;
    int USER_CALL_TIMEOUT = 100;
    int USER_CALL_LIMITED = 101;
    int SESSION_CALL_LIMITED = 102;
    int IO_EXCEPTION = 103;
    int SYSTEM_DATA_ERROR = 104;

    int SYSTEM_ERROR = 999;




}
