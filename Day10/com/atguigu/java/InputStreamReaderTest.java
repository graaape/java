package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/*
转换流:属于字符流
 */
public class InputStreamReaderTest {
    //实现字节的输入流到字符的输入流的转换
    @Test
    public void test1(){
        FileInputStream fis= null;
        try {
            fis = new FileInputStream("Day10/dbcp.txt");
            //InputStreamReader isr=new InputStreamReader(fis);//使用系统默认的字符集
            //参数2指明了字符集
            InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
            char[]cbuf=new char[20];
            int len;
            while ((len= isr.read(cbuf))!=-1){
                String str=new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    综合使用InputStreamReader和OutputStreamWriter
     */
    @Test
    public void test2(){
        InputStreamReader isr= null;
        OutputStreamWriter osw= null;
        try {
            File file1=new File("Day10/dbcp.txt");
            File file2=new File("Day10/dbcp_gbk.txt");
            FileInputStream fis=new FileInputStream(file1);
            FileOutputStream fos=new FileOutputStream(file2);
            isr = new InputStreamReader(fis,"UTF-8");
            osw = new OutputStreamWriter(fos,"gbk");
            char[]cbuf=new char[20];
            int len;
            while ((len= isr.read(cbuf))!=-1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(osw!=null){
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(isr!=null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
