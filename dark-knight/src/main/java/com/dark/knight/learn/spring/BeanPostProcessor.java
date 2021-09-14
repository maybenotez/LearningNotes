package com.dark.knight.learn.spring;

/**
 * Created by win on 2019/3/3 0003.
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean,String beanName)  throws Exception;

    Object postProcessAfterInitialization(Object bean,String beanName) throws Exception;
}
