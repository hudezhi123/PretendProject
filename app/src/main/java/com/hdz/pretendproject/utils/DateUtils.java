package com.hdz.pretendproject.utils;

import android.app.AlarmManager;
import android.content.Context;
import android.provider.Settings;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by hdz
 * on 2018/11/13
 */
public class DateUtils {


    public static final int YYYY_MM_DD_T_HH_MM_SS_SSS = 1;
    public static final int YYYY_MM_DD_T_HH_MM_SS = 2;
    public static final int YYYY_MM_DD_HH_MM_SS_SSS = 3;
    public static final int YYYY_MM_DD_HH_MM_SS = 4;
    public static final int YYYY_MM_DD_HH_MM = 5;
    public static final int YYYY_MM_DD = 6;
    public static final int HH_MM_SS = 7;
    public static final int HH_MM = 8;

//    //将时间格式化为yyyy-MM-dd HH:mm:ss
//    public static String formatDate(String dateStr) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        ParsePosition pop = new ParsePosition(0);
//        Date date = format.parse(dateStr, pop);
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return f.format(date);
//    }

    //
    public static String formatDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pop = new ParsePosition(0);
        Date date = format.parse(dateStr, pop);
        SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
        return f.format(date);
    }

    public static String formatDate(String dateStr, float no) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pop = new ParsePosition(0);
        Date date = format.parse(dateStr, pop);
        SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return f.format(date);
    }

    /**
     * 中文
     *
     * @param times
     * @return
     */
    public static String formatDateZ(long times) {
        Date date = new Date(times);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return format.format(date);
    }

    public static String formatDate(long times, int flag) {
        Date date = new Date(times);
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日 HH:mm:ss");
        return format.format(date);
    }

    /**
     * @param times
     * @return
     */
    public static String formatDateH(long times) {
        Date date = new Date(times);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static String formatDate(long time, String flag) {
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(date);
    }

    public static String formatDateH(long times, int flag) {
        Date date = new Date(times);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }


    public static String formatDateH_M_S(long times) {
        Date date = new Date(times);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(date);
    }


    public static String formatDate(String str, int flag) {
        if (str.contains("T")) {
            str = str.replace("T", " ");
        }
        if (str.contains("-") && (flag == HH_MM_SS || flag == HH_MM)) {
            String[] date_time = new String[2];
            date_time = str.split(" ");
            str = date_time[1];
        }
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(parsePattern(flag));
        ParsePosition pop = new ParsePosition(0);
        Date date = format.parse(str, pop);
        return format.format(date);
    }

    public static long getLongTime(String str, int flag) {
        if (str.contains("T")) {
            str = str.replace("T", " ");
        }
        if (str.contains("-") && (flag == HH_MM_SS || flag == HH_MM)) {
            String[] date_time = new String[2];
            date_time = str.split(" ");
            str = date_time[1];
        }
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(parsePattern(flag));
        ParsePosition pop = new ParsePosition(0);
        Date date = format.parse(str, pop);
        return date.getTime();
    }


    private static String parsePattern(int flag) {
        switch (flag) {
            case YYYY_MM_DD_T_HH_MM_SS_SSS:
                return "yyyy-MM-dd'T'HH:mm:ss.SSS";
            case YYYY_MM_DD_T_HH_MM_SS:
                return "yyyy-MM-dd'T'HH:mm:ss";

            case YYYY_MM_DD_HH_MM_SS_SSS:
                return "yyyy-MM-dd HH:mm:ss.SSS";

            case YYYY_MM_DD_HH_MM_SS:
                return "yyyy-MM-dd HH:mm:ss";

            case YYYY_MM_DD_HH_MM:
                return "yyyy-MM-dd HH:mm";

            case YYYY_MM_DD:
                return "yyyy-MM-dd";

            case HH_MM_SS:
                return "HH:mm:ss";

            case HH_MM:
                return "HH:mm";
            default:
                return "yyyy-MM-dd HH:mm:ss";
        }
    }

    public static boolean isTimeZoneAuto(Context mContext) {
        try {
            return Settings.Global.getInt(mContext.getContentResolver(),
                    Settings.Global.AUTO_TIME_ZONE) > 0;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setAutoTimeZone(Context mContext, int checked) {
        Settings.Global.putInt(mContext.getContentResolver(),
                Settings.Global.AUTO_TIME_ZONE, checked);
    }


    public static void setChinaTimeZone(Context context) {
        AlarmManager mAlarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        mAlarmManager.setTimeZone("Asia/Shanghai");// Asia/Taipei//GMT+08:00
    }

}
