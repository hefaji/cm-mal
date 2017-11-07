package com.xiaobaidu.mall.util;

import java.util.*;

/**
 * @author hefaji
 * @create 2017-09-21 10:58
 **/
public class CollectionUtils {
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];

    public CollectionUtils() {
    }

    public static int length(Collection collection) {
        return collection != null?collection.size():0;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static int length(Object[] array) {
        return array != null?array.length:0;
    }

    public static boolean isEmpty(Object[] array) {
        return length(array) == 0;
    }

    public static int length(Map map) {
        return map != null?map.size():0;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean equals(List x, List y) {
        if(x == y) {
            return true;
        } else if(x.size() != y.size()) {
            return false;
        } else {
            int index = 0;

            for(int len = x.size(); index < len; ++index) {
                Object valX = x.get(index);
                Object valY = y.get(index);
                if(!valX.equals(valY)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean deepEquals(Object[] x, Object[] y) {
        return Arrays.deepEquals(x, y);
    }

    public static boolean equals(Object[] x, Object[] y) {
        if(x == y) {
            return true;
        } else if(x.length != y.length) {
            return false;
        } else {
            int index = 0;

            for(int len = x.length; index < len; ++index) {
                Object valX = x[index];
                Object valY = y[index];
                if(!valX.equals(valY)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean equals(int[] x, int[] y) {
        if(x == y) {
            return true;
        } else if(x.length != y.length) {
            return false;
        } else {
            int index = 0;

            for(int len = x.length; index < len; ++index) {
                int valX = x[index];
                int valY = y[index];
                if(valX != valY) {
                    return false;
                }
            }

            return true;
        }
    }

    public static String listToStr(List<String> strList) {
        if(isEmpty((Collection)strList)) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer();
            Iterator var2 = strList.iterator();

            while(var2.hasNext()) {
                String str = (String)var2.next();
                sb.append(str);
            }

            return sb.toString();
        }
    }
}
