package com.dark.knight.learn.spring.io;

import java.net.URL;

/**
 *
 */
public class ResourceLoader  {

    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
