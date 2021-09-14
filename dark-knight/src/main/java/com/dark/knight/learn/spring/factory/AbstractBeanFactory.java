package com.dark.knight.learn.spring.factory;

import com.dark.knight.learn.spring.BeanPostProcessor;
import com.dark.knight.learn.spring.bean.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by sheng.yang
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private final Map<String,BeanDefinition>  beanDefinitionMap = new ConcurrentHashMap<>();
    private final List<String>  beanDefinitionNames = new ArrayList<>();

    private List<BeanPostProcessor> beanPostProcessors =new ArrayList<>();
    @Override
    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null){
            throw new RuntimeException("no bean name ["+beanName+"]");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null){
            bean =  doCreateBean(beanDefinition);
            bean = initializeBean(bean,beanName);
        }
        return bean;
    }
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;


    public void registryBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name,beanDefinition);
        beanDefinitionNames.add(name);
    }

    protected Object initializeBean(Object bean, String name) throws Exception {
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
             bean = beanPostProcessor.postProcessBeforeInitialization(bean,name);
        }
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean,name);
        }
        return bean;
    }
    /**
     * 恶汉式初始化
     * @throws Exception
     */
    public void preInitialBeanDefinition() throws Exception {
        for (Iterator it =beanDefinitionNames.iterator();it.hasNext();){
            String next = (String) it.next();
            getBean(next);
        }
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor)throws Exception{
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<Object> getBeansForType(Class<?> type)throws Exception {
        List<Object> list = new ArrayList();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                list.add(getBean(beanDefinitionName));
            }
        }
        return list;
    }
}
