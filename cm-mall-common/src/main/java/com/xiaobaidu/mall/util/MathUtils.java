package com.xiaobaidu.mall.util;

import java.math.BigDecimal;

/**
 * @author hefaji
 * @create 2017-09-21 12:02
 **/
public class MathUtils {
    public MathUtils() {
    }

    public static double round(double value, int scale) {
        BigDecimal b = new BigDecimal(Double.toString(value));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, 4).doubleValue();
    }

    public static double roundDown(double v, int scale) {
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, 1).doubleValue();
    }

    public static double roundUp(double value, int scale) {
        BigDecimal b = new BigDecimal(Double.toString(value));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, 0).doubleValue();
    }

    public static double divideAndRoundUp(double value1, double value2, int scale) {
        BigDecimal bd1 = new BigDecimal(value1);
        BigDecimal bd2 = new BigDecimal(value2);
        return bd1.divide(bd2, scale, 0).doubleValue();
    }

    public static double divideAndRoundDown(double value1, double value2, int scale) {
        BigDecimal bd1 = new BigDecimal(value1);
        BigDecimal bd2 = new BigDecimal(value2);
        return bd1.divide(bd2, scale, 1).doubleValue();
    }

    public static double add(double value1, double value2) {
        BigDecimal bd1 = new BigDecimal(value1);
        BigDecimal bd2 = new BigDecimal(value2);
        return bd1.add(bd2).doubleValue();
    }

    public static int sum(int... ns) {
        if(ns == null) {
            return 0;
        } else {
            int total = 0;
            int[] var2 = ns;
            int var3 = ns.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                int n = var2[var4];
                total += n;
            }

            return total;
        }
    }
}
