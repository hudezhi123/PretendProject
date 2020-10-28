package com.hdz.pretendproject.utils;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isNullOrEmpty(String str) {
        if (str == null) {
            return true;
        }
        if ("".equals(str)) {
            return true;
        }
        if ("null".equals(str)) {
            return true;
        }
        return false;
    }


    public static double paserDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 描述：将null转化为“”.
     *
     * @param str 指定的字符串
     * @return 字符串的String类型
     */
    public static String parseEmpty(String str) {
        if (str == null || "null".equals(str.trim())) {
            str = "";
        }
        return str.trim();
    }


    /**
     * 获取字符串中文字符的长度（每个中文算2个字符）.
     *
     * @param str 指定的字符串
     * @return 中文字符的长度
     */
    public static int chineseLength(String str) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        if (!isEmpty(str)) {
            for (int i = 0; i < str.length(); i++) {
                /* 获取一个字符 */
                String temp = str.substring(i, i + 1);
                /* 判断是否为中文字符 */
                if (temp.matches(chinese)) {
                    valueLength += 2;
                }
            }
        }
        return valueLength;
    }

    /**
     * 描述：获取字符串的长度.
     *
     * @param str 指定的字符串
     * @return 字符串的长度（中文字符计2个）
     */
    public static int strLength(String str) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        if (!isEmpty(str)) {
            //获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
            for (int i = 0; i < str.length(); i++) {
                //获取一个字符
                String temp = str.substring(i, i + 1);
                //判断是否为中文字符
                if (temp.matches(chinese)) {
                    //中文字符长度为2
                    valueLength += 2;
                } else {
                    //其他字符长度为1
                    valueLength += 1;
                }
            }
        }
        return valueLength;
    }

    /**
     * 描述：获取指定长度的字符所在位置.
     *
     * @param str  指定的字符串
     * @param maxL 要取到的长度（字符长度，中文字符计2个）
     * @return 字符的所在位置
     */
    public static int subStringLength(String str, int maxL) {
        int currentIndex = 0;
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        //获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < str.length(); i++) {
            //获取一个字符
            String temp = str.substring(i, i + 1);
            //判断是否为中文字符
            if (temp.matches(chinese)) {
                //中文字符长度为2
                valueLength += 2;
            } else {
                //其他字符长度为1
                valueLength += 1;
            }
            if (valueLength >= maxL) {
                currentIndex = i;
                break;
            }
        }
        return currentIndex;
    }

    /**
     * 手机号号段校验，
     * 第1位：1；
     * 第2位：{3、4、5、6、7、8}任意数字；
     * 第3—11位：0—9任意数字
     *
     * @param value
     * @return
     */
    public static boolean isTelPhoneNumber(String value) {
        if (value != null && value.length() == 11) {
            Pattern pattern = Pattern.compile("^1[3|4|5|6|7|8][0-9]\\d{8}$");
            Matcher matcher = pattern.matcher(value);
            return matcher.matches();
        }
        return false;
    }

    /**
     * 只判断 首位数字是1 总数为11位
     * 判断是否为手机号
     */
    public static boolean isPhoneNumSingle(String phoneNum) {
        if (TextUtils.isEmpty(phoneNum.trim()))
            return false;
        Pattern p = Pattern.compile("^1\\d{10}$");
        Matcher m = p.matcher(phoneNum);
        boolean b = m.matches();
        return b;
    }

    /**
     * 正则匹配手机号码
     *
     * @param tel
     * @return
     */
    public static boolean checkTel(String tel) {
        Pattern p = Pattern.compile("^1[0-9]{10}$");
        Matcher matcher = p.matcher(tel);
        return matcher.matches();
    }

    /**
     * 匹配中国邮政编码
     *
     * @param postCode 邮政编码
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isPostCode(String postCode) {
        String reg = "[1-9]\\d{5}";
        return Pattern.matches(reg, postCode);
    }


    /**
     * 验证输入的身份证号是否合法
     */
    public static boolean isIdCard(String id) {
        if (id.toUpperCase().matches("(^\\d{15}$)|(^\\d{17}([0-9]|X)$)")) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 描述：是否只是字母和数字.
     *
     * @param str 指定的字符串
     * @return 是否只是字母和数字:是为true，否则false
     */
    public static Boolean isNumberLetter(String str) {
        Boolean isNoLetter = false;
        String expr = "^[A-Za-z0-9]+$";
        if (str.matches(expr)) {
            isNoLetter = true;
        }
        return isNoLetter;
    }

    /**
     * 描述：是否只是数字.
     *
     * @param str 指定的字符串
     * @return 是否只是数字:是为true，否则false
     */
    public static Boolean isNumber(String str) {
        Boolean isNumber = false;
        String expr = "^[0-9]+$";
        if (str.matches(expr)) {
            isNumber = true;
        }
        return isNumber;
    }

    /**
     * 描述：是否是邮箱.
     *
     * @param str 指定的字符串
     * @return 是否是邮箱:是为true，否则false
     */
    public static Boolean isEmail(String str) {
        Boolean isEmail = false;
        String expr = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        if (str.matches(expr)) {
            isEmail = true;
        }
        return isEmail;
    }

    /**
     * 描述：是否是中文.
     *
     * @param str 指定的字符串
     * @return 是否是中文:是为true，否则false
     */
    public static Boolean isChinese(String str) {
        Boolean isChinese = true;
        String chinese = "[\u0391-\uFFE5]";
        if (!isEmpty(str)) {
            //获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
            for (int i = 0; i < str.length(); i++) {
                //获取一个字符
                String temp = str.substring(i, i + 1);
                //判断是否为中文字符
                if (temp.matches(chinese)) {
                } else {
                    isChinese = false;
                }
            }
        }
        return isChinese;
    }

    /**
     * 描述：是否包含中文.
     *
     * @param str 指定的字符串
     * @return 是否包含中文:是为true，否则false
     */
    public static Boolean isContainChinese(String str) {
        Boolean isChinese = false;
        String chinese = "[\u0391-\uFFE5]";
        if (!isEmpty(str)) {
            //获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
            for (int i = 0; i < str.length(); i++) {
                //获取一个字符
                String temp = str.substring(i, i + 1);
                //判断是否为中文字符
                if (temp.matches(chinese)) {
                    isChinese = true;
                } else {

                }
            }
        }
        return isChinese;
    }


    /**
     * 描述：标准化日期时间类型的数据，不足两位的补0.
     *
     * @param dateTime 预格式的时间字符串，如:2012-3-2 12:2:20
     * @return String 格式化好的时间字符串，如:2012-03-20 12:02:20
     */
    public static String dateTimeFormat(String dateTime) {
        StringBuilder sb = new StringBuilder();
        try {
            if (isEmpty(dateTime)) {
                return null;
            }
            String[] dateAndTime = dateTime.split(" ");
            if (dateAndTime.length > 0) {
                for (String str : dateAndTime) {
                    if (str.indexOf("-") != -1) {
                        String[] date = str.split("-");
                        for (int i = 0; i < date.length; i++) {
                            String str1 = date[i];
                            sb.append(strFormat2(str1));
                            if (i < date.length - 1) {
                                sb.append("-");
                            }
                        }
                    } else if (str.indexOf(":") != -1) {
                        sb.append(" ");
                        String[] date = str.split(":");
                        for (int i = 0; i < date.length; i++) {
                            String str1 = date[i];
                            sb.append(strFormat2(str1));
                            if (i < date.length - 1) {
                                sb.append(":");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    /**
     * 描述：不足2个字符的在前面补“0”.
     *
     * @param str 指定的字符串
     * @return 至少2个字符的字符串
     */
    public static String strFormat2(String str) {
        try {
            if (str.length() <= 1) {
                str = "0" + str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 描述：截取字符串到指定字节长度.
     *
     * @param str    the str
     * @param length 指定字节长度
     * @return 截取后的字符串
     */
    public static String cutString(String str, int length) {
        return cutString(str, length, "");
    }

    /**
     * 描述：截取字符串到指定字节长度.
     *
     * @param str    文本
     * @param length 字节长度
     * @param dot    省略符号
     * @return 截取后的字符串
     */
    public static String cutString(String str, int length, String dot) {
        int strBLen = strlen(str, "GBK");
        if (strBLen <= length) {
            return str;
        }
        int temp = 0;
        StringBuffer sb = new StringBuffer(length);
        char[] ch = str.toCharArray();
        for (char c : ch) {
            sb.append(c);
            if (c > 256) {
                temp += 2;
            } else {
                temp += 1;
            }
            if (temp >= length) {
                if (dot != null) {
                    sb.append(dot);
                }
                break;
            }
        }
        return sb.toString();
    }

    /**
     * 描述：截取字符串从第一个指定字符.
     *
     * @param str1   原文本
     * @param str2   指定字符
     * @param offset 偏移的索引
     * @return 截取后的字符串
     */
    public static String cutStringFromChar(String str1, String str2, int offset) {
        if (isEmpty(str1)) {
            return "";
        }
        int start = str1.indexOf(str2);
        if (start != -1) {
            if (str1.length() > start + offset) {
                return str1.substring(start + offset);
            }
        }
        return "";
    }

    /**
     * 描述：获取字节长度.
     *
     * @param str     文本
     * @param charset 字符集（GBK）
     * @return the int
     */
    public static int strlen(String str, String charset) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int length = 0;
        try {
            length = str.getBytes(charset).length;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

    /**
     * 获取大小的描述.
     *
     * @param size 字节个数
     * @return 大小的描述
     */
    public static String getSizeDesc(long size) {
        String suffix = "B";
        if (size >= 1024) {
            suffix = "K";
            size = size >> 10;
            if (size >= 1024) {
                suffix = "M";
                //size /= 1024;
                size = size >> 10;
                if (size >= 1024) {
                    suffix = "G";
                    size = size >> 10;
                    //size /= 1024;
                }
            }
        }
        return size + suffix;
    }

    /**
     * 描述：ip地址转换为10进制数.
     *
     * @param ip the ip
     * @return the long
     */
    public static long ip2int(String ip) {
        ip = ip.replace(".", ",");
        String[] items = ip.split(",");
        return Long.valueOf(items[0]) << 24 | Long.valueOf(items[1]) << 16 | Long.valueOf(items[2]) << 8 | Long.valueOf(items[3]);
    }

    //取首字母转大写
    public static String getFirstChatForString(String string) {
        if (isNullOrEmpty(string)) {
            return "";
        }
        char f = string.charAt(0);

        return (f + "").toUpperCase();
    }

    //资产显示六位
    public static String formatPrice(double price, boolean halfUp) {
        DecimalFormat formater = new DecimalFormat();
        // keep 2 decimal places
        formater.setMaximumFractionDigits(6);
        formater.setGroupingSize(3);
        formater.setRoundingMode(halfUp ? RoundingMode.HALF_UP : RoundingMode.FLOOR);
        return formater.format(price);
    }

    //保留两位小数
    public static String formatDouble2(double dou) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(dou);
    }

    //保留十位小数
    public static String formatDouble10(double dou) {
        DecimalFormat formater = new DecimalFormat();
        // keep 2 decimal places
        formater.setMaximumFractionDigits(10);
        formater.setGroupingSize(3);
        formater.setRoundingMode(RoundingMode.HALF_UP);
        return formater.format(dou);
    }


    public static String formatDouble(String dou) {
        BigDecimal bigDecimal = new BigDecimal(dou);
        DecimalFormat formater = new DecimalFormat();
        formater.setMaximumFractionDigits(20);
        formater.setGroupingSize(3);
//        formater.setRoundingMode(RoundingMode.HALF_UP);
        return formater.format(bigDecimal);
    }


    /**
     * 进行千分位分组，并保留最后两位小数
     *
     * @param price
     * @param halfUp
     * @return
     */
    public static String format3String(double price, boolean halfUp) {
        DecimalFormat formater = new DecimalFormat();
        // keep 2 decimal places
        formater.setMaximumFractionDigits(2);
        formater.setGroupingSize(3);
        formater.setRoundingMode(halfUp ? RoundingMode.HALF_UP : RoundingMode.FLOOR);
        return format2Tail(formater.format(price));
    }


    /**
     * 进行千分位分组，并保留最后两位小数
     *
     * @param price
     * @param halfUp
     * @return
     */
    public static String format3String(BigDecimal price, boolean halfUp) {
        DecimalFormat formater = new DecimalFormat();
        // keep 2 decimal places
        formater.setMaximumFractionDigits(2);
        formater.setGroupingSize(3);
        formater.setRoundingMode(halfUp ? RoundingMode.HALF_UP : RoundingMode.FLOOR);
        return format2Tail(formater.format(price));
    }

    public static String group3String(BigDecimal price){
        DecimalFormat formater = new DecimalFormat();
        formater.setGroupingSize(3);
        return formater.format(price);
    }

    public static String format33String(BigDecimal price, boolean halfUp) {
        DecimalFormat formater = new DecimalFormat();
        // keep 2 decimal places
        formater.setMaximumFractionDigits(3);
        formater.setGroupingSize(3);
        formater.setRoundingMode(halfUp ? RoundingMode.HALF_UP : RoundingMode.FLOOR);
        return format3Tail(formater.format(price));
    }

    public static String format3Tail(String price) {
        if (price.contains(".")) {
            String parts[] = price.split("\\.");
            if (parts[1].length() == 1) {
                return price + "00";
            } else if (parts[1].length() == 2) {
                return price + "0";
            } else if (parts[1].length() == 3) {
                return price;
            } else {
                return price.substring(0, price.indexOf(".") + 3);
            }
        } else {
            return price + ".000";
        }
    }

    /**
     * 保留三位小数
     *
     * @param price
     * @param halfUp
     * @return
     */
    public static String format3Tail(double price, boolean halfUp) {
        DecimalFormat formater = new DecimalFormat();
        formater.setMaximumFractionDigits(3);
        formater.setRoundingMode(RoundingMode.HALF_UP);
        return formater.format(price);
    }

    public static String format2Tail(BigDecimal price) {
        return format2Tail(price.toString());
    }

    public static String format2Tail(String price) {
        if (price.contains(".")) {
            String[] parts = price.split("\\.");
            int len = parts[1].length();
            if (len == 2) {
                return price;
            } else if (len == 1) {
                return price + "0";
            } else {
                String part2 = parts[1].substring(0, 2);
                return parts[0] + "." + part2;
            }
        } else {
            return price + ".00";
        }
    }


    public static String secretId(int startLen, int endLen, String id) {
        char[] arrayId = id.toCharArray();
        for (int i = 0; i < arrayId.length; i++) {
            if (i >= startLen && i < arrayId.length - endLen) {
                arrayId[i] = '*';
            }
        }
        return new String(arrayId);
    }

    /**
     * 截取电话号码并高亮显示
     *
     * @param str
     * @return
     */
    public static String pickCellHighlight(String str) {
        int count = 0;
        int index = 0;
        List<Integer> indexList = new ArrayList<>();
        char[] arrays = str.toCharArray();
        for (int i = 0; i < arrays.length; i++) {
            if ('0' <= arrays[i] && '9' >= arrays[i]) {
                count++;
                index = i;
                if (count == 11) {
                    indexList.add(index - 10);
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        StringBuilder sb = new StringBuilder(str);
        for (int j = indexList.size() - 1; j >= 0; j--) {
            sb.insert(indexList.get(j) + 11, "</font>");
            sb.insert(indexList.get(j), "<font color=#0271d2>");
        }
        return sb.toString();
    }


    /**
     * @param identityNo 身份证号
     * @return 0：非法身份证号 ，1：未满18岁 ，2：已满18岁
     */
    public static int isIdentityNo(String identityNo) {

        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        boolean matches = identityNo.matches(regularExpression);
        if (matches) {
            if (identityNo.length() == 18) {
                //当前时间信息
                Calendar calendar = Calendar.getInstance();
                int nYear = calendar.get(Calendar.YEAR);
                int nMonth = (calendar.get(Calendar.MONTH) + 1);
                int nDay = calendar.get(Calendar.DAY_OF_MONTH);
                //身份证信息
                String dateStr = identityNo.substring(6, 14);
                String yearStr = dateStr.substring(0, 4);
                String monthStr = dateStr.substring(4, 6);
                String dayStr = dateStr.substring(6, 8);
                int cYear = Integer.parseInt(yearStr);
                if (nYear - cYear > 18) {
                    // TODO: 2018/11/27   满18岁
                    return 2;
                } else if (nYear - cYear == 18) {
                    String resultDay = "";
                    String resultMonth = "";
                    if (nDay < 10) {
                        resultDay = "0" + nDay;
                    } else {
                        resultDay = "" + nDay;
                    }
                    if (nMonth < 10) {
                        resultMonth = "0" + nMonth;
                    } else {
                        resultMonth = "" + nMonth;
                    }
                    if ((resultMonth + resultDay).compareTo(monthStr + dayStr) >= 0) {
                        // TODO: 2018/11/27   满18岁
                        return 2;
                    } else {
                        return 1;
                    }
                }
                return 1;
            }
            return 2;
        }
        return 0;
    }


    /**
     * 检测是否有emoji表情
     *
     * @param source
     * @return
     */
    public static boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isEmojiCharacter(codePoint)) { //如果不能匹配,则该字符是Emoji表情
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是Emoji
     *
     * @param codePoint 比较的单个字符
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) ||
                (codePoint == 0xD) || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000)
                && (codePoint <= 0x10FFFF));
    }

    public static boolean isEmpty(String content) {
        if (TextUtils.isEmpty(content)) {
            return true;
        }
        if ("null".equals(content)) {
            return true;
        }
        return false;
    }


    public static String formatToString(String number, int tailCount, boolean isHalfUp, boolean isGroup) {
        if (isEmpty(number)) {
            return formatToString(BigDecimal.ZERO, tailCount, false, isHalfUp, isGroup);
        } else {
            try {
                BigDecimal num = new BigDecimal(number);
                return formatToString(num, tailCount, false, isHalfUp, isGroup);
            } catch (Exception e) {
                return formatToString(BigDecimal.ZERO, tailCount, false, isHalfUp, isGroup);
            }
        }
    }

    public static String formatToString(BigDecimal number, int tailCount, boolean isHalfUp, boolean isGroup) {
        return formatToString(number, tailCount, false, isHalfUp, isGroup);
    }

    public static String formatToString(BigDecimal number, int tailCount, boolean isExactTail, boolean isHalfUp, boolean isGroup) {
        DecimalFormat format = new DecimalFormat();
        if (isExactTail) {
            format.setMinimumFractionDigits(tailCount);
        }
        format.setMaximumFractionDigits(tailCount);
        if (isGroup) {
            format.setGroupingSize(3);
        }
        if (isHalfUp) {
            return format.format(number.setScale(tailCount, BigDecimal.ROUND_HALF_UP));
        } else {
            return format.format(number.setScale(tailCount, BigDecimal.ROUND_DOWN));
        }
    }
}
