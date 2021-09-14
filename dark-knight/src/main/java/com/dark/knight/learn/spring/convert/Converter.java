package com.dark.knight.learn.spring.convert;

public interface Converter<D,R> {


    R convert(D value);

}

