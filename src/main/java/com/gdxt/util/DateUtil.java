package com.gdxt.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author WangXin
 * @Date 2023/6/14 16:54
 */
public class DateUtil {

    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day = dateFormat.format(time);
        System.out.println(day);

        long distanceDays = DateUtil.getDistanceDays(day, "2023-06-12 24:00:00");
        System.out.println(distanceDays);

    }

    public static String getNowTime(){
        long time = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day = dateFormat.format(time);
        return day;
     }

    public static long getDistanceDays(String starttime, String endtime) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date one;
        Date two;
        long days=0;
        try {
            one = df.parse(starttime);
            two = df.parse(endtime);
            //当前时间
            long time1 = one.getTime();
            //过期时间
            long time2 = two.getTime();
            long diff ;
            diff = time2 - time1;
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;//返回相差多少天
    }

}
