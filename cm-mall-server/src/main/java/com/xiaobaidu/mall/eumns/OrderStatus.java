package com.xiaobaidu.mall.eumns;

/**
 * Created by hefaji on 2017/9/21.
 */
public interface OrderStatus {

    //待支付
     int TO_PAY = 0;
     //已支付
     int PAYED = 1;
     //待收货
     int TO_RECEIVE = 2;
     //已完成
     int COMPLETE=3;

}
