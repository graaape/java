package com.atguigu.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
IP和端口号
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1=InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);
            InetAddress inet2=InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);
            InetAddress inet3=InetAddress.getByName("localhost");
            System.out.println(inet3);
            //获取本地IP
            InetAddress inet4=InetAddress.getLocalHost();
            System.out.println(inet4);
            //getHostName()
            System.out.println(inet2.getHostName());
            //getHostAddress()
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
