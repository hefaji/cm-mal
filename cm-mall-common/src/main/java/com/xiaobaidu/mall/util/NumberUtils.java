package com.xiaobaidu.mall.util;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by lijingzhou on 2016/11/30.
 */
public class NumberUtils {
	public static final DecimalFormat amount = new DecimalFormat("0.00");

	public static final DecimalFormat intFormat = new DecimalFormat("0");

	public static final DecimalFormat costAmount = new DecimalFormat("0.00");

	public static final DecimalFormat costRate = new DecimalFormat("0.0000");

	public static final DecimalFormat disFormat = new DecimalFormat("#.##");

	static{
		costAmount.setRoundingMode(RoundingMode.CEILING);
		costRate.setRoundingMode(RoundingMode.CEILING);
	}

	/**
	 * 长度
	 *
	 * @param s
	 * @return
	 */
	public static int length( String s ) {
		return s != null ? s.length( ) : 0;
	}
	/**
	 * 判断字符串是否是数字（包括小数、负数）
	 * @author jyf
	 * @param s
	 * @return
	 * @Date 2016年4月15日
	 */
	public static boolean isNumeral(String s){
		int sz = length( s );
		if ( sz == 0 ) {
			return false;
		}
		return s.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}

	/**
	 * 数据相加
	 * @author zhenghaibin
	 * @param v1
	 * @param v2
	 * @return
	 * @Date 2017年3月25日
	 */
	public static double add(double v1,double v2){
		return add(Double.toString(v1),Double.toString(v2));
	}

	public static double add(String...args){
		BigDecimal total = new BigDecimal(0);
		for(String arg : args){
			BigDecimal b = new BigDecimal(arg);
			total = total.add(b);
		}
		return total.doubleValue();
	}

	public static String addStr(String...args){
		return addStr(amount,args);
	}

	public static String addStr(DecimalFormat format,String...args){
		return format.format(add(args));
	}

	/**
	 * 数据相减（v1-v2）
	 * @author zhenghaibin
	 * @param v1
	 * @param v2
	 * @return
	 * @Date 2017年3月25日
	 */
	public static String sub(double v1,double v2){
		return subStr(Double.toString(v1),Double.toString(v2));
	}

	public static String subStr(String v1,String v2){
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return amount.format(b1.subtract(b2).doubleValue());
	}
	/**
	 * 数据相乘
	 * @author zhenghaibin
	 * @param v1
	 * @param v2
	 * @return
	 * @Date 2017年3月25日
	 */
	public static String mul(double v1,double v2){
		return mulStr(amount,Double.toString(v1),Double.toString(v2));
	}

	/**
	 * 数据相乘
	 * @author zhenghaibin
	 * @param v1
	 * @param v2
	 * @return
	 * @Date 2017年3月25日
	 */
	public static String mulCostItem(double v1,double v2){
		return mulStr(costAmount,Double.toString(v1),Double.toString(v2));
	}

	public static String mulCostRate(double v1,double v2){
		return mulStr(costRate,Double.toString(v1),Double.toString(v2));
	}

	public static String mulStr(DecimalFormat format,String...args){
		BigDecimal total = new BigDecimal("1");
		for(String arg : args){
			total = total.multiply(new BigDecimal(arg));
		}
		return format.format(total.doubleValue());
	}

	/**
	 * 数据相除（v1/v2）
	 * @author zhenghaibin
	 * @param v1
	 * @param v2
	 * @return
	 * @Date 2017年3月25日
	 */
	public static String div(DecimalFormat format,double v1,double v2){
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return format.format(b1.divide(b2).doubleValue());
	}

    /**
     * 计算费用，loanAmount为本金，fee为利率(这里的利率为整数，计算会除以100)，period为周期天数
     * @author zhenghaibin
     * @param loanAmount
     * @param fee
     * @param period
     * @return
     * @Date 2017年3月25日
     */
	public static String getCost(String loanAmount,String fee,int period){
        String cost = mulCostItem(Double.parseDouble(loanAmount),Double.parseDouble(fee));
        return mulCostItem(Double.parseDouble(cost),period);
	}

}
