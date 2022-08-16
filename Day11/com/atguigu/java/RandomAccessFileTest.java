package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/*
RandomAccessFile的使用
 */
public class RandomAccessFileTest {
    @Test
    public void test1(){
        RandomAccessFile raf1= null;
        RandomAccessFile raf2= null;
        try {
            raf1 = new RandomAccessFile(new File("Day10/kevin-mueller-UQ7Cdj5JY9Q-unsplash.jpg"),"r");
            raf2 = new RandomAccessFile(new File("Day11/pic.jpg"),"rw");
            byte[]buffer=new byte[1024];
            int len;
            while ((len=raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(raf2!=null){
                    raf2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(raf1!=null){
                    raf1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //如果作为输出流，如果写出到的文件存在，则默认从头覆盖原文件
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1=new RandomAccessFile(new File("Day11/hello.txt"),"rw");
        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("xyz".getBytes());
        raf1.close();
    }
    /*
    使用RandomAccessFile实现插入
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1=new RandomAccessFile(new File("Day11/hello.txt"),"rw");
        raf1.seek(3);//将指针调到角标为3的位置
        //保存指针3后的所有数据到StringBuilder中
        StringBuilder builder=new StringBuilder((int) new File("Day11/hello.txt").length());
        byte[]buffer=new byte[20];
        int len;
        while ((len= raf1.read(buffer))!=-1){
                builder.append(new String(buffer,0,len));
        }
        //调回指针,写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        //将StringBuilder中的数据写入文件
        raf1.write(builder.toString().getBytes());
        raf1.close();
    }
}
