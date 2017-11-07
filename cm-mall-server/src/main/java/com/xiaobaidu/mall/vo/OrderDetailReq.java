package com.xiaobaidu.mall.vo;

import java.io.Serializable;

/**
 * @author hefaji
 * @create 2017-10-12 11:10
 **/
public class OrderDetailReq implements Serializable {
    private String commCode;
    private int commCount;

    public String getCommCode() {
        return commCode;
    }

    public void setCommCode(String commCode) {
        this.commCode = commCode;
    }

    public int getCommCount() {
        return commCount;
    }

    public void setCommCount(int commCount) {
        this.commCount = commCount;
    }
}
