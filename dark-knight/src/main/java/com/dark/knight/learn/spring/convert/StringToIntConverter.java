package com.dark.knight.learn.spring.convert;

public class StringToIntConverter implements Converter<String,Integer>{



    @Override
    public Integer convert(String value) {
        if (value == null) {
            return 0;
        }
        return Integer.parseInt(value);
    }
}
