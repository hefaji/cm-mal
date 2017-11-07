package com.xiaobaidu.mall.vo;

import com.xiaobaidu.mall.eumns.ResponseCode;

import java.io.Serializable;

/**
 * @author hefaji
 * @create 2017-10-12 11:25
 **/
public class ResponseVo<T> {
    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseVo SUCCESS(){
        ResponseVo vo = new ResponseVo();
        vo.setCode(ResponseCode.SUCCESS);
        return vo;
    }
}
