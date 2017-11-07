package com.xiaobaidu.mall.eumns;

/**
 * Created by hefaji on 2017/10/13.
 */
public enum  OrderQueryCycle {

    A_WEEK("A_WEEK","一周内"),
    A_MONTH("A_MONTH","一个月内"),
    THREE_MONTHS("THREE_MONTHS","三个月内"),
    HALF_YEAR("HALF_YEAR","半年内");

    private String code;

    private String text;

    OrderQueryCycle(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
