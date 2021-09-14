package com.dark.knight.learn.spring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * create by sheng.yang
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
