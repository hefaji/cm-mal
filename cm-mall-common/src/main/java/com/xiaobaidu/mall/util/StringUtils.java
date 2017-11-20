package com.xiaobaidu.mall.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.json.JSONObject;

public abstract class StringUtils {
    public static final String EMPTY_STRING = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final char DEFAULT_SEPARATOR = ',';
    public static final String DEFAULT_SEPARATOR_STRING = ",";
    public static final char MAP_KEY_SEPARATOR = ':';
    public static final char MAP_KEY_SEPARATOR2 = '=';
    public static final String MAP_KEY_SEPARATOR_STRING = ":";
    public static final char ARRAY_BOUND_START = '[';
    public static final char ARRAY_BOUND_END = ']';
    public static final char MAP_BOUND_START = '{';
    public static final char MAP_BOUND_END = '}';
    public static final char LF = '\n';
    public static final char CR = '\r';

    public StringUtils() {
    }

    public static boolean isEmpty(String s) {
        return length(s) == 0;
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static boolean notEmpty(String s) {
        return length(s) > 0;
    }

    public static int length(String s) {
        return s != null?s.length():0;
    }

    public static boolean isChinese(char a) {
        return a >= 19968 && a <= 171941;
    }

    public static boolean containsChinese(String s) {
        if(null != s && !"".equals(s.trim())) {
            for(int i = 0; i < s.length(); ++i) {
                if(isChinese(s.charAt(i))) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean hasText(String s) {
        if(isEmpty(s)) {
            return false;
        } else {
            int i = s.length();

            do {
                if(i <= 0) {
                    return false;
                }

                --i;
            } while(s.charAt(i) <= 32);

            return true;
        }
    }

    public static boolean isHexPrefix(String s, int index) {
        return s.charAt(index) == 48 && s.charAt(index + 1) == 120;
    }

    public static boolean isInteger(String s) {
        int sz = length(s);
        if(sz == 0) {
            return false;
        } else {
            for(int i = 0; i < sz; ++i) {
                if(!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isNumeral(String s) {
        int sz = length(s);
        return sz == 0?false:s.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }

    public static String select(String s1, String s2) {
        return notEmpty(s1)?s1:s2;
    }

    public static String select(String[] array) {
        if(array != null) {
            String[] arrayOfString = array;
            int j = array.length;

            for(int i = 0; i < j; ++i) {
                String e = arrayOfString[i];
                if(notEmpty(e)) {
                    return e;
                }
            }
        }

        return null;
    }

    public static String trim(String s) {
        return isEmpty(s)?s:s.trim();
    }

    public static String deleteWhitespace(String s) {
        if(isEmpty(s)) {
            return s;
        } else {
            int length = s.length();
            char[] chs = new char[length];
            int count = 0;

            for(int i = 0; i < length; ++i) {
                char ch = s.charAt(i);
                if(!Character.isWhitespace(ch)) {
                    chs[count++] = ch;
                }
            }

            if(count == length) {
                return s;
            } else {
                return new String(chs, 0, count);
            }
        }
    }

    public static String deleteCharacter(String s, char ch) {
        int length = length(s);
        if(length == 0) {
            return s;
        } else {
            char[] chs = new char[length];
            int count = 0;

            for(int i = 0; i < length; ++i) {
                char c = s.charAt(i);
                if(c != ch) {
                    chs[count++] = c;
                }
            }

            if(count == length) {
                return s;
            } else {
                return new String(chs, 0, count);
            }
        }
    }

    public static String deleteCharacter(String s, char[] charArray) {
        int length = length(s);
        if(length == 0) {
            return s;
        } else {
            Arrays.sort(charArray);
            char[] chs = new char[length];
            int count = 0;

            for(int i = 0; i < length; ++i) {
                char c = s.charAt(i);
                if(Arrays.binarySearch(charArray, c) < 0) {
                    chs[count++] = c;
                }
            }

            if(count == length) {
                return s;
            } else {
                return new String(chs, 0, count);
            }
        }
    }

    public static String capitalFirstLetter(String s) {
        int len = length(s);
        return len == 0?s:(len == 1?String.valueOf(Character.toUpperCase(s.charAt(0))):Character.toUpperCase(s.charAt(0)) + s.substring(1));
    }

    public static String convert(String utfString) {
        if(isEmpty(utfString)) {
            return utfString;
        } else {
            StringBuilder sb = new StringBuilder();
            int pos = 0;

            int i;
            while((i = utfString.indexOf("\\u", pos)) != -1) {
                sb.append(utfString.substring(pos, i));
                if(i + 5 < utfString.length()) {
                    pos = i + 6;
                    sb.append((char)Integer.parseInt(utfString.substring(i + 2, i + 6), 16));
                }
            }

            return sb.toString();
        }
    }

    public static String leftPad(String s, int size) {
        return leftPad(s, size, ' ');
    }

    public static String rightPad(String s, int size) {
        return rightPad(s, size, ' ');
    }

    public static String leftPad(String s, int size, char padChar) {
        int length = length(s);
        if(length == 0) {
            return s;
        } else {
            int pads = size - length;
            return pads <= 0?s:padding(pads, padChar).concat(s);
        }
    }

    public static String rightPad(String s, int size, char padChar) {
        int length = length(s);
        if(length == 0) {
            return s;
        } else {
            int pads = size - length;
            return pads <= 0?s:s.concat(padding(pads, padChar));
        }
    }

    public static String abbr(String s, int len) {
        int length = length(s);
        return length <= len?s:s.substring(0, len - 3) + "...";
    }

    private static String padding(int repeat, char padChar) {
        if(repeat < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
        } else {
            char[] buf = new char[repeat];

            for(int i = 0; i < buf.length; ++i) {
                buf[i] = padChar;
            }

            return new String(buf);
        }
    }

    public static String left(String s, int len) {
        int length = length(s);
        return length <= len?s:s.substring(0, len);
    }

    public static String right(String s, int len) {
        int length = length(s);
        return length <= len?s:s.substring(length - len);
    }

    public static String mid(String s, int startIndex, int len) {
        int length = length(s);
        if(length != 0 && len >= 0 && startIndex <= length) {
            if(startIndex < 0) {
                startIndex = 0;
            }

            return s.length() <= startIndex + len?s.substring(startIndex):s.substring(startIndex, startIndex + len);
        } else {
            return s;
        }
    }

    public static String substringBetween(String s, String open, String close) {
        if(s != null && open != null && close != null) {
            int start = s.indexOf(open);
            if(start != -1) {
                int end = s.indexOf(close, start + open.length());
                if(end != -1) {
                    return s.substring(start + open.length(), end);
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public static String[] toArray(String commaDelim) {
        if(isEmpty(commaDelim)) {
            return new String[0];
        } else {
            List list = toList(commaDelim);
            return (String[])((String[])list.toArray(new String[list.size()]));
        }
    }

    public static String[] toArray(String commaDelim, String separator) {
        if(isEmpty(commaDelim)) {
            return new String[0];
        } else {
            List list = toList(commaDelim, separator);
            return (String[])((String[])list.toArray(new String[list.size()]));
        }
    }

    public static String[] toArray(String commaDelim, char separator) {
        if(isEmpty(commaDelim)) {
            return new String[0];
        } else {
            List list = toList(commaDelim, separator);
            return (String[])((String[])list.toArray(new String[list.size()]));
        }
    }

    public static List<String> toList(String commaDelim) {
        return toList(commaDelim, ',');
    }

    public static List<String> toList(String commaDelim, String separator) {
        int len = length(commaDelim);
        if(len == 0) {
            return Collections.emptyList();
        } else {
            List list = new ArrayList();
            parseCollection(list, commaDelim, separator);
            return list;
        }
    }

    public static List<String> toList(String commaDelim, char separator) {
        int len = length(commaDelim);
        if(len == 0) {
            return Collections.emptyList();
        } else {
            List list = new ArrayList();
            parseCollection(list, commaDelim, separator);
            return list;
        }
    }

    public static Set<String> toSet(String commaDelim) {
        return toSet(commaDelim, ',');
    }

    public static Set<String> toSet(String commaDelim, String separator) {
        int len = length(commaDelim);
        if(len == 0) {
            return Collections.emptySet();
        } else {
            Set set = new LinkedHashSet();
            parseCollection(set, commaDelim, separator);
            return set;
        }
    }

    public static Set<String> toSet(String commaDelim, char separator) {
        int len = length(commaDelim);
        if(len == 0) {
            return Collections.emptySet();
        } else {
            Set set = new LinkedHashSet();
            parseCollection(set, commaDelim, separator);
            return set;
        }
    }

    private static void parseCollection(Collection<String> collection, String commaDelim, String separator) {
        int len = length(commaDelim);
        if(len != 0) {
            String s = null;
            if(commaDelim.charAt(0) == 91 && commaDelim.charAt(len - 1) == 93) {
                s = commaDelim.substring(1, len - 1);
            } else {
                s = commaDelim;
            }

            StringTokenizer token = new StringTokenizer(s, separator);

            while(token.hasMoreTokens()) {
                String item = token.nextToken();
                String trimmed = item.trim();
                collection.add(trimmed);
            }

        }
    }

    private static void parseCollection(Collection<String> collection, String commaDelim, char separator) {
        int len = length(commaDelim);
        if(len != 0) {
            String s = null;
            if(commaDelim.charAt(0) == 91 && commaDelim.charAt(len - 1) == 93) {
                s = commaDelim.substring(1, len - 1);
                len = s.length();
                if(len == 0) {
                    return;
                }
            } else {
                s = commaDelim;
            }

            int index = 0;

            int start;
            for(start = 0; index < len; ++index) {
                char ch = s.charAt(index);
                if(ch == separator) {
                    String block = s.substring(start, index);
                    start = index + 1;
                    collection.add(block.trim());
                }
            }

            if(start < index) {
                String block = s.substring(start, index);
                collection.add(block.trim());
            } else if(start == index) {
                collection.add("");
            }

        }
    }

    public static Map<String, String> toMap(String commaDelim) {
        if(commaDelim != null && commaDelim.trim().length() != 0) {
            String s = null;
            int len = commaDelim.length();
            if(commaDelim.charAt(0) == 123 && commaDelim.charAt(len - 1) == 125) {
                s = commaDelim.substring(1, len - 1);
            } else {
                s = commaDelim;
            }

            Map map = new LinkedHashMap();
            StringTokenizer token = new StringTokenizer(s, ",");

            while(token.hasMoreTokens()) {
                String item = token.nextToken();
                int index = item.indexOf(58);
                if(index <= 0) {
                    index = item.indexOf(61);
                }

                if(index > 0) {
                    String key = item.substring(0, index).trim();
                    String val = item.substring(index + 1).trim();
                    map.put(key, val);
                }
            }

            return map;
        } else {
            return Collections.emptyMap();
        }
    }

    public static String toString(boolean[] array) {
        return array != null?Arrays.toString(array):"";
    }

    public static String toString(byte[] array) {
        return array != null?Arrays.toString(array):"";
    }

    public static String toString(short[] array) {
        return array != null?Arrays.toString(array):"";
    }

    public static String toString(int[] array) {
        return array != null?Arrays.toString(array):"";
    }

    public static String toString(long[] array) {
        return array != null?Arrays.toString(array):"";
    }

    public static String toString(char[] array) {
        return array != null?Arrays.toString(array):"";
    }

    public static String toString(float[] array) {
        return array != null?Arrays.toString(array):"";
    }

    public static String toString(double[] array) {
        return array != null?Arrays.toString(array):"";
    }

    public static String toString(Collection collection) {
        return toString(collection, ",", true);
    }

    public static String toString(Collection collection, boolean includeBound) {
        return toString(collection, ",", includeBound);
    }

    public static String toString(Collection collection, String separator, boolean includeBound) {
        int length = CollectionUtils.length(collection);
        if(length == 0) {
            return "";
        } else {
            int bufferSize = length * (16 + separator.length());
            StringBuilder sb = new StringBuilder(bufferSize + 2);
            if(includeBound) {
                sb.append('[');
            }

            Iterator iter = collection.iterator();
            boolean hasNext = iter.hasNext();

            while(hasNext) {
                Object element = iter.next();
                sb.append("'" + element + "'");
                hasNext = iter.hasNext();
                if(hasNext) {
                    sb.append(separator);
                }
            }

            if(includeBound) {
                sb.append(']');
            }

            return sb.toString();
        }
    }

    public static String toString(Object obj) {
        if(obj == null) {
            return "null";
        } else if(obj instanceof String) {
            return (String)obj;
        } else if(obj instanceof Map) {
            return toString((Object)((Map)obj));
        } else if(obj instanceof Collection) {
            return toString((Collection)obj);
        } else if(obj instanceof Date) {
            SimpleDateFormat rfc3399 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            return rfc3399.format((Date)obj);
        } else {
            return !obj.getClass().isPrimitive() && !obj.getClass().getName().startsWith("java")?(obj instanceof Object[]?toString((Object)((Object[])((Object[])obj))):(obj instanceof boolean[]?toString((boolean[])((boolean[])obj)):(obj instanceof byte[]?toString((byte[])((byte[])obj)):(obj instanceof short[]?toString((short[])((short[])obj)):(obj instanceof int[]?toString((int[])((int[])obj)):(obj instanceof long[]?toString((long[])((long[])obj)):(obj instanceof char[]?toString((char[])((char[])obj)):(obj instanceof float[]?toString((float[])((float[])obj)):(obj instanceof double[]?toString((double[])((double[])obj)):obj.toString()))))))))):String.valueOf(obj);
        }
    }

    public static String toObjectString(Object obj) {
        return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
    }

    public static String cleanUpRedundantBlank(String str) {
        if(null == str) {
            return str;
        } else {
            Pattern pattern = Pattern.compile("\\s+");
            Matcher matcher = pattern.matcher(str);
            return matcher.replaceAll(" ");
        }
    }

    public static String htmlEscape(String html) {
        if(null == html) {
            return "";
        } else {
            String temp = html.replace("'", "&apos;");
            temp = temp.replaceAll("&", "&amp;");
            temp = temp.replace("\"", "&quot;");
            temp = temp.replace("\\/", "&#47;");
            temp = temp.replace("<", "&lt;");
            temp = temp.replaceAll(">", "&gt;");
            return temp;
        }
    }

    public static String strToQuot(String str) {
        return isEmpty(str)?"":str.replaceAll("\"", "&quot;");
    }

    public static String clearScript(String html) {
        if(null == html) {
            return "";
        } else {
            Pattern p = Pattern.compile("(?is)<script[^>]*?>.*?<\\/script>");
            Matcher m = p.matcher(html);
            return m.replaceAll("");
        }
    }

    public static String makeFirstLetterUpperCase(String newStr) {
        if(newStr.length() == 0) {
            return newStr;
        } else {
            char[] oneChar = new char[]{newStr.charAt(0)};
            String firstChar = new String(oneChar);
            return firstChar.toUpperCase() + newStr.substring(1);
        }
    }

    public static boolean isLettersAndNumbers(String s) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{1,}$");
        return pattern.matcher(s).matches();
    }

    public static String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        return matcher.find()?matcher.group(0):"";
    }

    public static void setJsonObjectJsonTostr(JSONObject ja, String[] fields) {
        if(!BeanUtils.isEmpty(fields)) {
            String[] var2 = fields;
            int var3 = fields.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String f = var2[var4];
                if(ja.containsKey(f)) {
                    String val = ja.getString(f);
                    if(!isEmpty(val) && !val.equals("[]") && !val.equals("{}")) {
                        ja.put(f, "\"" + val + "\"");
                    } else {
                        ja.put(f, "");
                    }
                }
            }

        }
    }

    public static String trimSufffix(String toTrim, String trimStr) {
        while(toTrim.endsWith(trimStr)) {
            toTrim = toTrim.substring(0, toTrim.length() - trimStr.length());
        }

        return toTrim;
    }

    public static String quotToStr(String str) {
        if(isEmpty(str)) {
            return "";
        } else {
            str = str.replaceAll("\\\\&quot;", "\"").replaceAll("&quot;", "\"").replaceAll("#___#", "'");
            if(str.startsWith("\"{")) {
                str = str.substring(1, str.length());
            }

            if(str.endsWith("}\"")) {
                str = str.substring(0, str.length() - 1);
            }

            return str;
        }
    }

    public static boolean passwordValid(String password) {
        boolean isValid = false;
        String expression = "^(?=.*?[A-Z,a-z])(?=.*?[0-9])[a-zA-Z0-9]{6,20}$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()) {
            isValid = true;
        }

        return isValid;
    }
}
