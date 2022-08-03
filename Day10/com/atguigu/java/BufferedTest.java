package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/*
处理流之一，缓冲流的使用
1.缓冲流：
BufferedInputStream
BufferedOutputStream
BufferedReader
BufferedWriter
2.作用：提高流读取、写入的速度
   原因：内部提供了一个缓冲区。
3.处理流就是“套接”在已有的流的基础上。
 */
public class BufferedTest {
    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            //1.造文件
            File srcFile=new File("Day10/kevin-mueller-UQ7Cdj5JY9Q-unsplash.jpg");
            File destFile=new File("Day10/2.jpg");
            //2.造流
            //2.1造节点流
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.读取写入
            byte[]buffer=new byte[10];
            int len;
            while ((len= bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if(bos!=null){
                    bos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis!=null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //说明：关闭外层流的同时，内层流也会自动地关闭，内层流的关闭可以省略
//        fos.close();
//        fis.close();
    }
    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            //1.造文件
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);
            //2.造流
            //2.1造节点流
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.读取写入
            byte[]buffer=new byte[10];
            int len;
            while ((len= bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
                //bos.flush();刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if(bos!=null){
                    bos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis!=null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testCopyFileWithBuffered(){
        long start=System.currentTimeMillis();
        String srcPath="Day10/kevin-mueller-UQ7Cdj5JY9Q-unsplash.jpg";
        String destPath="Day10/2.jpg";
        copyFileWithBuffered(srcPath,destPath);
        long end=System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+(end-start));
    }
    //使用BufferedReader和BufferedWriter实现文本文件的复制
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br= null;
        BufferedWriter bw= null;
        try {
            //创建文件和流
            br = new BufferedReader(new FileReader(new File("Day10/dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("Day10/dbcp1.txt")));
            //读写操作
            //方式1：使用char[]数组
//            char[]cbuf=new char[1024];
//            int len;
//            while ((len= br.read(cbuf))!=-1){
//                bw.write(cbuf,0,len);
//            }
            //方式2：使用String
            String data;
            while ((data=br.readLine())!=null){
                //方法1：
                //bw.write(data+"\n");//data中不包含换行符
                //方法2：
                bw.write(data);
                bw.newLine();//换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
