package com.dark.knight.learn.spring.xml;

import com.dark.knight.learn.spring.bean.BeanDefinition;
import com.dark.knight.learn.spring.bean.BeanReference;
import com.dark.knight.learn.spring.bean.PropertyValue;
import com.dark.knight.learn.spring.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * create by sheng.yang
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

    public XmlBeanDefinitionReader(ResourceLoader resource) {
        super(resource);
    }

    @Override
    public void loadBeanDefinition(String location) throws Exception {
       InputStream inputStream  =  getResourceLoader().getResource(location).getInputStream();
        Document document = this.getDocument(inputStream);
        parseNode(document);
        inputStream.close();
    }
    private Document getDocument(InputStream inputStream) throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document parse = documentBuilder.parse(inputStream);
        return parse;
    }
    private void parseNode(Document document){
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i=0;i<childNodes.getLength();i++){
            Node item = childNodes.item(i);
            if (item instanceof Element){
                Element ele = (Element) item;
                String name = ele.getAttribute("name");
                String className = ele.getAttribute("class");
                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setBeanClassName(className);
                parseProperty(ele,beanDefinition);
                getRegistry().put(name,beanDefinition);
            }
        }
    }

    private void parseProperty(Element element,BeanDefinition beanDefinition){
        NodeList property = element.getElementsByTagName("property");
        for (int i=0;i<property.getLength();i++){
            Node item = property.item(i);
            if (item instanceof Element ){
                Element ele = (Element) item;
                String name = ele.getAttribute("name");
                String value = ele.getAttribute("value");
                if (value != null && value.length()>0){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                }else{
                    value = ele.getAttribute("ref");
                    if (value == null || value.length()==0){
                        throw new IllegalArgumentException("");
                    }
                    BeanReference beanReference = new BeanReference(value);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,beanReference));
                }
            }
        }
    }
}
