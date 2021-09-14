package com.dark.knight.learn.spring.bean;

/**
 * create by sheng.yang
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public PropertyValue(String name, Object value) {

        this.name = name;
        this.value = value;
    }
}
