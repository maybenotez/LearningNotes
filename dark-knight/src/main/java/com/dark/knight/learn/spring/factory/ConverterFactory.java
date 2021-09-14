package com.dark.knight.learn.spring.factory;

import com.dark.knight.learn.spring.convert.Converter;
import com.dark.knight.learn.spring.convert.StringToIntConverter;
import com.dark.knight.learn.spring.convert.StringToStringConverter;

import java.util.HashMap;
import java.util.Map;

public class ConverterFactory {



    private Map<String, Converter<?,?>> map = new HashMap<>();

    private Converter<String,String> defaultConvert = new StringToStringConverter();

    public ConverterFactory(){
        StringToIntConverter stringToIntConverter = new StringToIntConverter();
        map.put(String.class.getName() + "_" + Integer.class.getName(), stringToIntConverter);
        map.put(String.class.getName() + "_" + int.class.getName(), stringToIntConverter);
    }

    public Converter getConvert(Class<?> sourceClazz,Class<?> targetClazz){
        String sourceClassName = sourceClazz.getName();
        String targetClassName = targetClazz.getName();
        Converter<?,?> converter = map.get(sourceClassName + "_" + targetClassName);
        if (converter == null) {
            return defaultConvert;
        }
        return converter;
    }

}
