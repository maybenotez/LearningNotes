package com.dark.knight.learn.spring.bean;


import java.util.ArrayList;
import java.util.List;

/**
 * create by sheng.yang
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public List<PropertyValue> getPropertyValueList(){
        return propertyValueList;
    }
    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }
}
