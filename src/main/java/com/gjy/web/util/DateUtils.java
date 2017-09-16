package com.gjy.web.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by gaojiajia on 2017/8/13.
 */
public final class DateUtils {

    /**
     * yyyy-MM-dd HH:mm:ss格式
     */
    public static final String PATTERN_DAY = "yyyy-MM-dd HH:mm:ss";

    private DateUtils (){

    }

    /**
     * 时间格式字符串转Date
     * @param date
     * @param pattern
     * @return
     */
    public static Date strToDate(String date, String pattern){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        return localDateTimeToDate(dateTime);
    }

    /**
     * localDateTTime转Date
     * @param localDateTime
     * @return
     */
    private static Date localDateTimeToDate(LocalDateTime localDateTime){

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static void main(String[] args) {


    }
}
