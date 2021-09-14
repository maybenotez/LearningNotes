package com.dark.knight.learn.spring.xml;

import com.dark.knight.learn.spring.bean.BeanDefinition;
import com.dark.knight.learn.spring.io.Resource;
import com.dark.knight.learn.spring.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * create by sheng.yang
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private  Map<String,BeanDefinition> registry ;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader =resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public void setRegistry(Map<String, BeanDefinition> registry) {
        this.registry = registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public void setResource(Resource resource) {
        this.resourceLoader = resourceLoader;
    }
}
