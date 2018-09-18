import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {

    // 1天(d)=86400000毫秒(ms)
    public static final long ONE_DAY_MS = 86400000;


    /**
     * 获取本地系统时间
     */
    public static Date getLocalTime() {

        return  new Date(System.currentTimeMillis());
    }


    /**
     * 获取当前网络时间
     */
    public static String getNetTime() {
        try {
            URL url = new URL("http://www.baidu.com");
            URLConnection conn = url.openConnection();
            conn.connect();
            String time = conn.getDate() + "";
            return time;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * 更改日期的显示方式
     *
     * @version 0.0.1
     */
    public static String transDate(Date date, int type) {

        String formatDate = null;

        switch (type) {

            case 0: // 2016-7-6
                formatDate = DateFormat.getDateInstance().format(date);
                System.out.println("wyh DateUtil=>transDate==> " + formatDate);
                break;

            case 1: // 2016年7月6日 星期三
                formatDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);
                System.out.println("wyh DateUtil=>transDate==> " + formatDate);
                break;

            case 2: // 24小时制：2016-07-06 09:39:58
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                formatDate = format.format(date);
                System.out.println("wyh DateUtil=>transDate==> " + formatDate);
                break;

            case 3: // 2016-07-06 09:42:44
                DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                formatDate = format2.format(date);
                System.out.println("wyh DateUtil=>transDate==> " + formatDate);
                break;

            case 4: // 20160706094533
                DateFormat format3 = new SimpleDateFormat("yyyyMMddHHmmss");
                formatDate = format3.format(date);
                System.out.println("wyh DateUtil=>transDate==> " + formatDate);
                break;

            case 5: // 0830
                DateFormat format4 = new SimpleDateFormat("HHmm");
                formatDate = format4.format(date);
                System.out.println("wyh DateUtil=>transDate==> " + formatDate);
                break;

            case 6: // 201607060945
                DateFormat format5 = new SimpleDateFormat("yyyyMMddHHmm");
                formatDate = format5.format(date);
                System.out.println("wyh DateUtil=>transDate==> " + formatDate);
                break;
            case 7:
                DateFormat format6 = new SimpleDateFormat("MMdd_HHmm_yyyy");
                formatDate = format6.format(date);
                System.out.println("wyh DateUtil=>transDate==> " + formatDate);
                break;
        }

        if (null == formatDate) {
            return "";
        } else {
            return formatDate;
        }
    }

    /**
     * @desc 格式String型转成Date型：2016-07-06 10:17:48 -> Wed Jul 06 10:17:48 CST 2016
     *
     * @param dateStr 格式："2016-07-06 10:17:48"
     *
     * @version 0.0.1
     */
    public static Date str2Date(String dateStr) {
        SimpleDateFormat lsdStrFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = lsdStrFormat.parse(dateStr);
            System.out.println("wyh DateUtil=>str2Date==> " + date);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date str2Date2(String dateStr) {
        SimpleDateFormat lsdStrFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date date = lsdStrFormat.parse(dateStr);
            System.out.println("wyh DateUtil=>str2Date==> " + date);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }



    /**
     * convert time stamp to time string
     */
    public static String timeStamp2DateStr(long timeStamp, int type) {

        String dt = "";

        switch (type) {
            case 0:
                dt = new SimpleDateFormat("yyyyMMddHHmmss").format(timeStamp);
                break;

            case 1:
                dt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(timeStamp);
                break;
        }
        return dt;
    }


}
