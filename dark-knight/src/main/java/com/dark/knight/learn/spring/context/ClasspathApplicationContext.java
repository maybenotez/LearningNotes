package com.dark.knight.learn.spring.context;

import com.dark.knight.learn.spring.bean.BeanDefinition;
import com.dark.knight.learn.spring.factory.AbstractBeanFactory;
import com.dark.knight.learn.spring.factory.AutoWiredCapableBeanFactory;
import com.dark.knight.learn.spring.io.ResourceLoader;
import com.dark.knight.learn.spring.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 *
 */
public class ClasspathApplicationContext extends AbstractApplicationContext {

    private String location;

    public ClasspathApplicationContext(String  location) throws Exception {
       this(location,new AutoWiredCapableBeanFactory());
    }

    public ClasspathApplicationContext(String location,AbstractBeanFactory beanFactory) throws Exception {
            super(beanFactory);
            this.location = location;
            refresh();
    }

    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition(location);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registryBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
