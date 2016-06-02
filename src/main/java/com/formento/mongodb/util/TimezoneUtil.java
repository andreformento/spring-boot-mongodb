package com.formento.mongodb.util;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class TimezoneUtil {

    public static Date changeTimezoneToUTC(Date dateToChange) {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        TimeZone gmt = TimeZone.getTimeZone("GMT");

        LocalDateTime localDateTimeGmt = LocalDateTimeUtil.fromDate(dateToChange, gmt.toZoneId());
        ZonedDateTime zonedDateTimeUtc = localDateTimeGmt.atZone(utc.toZoneId());

        return LocalDateTimeUtil.toDate(zonedDateTimeUtc.toLocalDateTime());
    }

}
