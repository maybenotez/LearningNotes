package com.dark.knight.learn.spring.context;


import com.dark.knight.learn.spring.BeanPostProcessor;
import com.dark.knight.learn.spring.factory.AbstractBeanFactory;

import java.util.List;

/**
 *
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }

    public void refresh() throws Exception{
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    //todo
    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    protected void onRefresh() throws Exception{
        beanFactory.preInitialBeanDefinition();
    }

    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
        List<Object> beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }
}
