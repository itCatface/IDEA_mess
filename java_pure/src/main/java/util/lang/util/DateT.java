package util.lang.util;

import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateT {

    public static final long ONE_DAY_MS = 86400000;     // 一个小时的毫秒数


    /*** 网络时间 ***/
    public static long netTimeStamp() {
        long result = 0L;

        try {
            URL url = new URL("http://www.baidu.com");
            URLConnection conn = url.openConnection();
            conn.connect();
            result = conn.getDate();
        } catch (Exception e) {
            System.out.println("[wyh]DateT-->netTimeStamp-->exception: " + e.toString());
        }

        return result;
    }


    /*** 格式化时间串 ***/
    public static String format(Object obj, String format) {
        String result = "";

        try {
            if (obj instanceof Date) {
                result = new SimpleDateFormat(format).format(obj);
            } else if (obj instanceof String) {
                result = new SimpleDateFormat(format).format(Long.parseLong(obj.toString()));
            } else if (obj instanceof Long) {
                result = new SimpleDateFormat(format).format(obj);
            }
        } catch (Exception e) {
            System.out.println("[wyh]DateT-->format-->exception: " + e.toString());
        }

        return result;
    }


    /*** 获取Date ***/
    public static Date date(String time) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        } catch (ParseException e) {
            System.out.println("[wyh]DateT-->date-->exception: " + e.toString());
            return new Date();
        }
    }


    /*** 年、月、日、时、分、秒 ***/
    public static int year(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int month(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int day(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int hour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int minute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    public static int second(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    public static long millis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }


    /*** 完整日期带(星期) ***/
    public static String whatDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        String weekStr = "";

        if (Calendar.SUNDAY == week) {
            weekStr = "周日";
        } else if (Calendar.MONDAY == week) {
            weekStr = "周一";
        } else if (Calendar.TUESDAY == week) {
            weekStr = "周二";
        } else if (Calendar.WEDNESDAY == week) {
            weekStr = "周三";
        } else if (Calendar.THURSDAY == week) {
            weekStr = "周四";
        } else if (Calendar.FRIDAY == week) {
            weekStr = "周五";
        } else if (Calendar.SATURDAY == week) {
            weekStr = "周六";
        }

        return year + "年" + month + "月" + day + "日" + "[" + weekStr + "]" + hour + "时" + minute + "分" + second + "秒";
    }


    /*** 刚刚, 几分钟前, 几小时前, 几天前... ***/
    public static String period(Date date) {
        /* 当前时间 */
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        int nowYear = now.get(Calendar.YEAR);
        int nowMonth = now.get(Calendar.MONTH);
        int nowWeek = now.get(Calendar.WEEK_OF_MONTH);
        int nowDay = now.get(Calendar.DAY_OF_WEEK);
        int nowHour = now.get(Calendar.HOUR_OF_DAY);
        int nowMinute = now.get(Calendar.MINUTE);

        /* 入参时间 */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(null == date ? new Date() : date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        /* 校验时间 */
        if (day == nowDay) {
            if (day + 2 == nowDay) return "前天" + new SimpleDateFormat("HH:mm:ss").format(date);
            if (day + 1 == nowDay) return "昨天" + new SimpleDateFormat("HH:mm:ss").format(date);

            int hourGap = nowHour - hour;
            if (hourGap == 0) {
                if (nowMinute - minute < 1) return "刚刚";
                else return (nowMinute - minute) + "分钟前";
            }
            if (hourGap >= 1 && hourGap <= 12) return hourGap + "小时前";
            else return new SimpleDateFormat("今天 HH:mm").format(date);
        }

        if (week == nowWeek) return new SimpleDateFormat("MM月dd日").format(date);
        if (month == nowMonth) return new SimpleDateFormat("MM月dd日").format(date);
        if (year == nowYear) return new SimpleDateFormat("yyyy-MM-dd").format(date);

        return new SimpleDateFormat("yyyy年MM月dd日").format(date);
    }
}
