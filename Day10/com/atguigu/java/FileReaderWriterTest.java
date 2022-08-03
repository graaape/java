package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/*
流的体系结构
抽象基类        节点流（或文件流）       缓冲流（处理流的一种）
InputStream     FileInputStream     BufferedInputStream
OutputStream    FileOutputStream    BufferedOutputStream
Reader          FileReader          BufferedReader
Writer          FileWriter          BufferedWriter

字符流不能处理图片文件的数据
 */
public class FileReaderWriterTest {
    /*
    将hello.txt的文件内容读入程序中，并输出到控制台
     */
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1.实例化File类对象，指明要操作的文件
            File file=new File("Day10/hello.txt");
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read()：返回读入的一个字符，如果到达文件末尾，返回-1
            //方式1：
//        int data=fr.read();
//        while (data!=-1){
//            System.out.print((char) data);
//            data=fr.read();
//        }
            //方式2：
            int data;
            while ((data= fr.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                //4.流的关闭操作
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //使用read的重载方法
    @Test
    public void testFileReader1(){
        FileReader fr= null;
        try {
            //1.File类的实例化
            File file=new File("Day10/hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            //read(char[]cbuf):返回每次读入cbuf数组中字符的个数，如果到达文件末尾，返回-1
            char[] cbuf=new char[5];
            int len;
            while ((len=fr.read(cbuf))!=-1){
                //方式1：
//                for (int i = 0; i <len ; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //方式2：
//                String str=new String(cbuf);错误的写法
                //正确写法
                String str=new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /*
    从内存中写出数据到硬盘的文件里
    说明：
    1.输出操作，对应的File可以不存在，在输出过程会自动创建此文件。
        如果存在，如果流使用的构造器是FileWriter（file，false）/FileWriter（file），则覆盖原有文件。
                如果使用的构造器是FileWriter（file，true），则添加到原有文件的末尾。
     */
    @Test
    public void testFileWriter() {
        FileWriter fw= null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file=new File("Day10/hello1.txt");
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);
            //3.写出的操作
            fw.write("I have a dream!\n");
            fw.write("You need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流资源的关闭
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    @Test
    public void testFileReaderWriter() {
        FileReader fr= null;
        FileWriter fw= null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile=new File("Day10/hello.txt");
            File destFile=new File("Day10/hello2.txt");
            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3.数据的读入和写出操作
            char[]cbuf=new char[5];
            int len;//记录每次读入到cbuf数组中的字符个数
            while ((len=fr.read(cbuf))!=-1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
