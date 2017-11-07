package com.xiaobaidu.mall.util;


import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author hefaji
 * @create 2017-09-21 11:55
 **/
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final String PATTERN_TIME = "HH:mm:ss";
    public static final String PATTERN_SHORT_TIME = "HH:mm";
    public static final Date LONG_BEFORE_TIME = string2Date("1970-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
    public static final Date LONG_AFTER_TIME = string2Date("2048-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");

    public DateUtils() {
    }

    public static Date afterMilliseconds(long time, long milliseconds) {
        return new Date(time + milliseconds);
    }

    public static Date afterSeconds(long time, long seconds) {
        return new Date(time + 1000L * seconds);
    }

    public static Date afterSeconds(long seconds) {
        return new Date(System.currentTimeMillis() + 1000L * seconds);
    }

    public static Date afterMinutes(long time, long minutes) {
        return new Date(time + 60000L * minutes);
    }

    public static Date afterMinutes(long minutes) {
        return new Date(System.currentTimeMillis() + 60000L * minutes);
    }

    public static Date afterHours(long time, long hours) {
        return new Date(time + 3600000L * hours);
    }

    public static Date afterHours(long hours) {
        return new Date(System.currentTimeMillis() + 3600000L * hours);
    }

    public static Date afterDays(Date date, long days) {
        return new Date(date.getTime() + 86400000L * days);
    }

    public static Date afterDays(String date, long days) {
        Date dateTmp = parseDate(date);
        return afterDays(dateTmp, days);
    }

    public static Date afterDays(long time, long days) {
        return new Date(time + 86400000L * days);
    }

    public static Date afterDays(long days) {
        return new Date(System.currentTimeMillis() + 86400000L * days);
    }

    public static Date afterYears(long time, long years) {
        return new Date(time + 31536000000L * years);
    }

    public static Date afterYears(long years) {
        return new Date(System.currentTimeMillis() + 31536000000L * years);
    }

    public static Date parseDate(String text) {
        return parseDate(text, new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"});
    }

    public static Date parseDate(String text, TimeZone zone) {
        return parseDate(text, zone, new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"});
    }

    public static Date parseDate(String text, String[] dateFormatPatterns) {
        return parseDate(text, (TimeZone)null, dateFormatPatterns);
    }

    public static Date parseDate(String text, TimeZone zone, String[] dateFormatPatterns) {
        if(dateFormatPatterns != null) {
            String[] arrayOfString = dateFormatPatterns;
            int j = dateFormatPatterns.length;
            int i = 0;

            while(i < j) {
                String pattern = arrayOfString[i];

                try {
                    SimpleDateFormat parser = new SimpleDateFormat(pattern);
                    if(zone != null) {
                        parser.setTimeZone(zone);
                    }

                    return parser.parse(text);
                } catch (Exception var8) {
                    ++i;
                }
            }
        }

        throw new RuntimeException("Unparseable date: " + text);
    }

    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatDate(Date date, TimeZone zone) {
        return formatDate(date, zone, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatDate(Date date, String dateFormatPattern) {
        return formatDate(date, (TimeZone)null, dateFormatPattern);
    }

    public static String formatDate(Date date, TimeZone zone, String dateFormatPattern) {
        SimpleDateFormat dateFormat = null;

        try {
            dateFormat = new SimpleDateFormat(dateFormatPattern);
        } catch (Exception var5) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        if(zone != null) {
            dateFormat.setTimeZone(zone);
        }

        return formatDate(date, (DateFormat)dateFormat);
    }

    public static String formatDate(Date date, DateFormat dateFormat) {
        if(date == null) {
            throw new IllegalArgumentException("date can not be null");
        } else if(dateFormat == null) {
            throw new IllegalArgumentException("dateFormat can not be null");
        } else {
            return dateFormat.format(date);
        }
    }

    public static Timestamp[] oneDay(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date != null?date:new Date());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Timestamp[] array = new Timestamp[]{new Timestamp(calendar.getTimeInMillis()), null};
        calendar.add(5, 1);
        calendar.add(14, -1);
        array[1] = new Timestamp(calendar.getTimeInMillis());
        return array;
    }

    public static Timestamp[] oneDay(String date) {
        Date d = null;
        if(date != null && date.length() == 8) {
            d = parseDate(date, new String[]{"yyyyMMdd"});
        }

        return oneDay(d);
    }

    public static Date onlyDate(Date time) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(time);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static String dateString(String d) {
        if(!StringUtils.isEmpty(d) && d.length() == 8) {
            char[] array = d.toCharArray();
            char[] buff = new char[10];
            System.arraycopy(array, 0, buff, 0, 4);
            System.arraycopy(array, 4, buff, 5, 2);
            System.arraycopy(array, 6, buff, 8, 2);
            buff[7] = 45;
            buff[4] = 45;
            return new String(buff);
        } else {
            return d;
        }
    }

    public static int getDayOfWeek(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(7);
    }

    public static long getDaySeparate(Date date1, Date date2) {
        return (date2.getTime() - date1.getTime()) / 86400000L;
    }

    public static boolean isSameWeek(int year, int week, int firstDayOfWeek) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(firstDayOfWeek);
        return year == cal.get(1) && week == cal.get(3);
    }

    public static boolean isSameWeek(Date time, int firstDayOfWeek) {
        if(time == null) {
            return false;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(time);
            cal.setFirstDayOfWeek(firstDayOfWeek);
            return isSameWeek(cal.get(1), cal.get(3), firstDayOfWeek);
        }
    }

    public static Date firstTimeOfWeek(int firstDayOfWeek, Date time) {
        Calendar cal = Calendar.getInstance();
        if(time != null) {
            cal.setTime(time);
        }

        cal.setFirstDayOfWeek(firstDayOfWeek);
        int day = cal.get(7);
        if(day == firstDayOfWeek) {
            day = 0;
        } else if(day < firstDayOfWeek) {
            day += 7 - firstDayOfWeek;
        } else if(day > firstDayOfWeek) {
            day -= firstDayOfWeek;
        }

        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        cal.add(5, -day);
        return cal.getTime();
    }

    public static boolean isToday(Date date) {
        return date == null?false:isSameDay(date, new Date());
    }

    public static String date2String(Date date, String pattern) {
        return (new SimpleDateFormat(pattern)).format(date);
    }

    public static Date string2Date(String string, String pattern) {
        try {
            return (new SimpleDateFormat(pattern)).parse(string);
        } catch (ParseException var3) {
            throw new IllegalArgumentException("无法将字符串[" + string + "]按格式[" + pattern + "]转换为日期", var3);
        }
    }

    public static Date addTime(Date source, int hours, int minutes, int second) {
        if(source == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(source);
            cal.add(11, hours);
            cal.add(12, minutes);
            cal.add(13, second);
            return cal.getTime();
        }
    }

    public static Date getFirstTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if(date != null) {
            calendar.setTime(date);
        }

        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getNextDayFirstTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime() + 86400000L);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public static int calcIntervalDays(Date start, Date end) {
        Date startDate0AM = getFirstTime(start);
        Date endDate0AM = getFirstTime(end);
        long subValue = startDate0AM.getTime() - endDate0AM.getTime();
        return Math.abs((int) MathUtils.divideAndRoundUp((double)subValue, 8.64E7D, 0));
    }

    public static int calcIntervalDaysNoAbs(Date start, Date end) {
        Date startDate0AM = getFirstTime(start);
        Date endDate0AM = getFirstTime(end);
        long subValue = startDate0AM.getTime() - endDate0AM.getTime();
        return (int)MathUtils.divideAndRoundUp((double)subValue, 8.64E7D, 0);
    }

    public static int calcIntervalSecond(Date start, Date end) {
        long subVal = end.getTime() - start.getTime();
        return (int)MathUtils.divideAndRoundUp((double)subVal, 1000.0D, 0);
    }

    public static boolean isEquals(Date date1, Date date2) {
        return date1 == null && date2 == null?true:(date1 == null && date2 != null?false:(date1 != null && date2 == null?false:date1.getTime() == date2.getTime()));
    }

    public static boolean isPM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return 1 == calendar.get(9);
    }
}