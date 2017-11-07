package com.xiaobaidu.mall.util;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hefaji
 * @create 2017-09-21 11:54
 **/
public class UUIDUtils {

    private static final ReentrantLock lock = new ReentrantLock();
    private static long lastTime;
    private static Random random = new Random();
    private static int min = 20;
    private static int max = 30;

    public UUIDUtils() {
    }

    public static String GenNumUUID(int length) {
        String num = "";
        if(min <= length && max >= length) {
            lock.lock();

            try {
                num = DateUtils.formatDate(new Date(), "yyyyMMddHHmmssSSS") + String.valueOf((1.0D + random.nextDouble()) * Math.pow(10.0D, 18.0D)).substring(2, 15);
            } finally {
                lock.unlock();
            }

            return num.substring(0, length);
        } else {
            return num;
        }
    }

    public static String Gen_UUID() {
        String result = null;
        String H_Way = String.valueOf(Random_Char());
        StringBuffer H_B = new StringBuffer();

        for(int i = 0; i < 8; ++i) {
            H_B.append(Random_Char());
        }

        String H_IP = H_B.toString();
        long timeMillis = System.currentTimeMillis();
        lock.lock();

        try {
            if(timeMillis > lastTime) {
                lastTime = timeMillis;
            } else {
                timeMillis = ++lastTime;
            }
        } finally {
            lock.unlock();
        }

        String H_Now;
        for(H_Now = Long.toHexString(timeMillis); H_Now.length() < 12; H_Now = "0" + H_Now) {
            ;
        }

        while(H_Now.length() > 12) {
            H_Now = H_Now.substring(H_Now.length() - 12, H_Now.length());
        }

        char[] C_Random = new char[]{Random_Char(), Random_Char(), Random_Char(), Random_Char()};
        String H_Random = String.valueOf(C_Random);
        char[] C_Random2 = new char[]{Random_Char(), Random_Char(), Random_Char()};
        String H_Nouse = String.valueOf(C_Random2);
        result = H_Now + H_Way + H_IP + H_Random + H_Nouse;
        byte H_Check = (byte)result.charAt(0);

        for(int temp_int = 1; temp_int < result.length(); ++temp_int) {
            H_Check ^= (byte)result.charAt(temp_int);
        }

        if(H_Check <= 15) {
            result = result + "0" + Integer.toHexString(H_Check);
        } else {
            result = result + Integer.toHexString(H_Check);
        }

        while(32 - result.length() > 0) {
            result = result + String.valueOf(Random_Char());
        }

        return result;
    }

    public static final char Random_Char() {
        char result;
        for(result = 58; result > 57 && result < 65 || result > 90 && result < 97; result = (char)((int)(Math.random() * 2.147483647E9D % 62.0D + 48.0D))) {
            ;
        }

        return result;
    }

    public static String getRandom_Char_to4() {
        char[] C_Random = new char[]{Random_Char(), Random_Char(), Random_Char(), Random_Char()};
        String H_Random = String.valueOf(C_Random);
        return H_Random;
    }
}
