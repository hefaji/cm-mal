package com.xiaobaidu.mall.vo;

import com.xiaobaidu.mall.exception.BaseCode;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author hefaji
 * @create 2017-10-12 11:25
 **/
public class ResponseVo<T> {
    /**
     * 状态码
     */
    private int code;
    /**
     * 状态提示信息
     */
    private String msg;

    private boolean isSuccess;

    private T data;


    public ResponseVo() {
    }

    public ResponseVo(int code) {
        super();
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean checkSuccess() {
        return isSuccess;
    }

    public String getMsg() {
//		return StringUtils.isNotEmpty(msg) ? msg : ResponseHelper.i18n(code);
        return StringUtils.isNotEmpty(msg) ? msg : "";
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 封装请求成功回应
     *
     * @return
     */
    public static ResponseVo SUCCESS() {
        ResponseVo result = new ResponseVo();
        result.isSuccess = Boolean.TRUE;
        return result;
    }

    public static ResponseVo SUCCESS(int code) {
        ResponseVo result = new ResponseVo();
        result.isSuccess = Boolean.TRUE;
        result.setCode(code);
        return result;
    }

    public static ResponseVo SUCCESS(int code, String msg) {
        ResponseVo result = new ResponseVo();
        result.isSuccess = Boolean.TRUE;
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 封装请求成功回应
     *
     * @return
     */
    public static ResponseVo SUCCESS(Serializable o) {
        ResponseVo result = new ResponseVo();
        result.isSuccess = Boolean.TRUE;
        result.setCode(BaseCode.SUCCESS);
        result.setData(o);
        return result;
    }

    /**
     * 封装错误回应code
     *
     * @param code
     * @return
     */
    public static ResponseVo ERROR(int code) {
        ResponseVo result = new ResponseVo();
        result.code = code;
        result.isSuccess = Boolean.FALSE;
        return result;
    }
    /**
     * 封装错误回应code
     *
     * @param code
     * @return
     */
    @SuppressWarnings("unchecked")
    public static ResponseVo ERROR(int code,String msg) {
        ResponseVo result = new ResponseVo();
        result.code = code;
        result.msg = msg;
        result.isSuccess = Boolean.FALSE;
        return result;
    }

    /**
     * 封装错误回应SYSTEM_ERROR
     *
     * @return
     */
    public static ResponseVo ERROR() {
        ResponseVo result = new ResponseVo();
        result.code = BaseCode.SYSTEM_ERROR;
        result.isSuccess = Boolean.FALSE;
        return result;
    }
    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean success) {
        isSuccess = success;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", isSuccess=" + isSuccess +
                ", data=" + data +
                '}';
    }

}
