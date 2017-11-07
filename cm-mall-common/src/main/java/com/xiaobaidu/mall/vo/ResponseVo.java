package com.xiaobaidu.mall.vo;

/**
 * @author hefaji
 * @create 2017-09-14 17:28
 **/
public class ResponseVo<T> {

    //----------------------异常返回码 start------------------------
    public static final String SUCCESS = "0";
    //参数非法
    public static final String PARAMS_ILLEGAL = "001";
    //数据库异常
    public static final String DB_EXCEPTION = "002";

    //其他异常
    public static final String OTHER="111";

    //-----------------------------------------------------------

    private String code;

    private T data;

    public ResponseVo(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
