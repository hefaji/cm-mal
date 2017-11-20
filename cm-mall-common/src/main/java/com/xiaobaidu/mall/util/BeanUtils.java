package com.xiaobaidu.mall.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanUtils {
    private static Logger logger = LoggerFactory.getLogger(BeanUtils.class);
    public static ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
    private static BeanUtilsBean beanUtilsBean;

    public BeanUtils() {
    }

    public static boolean isEmpty(Object o) {
        if(o == null) {
            return true;
        } else {
            if(o instanceof String) {
                if(((String)o).trim().length() == 0) {
                    return true;
                }
            } else if(o instanceof Collection) {
                if(((Collection)o).isEmpty()) {
                    return true;
                }
            } else if(o.getClass().isArray()) {
                if(((Object[])((Object[])o)).length == 0) {
                    return true;
                }
            } else if(o instanceof Map) {
                if(((Map)o).isEmpty()) {
                    return true;
                }
            } else if(o instanceof Long) {
                Long lEmpty = Long.valueOf(0L);
                if(o == null || lEmpty.equals(o)) {
                    return true;
                }
            } else if(o instanceof Short) {
                Short sEmpty = Short.valueOf("0");
                if(o == null || sEmpty.equals(o)) {
                    return true;
                }
            } else if(o instanceof Integer) {
                Integer sEmpty = Integer.valueOf(0);
                if(o == null || sEmpty.equals(o)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    public static boolean isNotEmpty(Long o) {
        return !isEmpty(o);
    }

    public static boolean isNumber(Object o) {
        if(o == null) {
            return false;
        } else if(o instanceof Number) {
            return true;
        } else if(o instanceof String) {
            try {
                Double.parseDouble((String)o);
                return true;
            } catch (NumberFormatException var2) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Object populateEntity(Map map, Object entity) throws IllegalAccessException, InvocationTargetException {
        beanUtilsBean.populate(entity, map);
        return entity;
    }

    public static boolean validClass(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException var2) {
            return false;
        }
    }

    public static boolean isInherit(Class cls, Class parentClass) {
        return parentClass.isAssignableFrom(cls);
    }

    public static Object cloneBean(Object bean) {
        try {
            return beanUtilsBean.cloneBean(bean);
        } catch (Exception var2) {
            handleReflectionException(var2);
            return null;
        }
    }

    public static void copyNotNullProperties(Object dest, Object orig) {
        if(dest == null) {
            logger.error("No destination bean specified");
        } else if(orig == null) {
            logger.error("No origin bean specified");
        } else {
            try {
                int i;
                String name;
                Object value;
                if(orig instanceof DynaBean) {
                    DynaProperty[] origDescriptors = ((DynaBean)orig).getDynaClass().getDynaProperties();

                    for(i = 0; i < origDescriptors.length; ++i) {
                        name = origDescriptors[i].getName();
                        if(beanUtilsBean.getPropertyUtils().isReadable(orig, name) && beanUtilsBean.getPropertyUtils().isWriteable(dest, name)) {
                            value = ((DynaBean)orig).get(name);
                            beanUtilsBean.copyProperty(dest, name, value);
                        }
                    }
                } else if(orig instanceof Map) {
                    Iterator entries = ((Map)orig).entrySet().iterator();

                    while(entries.hasNext()) {
                        Entry entry = (Entry)entries.next();
                        name = (String)entry.getKey();
                        if(beanUtilsBean.getPropertyUtils().isWriteable(dest, name)) {
                            beanUtilsBean.copyProperty(dest, name, entry.getValue());
                        }
                    }
                } else {
                    PropertyDescriptor[] origDescriptors = beanUtilsBean.getPropertyUtils().getPropertyDescriptors(orig);

                    for(i = 0; i < origDescriptors.length; ++i) {
                        name = origDescriptors[i].getName();
                        if(!"class".equals(name) && beanUtilsBean.getPropertyUtils().isReadable(orig, name) && beanUtilsBean.getPropertyUtils().isWriteable(dest, name)) {
                            try {
                                value = beanUtilsBean.getPropertyUtils().getSimpleProperty(orig, name);
                                if(value != null && !value.toString().equals("null")) {
                                    beanUtilsBean.copyProperty(dest, name, value);
                                }
                            } catch (NoSuchMethodException var6) {
                                var6.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Exception var7) {
                handleReflectionException(var7);
            }

        }
    }

//    public static <T> T copyProperties(Class<T> destClass, Object orig) {
//        Object target = null;
//
//        try {
//            target = destClass.newInstance();
//            copyProperties(target, orig);
//            return target;
//        } catch (Exception var4) {
//            handleReflectionException(var4);
//            return null;
//        }
//    }

    public static void copyProperties(Object dest, Object orig) {
        try {
            beanUtilsBean.copyProperties(dest, orig);
        } catch (Exception var3) {
            handleReflectionException(var3);
        }

    }

    public static void copyProperty(Object bean, String name, Object value) {
        try {
            beanUtilsBean.copyProperty(bean, name, value);
        } catch (Exception var4) {
            handleReflectionException(var4);
        }

    }

    public static Map describe(Object bean) {
        try {
            return beanUtilsBean.describe(bean);
        } catch (Exception var2) {
            handleReflectionException(var2);
            return null;
        }
    }

    public static String[] getArrayProperty(Object bean, String name) {
        try {
            return beanUtilsBean.getArrayProperty(bean, name);
        } catch (Exception var3) {
            handleReflectionException(var3);
            return null;
        }
    }

    public static ConvertUtilsBean getConvertUtils() {
        return beanUtilsBean.getConvertUtils();
    }

    public static String getIndexedProperty(Object bean, String name, int index) {
        try {
            return beanUtilsBean.getIndexedProperty(bean, name, index);
        } catch (Exception var4) {
            handleReflectionException(var4);
            return null;
        }
    }

    public static String getIndexedProperty(Object bean, String name) {
        try {
            return beanUtilsBean.getIndexedProperty(bean, name);
        } catch (Exception var3) {
            handleReflectionException(var3);
            return null;
        }
    }

    public static String getMappedProperty(Object bean, String name, String key) {
        try {
            return beanUtilsBean.getMappedProperty(bean, name, key);
        } catch (Exception var4) {
            handleReflectionException(var4);
            return null;
        }
    }

    public static String getMappedProperty(Object bean, String name) {
        try {
            return beanUtilsBean.getMappedProperty(bean, name);
        } catch (Exception var3) {
            handleReflectionException(var3);
            return null;
        }
    }

    public static String getNestedProperty(Object bean, String name) {
        try {
            return beanUtilsBean.getNestedProperty(bean, name);
        } catch (Exception var3) {
            handleReflectionException(var3);
            return null;
        }
    }

    public static String getProperty(Object bean, String name) {
        try {
            return beanUtilsBean.getProperty(bean, name);
        } catch (Exception var3) {
            handleReflectionException(var3);
            return null;
        }
    }

    public static PropertyUtilsBean getPropertyUtils() {
        try {
            return beanUtilsBean.getPropertyUtils();
        } catch (Exception var1) {
            handleReflectionException(var1);
            return null;
        }
    }

    public static String getSimpleProperty(Object bean, String name) {
        try {
            return beanUtilsBean.getSimpleProperty(bean, name);
        } catch (Exception var3) {
            handleReflectionException(var3);
            return null;
        }
    }

    public static void populate(Object bean, Map properties) {
        try {
            beanUtilsBean.populate(bean, properties);
        } catch (Exception var3) {
            handleReflectionException(var3);
        }

    }

    public static void setProperty(Object bean, String name, Object value) {
        try {
            beanUtilsBean.setProperty(bean, name, value);
        } catch (Exception var4) {
            handleReflectionException(var4);
        }

    }

    private static void handleReflectionException(Exception e) {
        logger.error("BeanUtils error！", e);
    }

    public static Object convertByActType(String typeName, String value) {
        Object o = null;
        if(typeName.equals("int")) {
            o = Integer.valueOf(Integer.parseInt(value));
        } else if(typeName.equals("short")) {
            o = Short.valueOf(Short.parseShort(value));
        } else if(typeName.equals("long")) {
            o = Long.valueOf(Long.parseLong(value));
        } else if(typeName.equals("float")) {
            o = Float.valueOf(Float.parseFloat(value));
        } else if(typeName.equals("double")) {
            o = Double.valueOf(Double.parseDouble(value));
        } else if(typeName.equals("boolean")) {
            o = Boolean.valueOf(Boolean.parseBoolean(value));
        } else if(typeName.equals("java.lang.String")) {
            o = value;
        } else {
            o = value;
        }

        return o;
    }

    public static boolean fieldHasEmptyValue(Object bean) {
        if(bean == null) {
            return true;
        } else {
            Class<?> cls = bean.getClass();
            Method[] methods = cls.getDeclaredMethods();
            Field[] fields = cls.getDeclaredFields();
            Field[] var4 = fields;
            int var5 = fields.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Field field = var4[var6];

                try {
                    String fieldGetName = parGetName(field.getName());
                    if(checkGetMet(methods, fieldGetName)) {
                        Method fieldGetMet = cls.getMethod(fieldGetName, new Class[0]);
                        Object fieldVal = fieldGetMet.invoke(bean, new Object[0]);
                        if(fieldVal == null) {
                            return true;
                        }

                        if("".equals(fieldVal)) {
                            return true;
                        }
                    }
                } catch (Exception var15) {
                    ;
                }
            }

            Class<?> superclass = cls.getSuperclass();
            if(null != superclass) {
                Method[] sp_methods = superclass.getDeclaredMethods();
                Field[] sp_fields = superclass.getDeclaredFields();
                Field[] var19 = sp_fields;
                int var20 = sp_fields.length;

                for(int var21 = 0; var21 < var20; ++var21) {
                    Field field = var19[var21];

                    try {
                        String fieldGetName = parGetName(field.getName());
                        if(checkGetMet(sp_methods, fieldGetName)) {
                            Method fieldGetMet = superclass.getMethod(fieldGetName, new Class[0]);
                            Object fieldVal = fieldGetMet.invoke(bean, new Object[0]);
                            if(fieldVal == null) {
                                return true;
                            }

                            if("".equals(fieldVal)) {
                                return true;
                            }
                        }
                    } catch (Exception var14) {
                        ;
                    }
                }
            }

            return false;
        }
    }

    public static String parGetName(String fieldName) {
        if(null != fieldName && !"".equals(fieldName)) {
            int startIndex = 0;
            if(fieldName.charAt(0) == 95) {
                startIndex = 1;
            }

            return "get" + fieldName.substring(startIndex, startIndex + 1).toUpperCase() + fieldName.substring(startIndex + 1);
        } else {
            return null;
        }
    }

    public static boolean checkGetMet(Method[] methods, String fieldGetMet) {
        Method[] var2 = methods;
        int var3 = methods.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Method met = var2[var4];
            if(fieldGetMet.equals(met.getName())) {
                return true;
            }
        }

        return false;
    }

//    public static <K, V> Map<K, V> transBean2Map(Object obj) {
//        if(obj == null) {
//            return null;
//        } else {
//            HashMap map = new HashMap();
//
//            try {
//                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
//                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//                PropertyDescriptor[] var4 = propertyDescriptors;
//                int var5 = propertyDescriptors.length;
//
//                for(int var6 = 0; var6 < var5; ++var6) {
//                    PropertyDescriptor property = var4[var6];
//                    K key = property.getName();
//                    if(!key.equals("class")) {
//                        Method getter = property.getReadMethod();
//                        V value = getter.invoke(obj, new Object[0]);
//                        map.put(key, value);
//                    }
//                }
//            } catch (Exception var11) {
//                System.out.println("transBean2Map Error " + var11);
//            }
//
//            return map;
//        }
//    }

    public static void transMap2Bean(Map<String, Object> map, Object obj) {
        if(map != null && obj != null) {
            try {
                populate(obj, map);
            } catch (Exception var3) {
                System.out.println("transMap2Bean2 Error " + var3);
            }

        }
    }

    public static <C extends Collection<E>, E> ArrayList<E> stringToBeanList(Object obj, Class<E> elementType, String[] strs) {
        JSONArray jsonArray = JSONArray.fromObject(obj);
        ArrayList<E> arrayList = new ArrayList();
        Iterator var5 = jsonArray.iterator();

        while(var5.hasNext()) {
            Object o = var5.next();
            StringUtils.setJsonObjectJsonTostr((JSONObject)o, strs);
            E a = JsonUtils.string2Object(o.toString(), elementType);
            arrayList.add(a);
        }

        return arrayList;
    }

    static {
        beanUtilsBean = new BeanUtilsBean(convertUtilsBean, new PropertyUtilsBean());
        convertUtilsBean.register(new DateConverter(), Date.class);
        convertUtilsBean.register(new LongConverter((Object)null), Long.class);
    }
}
