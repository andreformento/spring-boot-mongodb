package com.formento.mongodb.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeUtil {

    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(LocalDateUtil.DATE_PATTERN + " HH:mm:ss");


    public static LocalDateTime fromText(String text) {
        return LocalDateTime.parse(text, FORMATTER);
    }

    public static String format(LocalDateTime localDateTime) {
        return localDateTime.format(FORMATTER);
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Long toLong(LocalDateTime localDateTime) {
        return toDate(localDateTime).getTime();
    }

    public static LocalDateTime fromDate(Date date) {
        return fromDate(date, ZoneId.systemDefault());
    }

    public static LocalDateTime fromDate(Date date, ZoneId zoneId) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    public static LocalDateTime fromLong(Long longDate) {
        return fromDate(new Date(longDate));
    }

}