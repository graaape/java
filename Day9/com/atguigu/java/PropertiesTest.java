package com.atguigu.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    //Properties常用来处理配置文件，key和value都是String类型
    public static void main(String[] args) throws IOException {
        Properties pros=new Properties();
        FileInputStream fis=new FileInputStream("jbdc.properties");
        pros.load(fis);
        String name=pros.getProperty("name");
        String password= pros.getProperty("password");
        System.out.println("name="+name+",password="+password);
        fis.close();
    }
}
