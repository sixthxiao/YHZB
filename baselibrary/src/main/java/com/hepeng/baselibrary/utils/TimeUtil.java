package com.hepeng.baselibrary.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtil {

    /**
     * 获取当前时间的字符串
     *
     * @return yyyyMMddHHmmss格式的字符串
     */
    public static String getCurrentTime() {
        Date now = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
        dateformat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        String sDateTime = dateformat.format(now);
        return sDateTime;
    }

    //时间戳转为时间格式
    public static String formattimestamp(String format, String timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);//"yyyy年MM月dd日HH时mm分ss秒"
        long lcc_time = Long.valueOf(timestamp);
        return sdf.format(new Date(lcc_time * 1000L));
    }

    //时间格式转为时间戳
    public static String formattime(String format, String time) {
        String timestamp = "0";
        SimpleDateFormat sdf = new SimpleDateFormat(format);//"yyyy年MM月dd日HH时mm分ss秒"
        Date date;
        try {
            date = sdf.parse(time);
            long l = date.getTime();
            String str = String.valueOf(l);
            timestamp = String.valueOf(Long.parseLong(str) / 1000);
        } catch (ParseException e) {
//            ToastUtil.showToast("时间转换错误");
        }
        return timestamp;
    }

    /**
     * 毫秒转换成hh:mm:ss格式
     *
     * @param timeMs 毫秒
     * @return
     */
    public static String stringForTime(long timeMs) {
        if (timeMs <= 0 || timeMs >= 24 * 60 * 60 * 1000) {
            return "00:00";
        }
        int totalSeconds = (int) (timeMs / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        StringBuilder stringBuilder = new StringBuilder();
        Formatter mFormatter = new Formatter(stringBuilder, Locale.getDefault());
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

    public static String stringForTime1(long timeMs) {
//        if (timeMs <= 0 || timeMs >= 24 * 60 * 60 * 1000) {
//            return "00:00";
//        }
        int totalSeconds = (int) (timeMs / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        StringBuilder stringBuilder = new StringBuilder();
        Formatter mFormatter = new Formatter(stringBuilder, Locale.getDefault());
        if (hours > 0) {
            return mFormatter.format("%d小时%02d分%02d秒", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d分%02d秒", minutes, seconds).toString();
        }
    }

    //时间的显示方式为：刚刚（1分钟内）、n分钟前（1小时内）、n小时前（5小时内）、hh:mm（每天24点前）、yy.mm.dd（其余时间）
    public static String FormatTime(long Currentime, long time) {
        if (time == 0) {
            time = System.currentTimeMillis();
        }
        String timeText;
        long diff = Currentime - time;
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
                * (1000 * 60 * 60))
                / (1000 * 60);
        if (isSameDay(time, Currentime)) {
            if (hours >= 5) {
                timeText = formattimestamp("HH:mm", String.valueOf(time));
            } else if (hours >= 1) {
                timeText = hours + "小时前";
            } else if (minutes >= 1) {
                timeText = minutes + "分钟前";
            } else
                timeText = "刚刚";
        } else
            timeText = formattimestamp(" MM-dd HH:mm", String.valueOf(time / 1000));
        return timeText;
    }

    public static final long MILLIS_IN_DAY = 1000L * 60 * 60 * 24;

    /**
     * 判断两个毫秒数是否为同一天
     */
    public static boolean isSameDay(long beforeTime, long afterTime) {
        long time = beforeTime - afterTime;
        time = Math.abs(time);
        return time < MILLIS_IN_DAY && toDay(beforeTime) == toDay(afterTime);
    }

    private static long toDay(long millis) {
        return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
    }

    public static String getNewChatTime(long timesamp) {
        String result = "";
        Calendar todayCalendar = Calendar.getInstance();
        Calendar otherCalendar = Calendar.getInstance();
        otherCalendar.setTimeInMillis(timesamp);

        String timeFormat = "MM-d HH:mm";
        String yearTimeFormat = "yyyy-M-d HH:mm";
        String am_pm = "";
        int hour = otherCalendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= 0 && hour <= 12) {
            am_pm = "上午";
        } else if (hour > 12) {
            am_pm = "下午";
        }
        boolean yearTemp = todayCalendar.get(Calendar.YEAR) == otherCalendar.get(Calendar.YEAR);
        if (yearTemp) {
            int todayMonth = todayCalendar.get(Calendar.MONTH);
            int otherMonth = otherCalendar.get(Calendar.MONTH);
            if (todayMonth == otherMonth) {//表示是同一个月
                int temp = todayCalendar.get(Calendar.DATE) - otherCalendar.get(Calendar.DATE);
                switch (temp) {
                    case 0:
                        result = formattimestamp(am_pm + " HH:mm", String.valueOf(timesamp / 1000));//同一天
                        break;
                    case 1:
                        result = formattimestamp("昨天 HH:mm", String.valueOf(timesamp / 1000));//昨天
                        break;
                    default:
                        result = formattimestamp(timeFormat, String.valueOf(timesamp / 1000));//昨天以前
                        break;
                }
            } else {
                result = formattimestamp(timeFormat, String.valueOf(timesamp / 1000));//不同月
            }
        } else {
            result = formattimestamp(yearTimeFormat, String.valueOf(timesamp / 1000));//不同年
        }
        return result;
    }
}
