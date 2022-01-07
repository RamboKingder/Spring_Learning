package com.lxl.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 把String转成Date的类型转换器
public class DateConverter implements Converter<String, Date> {
    @Override
    // 在这个方法中要把字符串转换成真正的Date并返回
    public Date convert(String dateStr) {
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
