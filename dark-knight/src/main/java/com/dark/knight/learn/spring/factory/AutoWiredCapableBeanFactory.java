package com.dark.knight.learn.spring.factory;

import com.dark.knight.learn.spring.bean.BeanDefinition;
import com.dark.knight.learn.spring.bean.BeanReference;
import com.dark.knight.learn.spring.bean.PropertyValue;
import com.dark.knight.learn.spring.convert.Converter;

import java.lang.reflect.Field;

/**
 * create by sheng.yang
 */
public class AutoWiredCapableBeanFactory extends AbstractBeanFactory {

    private ConverterFactory converterFactory = new ConverterFactory();

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = doCreateInstance(beanDefinition);
        beanDefinition.setBean(bean);
        setPropertyValues(bean,beanDefinition);
        return bean;
    }
    protected Object doCreateInstance(BeanDefinition beanDefinition) throws Exception{
        Object obj = beanDefinition.getBeanClass().newInstance();
        return obj;
    }
    protected void setPropertyValues(Object bean,BeanDefinition beanDefinition) throws Exception{
        for (PropertyValue value:beanDefinition.getPropertyValues().getPropertyValueList()){
            Field declaredField = bean.getClass().getDeclaredField(value.getName());
            Object beanValue = value.getValue();
            declaredField.setAccessible(true);
            if (beanValue instanceof BeanReference){
                    BeanReference ref = (BeanReference) beanValue;
                String name = ref.getName();
                beanValue = getBean(name);
                declaredField.set(bean,beanValue);
            }else{
                Class<?> type = declaredField.getType();
                Converter convert = converterFactory.getConvert(beanValue.getClass(),type);

                declaredField.set(bean,convert.convert(beanValue));
            }

        }
    }
}
