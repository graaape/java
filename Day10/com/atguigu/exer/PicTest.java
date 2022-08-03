package com.atguigu.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicTest {
    //图片的加密
    @Test
    public void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("Day10/kevin-mueller-UQ7Cdj5JY9Q-unsplash.jpg");
            fos = new FileOutputStream("Day10/secret.jpg");
            byte[]buffer=new byte[20];
            int len;
            while ((len=fis.read(buffer))!=-1){
                for (int i = 0; i <len ; i++) {
                    buffer[i]=(byte) (buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //图片的解密
    @Test
    public void test2(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("Day10/secret.jpg");
            fos = new FileOutputStream("Day10/non-secret.jpg");
            byte[]buffer=new byte[20];
            int len;
            while ((len=fis.read(buffer))!=-1){
                for (int i = 0; i <len ; i++) {
                    buffer[i]=(byte) (buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
