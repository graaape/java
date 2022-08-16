package com.atguigu.java1;

import java.net.MalformedURLException;
import java.net.URL;

/*
URL网络编程
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url=new URL("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
            System.out.println(url.getProtocol());//获取该URL的协议名
            System.out.println(url.getHost());//获取该URL的主机名
            System.out.println(url.getPort());//获取该URL的端口号
            System.out.println(url.getPath());//获取该URL的文件路径
            System.out.println(url.getFile());//获取该URL的文件名
            System.out.println(url.getQuery());//获取该URL的查询名

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
