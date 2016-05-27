package com.formento.mongodb.util.converter;


import com.formento.mongodb.util.LocalDateUtil;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class LocalDateConverter implements Converter<LocalDate, String> {

    @Override
    public String convert(LocalDate localDate) {
        return LocalDateUtil.format(localDate);
    }


//    @Override
//    public Date convertToDatabaseColumn(LocalDate date) {
//        return date == null ? null : LocalDateUtil.toDate(date);
//    }
//
//    @Override
//    public LocalDate convertToEntityAttribute(Date value) {
//        return value == null ? null : LocalDateUtil.asLocalDate(value);
//    }
}
