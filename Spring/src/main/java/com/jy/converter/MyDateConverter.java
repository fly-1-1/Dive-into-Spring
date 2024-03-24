package com.jy.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateConverter implements Converter<String, Date> {


    /**
     * 转换
     * String -> Date
     */
    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = sdf.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return parse;
    }
}
