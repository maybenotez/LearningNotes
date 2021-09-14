package com.dark.knight.learn;

import com.dark.knight.learn.spring.context.ApplicationContext;
import com.dark.knight.learn.spring.context.ClasspathApplicationContext;
import com.dark.knight.learn.spring.test.Model;

public class App {


    public static void main(String[] args) throws Exception {


        ApplicationContext context = new ClasspathApplicationContext("application-context.xml");

        Model model = (Model) context.getBean("model");

        System.out.println(model.getName());

        System.out.println(model.getLazy());
    }
}
