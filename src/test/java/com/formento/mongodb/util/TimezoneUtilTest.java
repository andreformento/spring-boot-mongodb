package com.formento.mongodb.util;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TimezoneUtilTest {

    @Test
    public void sholdChangeTimezoneToUTC() {
        // given
        Date now = LocalDateTimeUtil.toDate(LocalDateTimeUtil.fromText("2016-05-30 14:40:55"));
        Date utcDateAssert = LocalDateTimeUtil.toDate(LocalDateTimeUtil.fromText("2016-05-30 17:40:55"));

        // when
        Date utcDate = TimezoneUtil.changeTimezoneToUTC(now);

        // then
        assertEquals(utcDateAssert, utcDate);
    }

}