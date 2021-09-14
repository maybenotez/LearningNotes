package com.dark.knight.learn.spring.factory;

/**
 *
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;
}
