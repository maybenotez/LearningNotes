package com.dark.knight.learn.spring.convert;

public class StringToStringConverter implements Converter<String,String>{

    @Override
    public String convert(String value) {
        return value;
    }
}
