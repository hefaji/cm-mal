package com.xiaobaidu.mall.exception;


public class BusinessException extends RuntimeException {

	private int code;

	private String msg;

	public BusinessException(int code, String msg) {
		super(String.format("[%s]%s",code,msg));
		this.code = code;
		this.msg = msg;
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		this.code = BaseCode.SYSTEM_ERROR;
	}

	public BusinessException(String message, int code, String msg) {
		super(message);
		this.code = code;
		this.msg = msg;
	}

	public BusinessException(String message, Throwable cause, int code, String msg) {
		super(message, cause);
		this.code = code;
		this.msg = msg;
	}

	public BusinessException(Throwable cause, int code, String msg) {
		super(cause);
		this.code = code;
		this.msg = msg;
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String msg) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
		this.msg = msg;
	}

	public BusinessException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public BusinessException(String message, Throwable cause, String msg) {
		super(message, cause);
		this.code = BaseCode.SYSTEM_ERROR;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
