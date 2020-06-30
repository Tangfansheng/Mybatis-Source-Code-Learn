package com.ordo.mybatis.io;

import java.io.InputStream;

public class Resources {
    public static InputStream getResourceAsStream(String filename){
        return Resources.class.getClassLoader().getResourceAsStream(filename);
    }
}
