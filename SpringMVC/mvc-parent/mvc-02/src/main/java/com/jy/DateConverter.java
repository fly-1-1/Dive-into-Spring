package com.jy;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        try {
            parse = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return parse;
    }
}
