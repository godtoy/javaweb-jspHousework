package com.zhaojunlike.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaojun on 2016/6/29.
 */
public class DateUtil {

    public static String timeSToDateStr(int times) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ii:ss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(times * 1000))));
        return sd;
    }
}
