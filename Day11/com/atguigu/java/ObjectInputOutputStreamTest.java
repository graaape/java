package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/*
对象流的使用
 */
public class ObjectInputOutputStreamTest {
    //序列化
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Day11/object.dat"));
            oos.writeObject(new String("abcdefg"));
            oos.flush();
            oos.writeObject(new Person1("小明",12));
            oos.flush();
            oos.writeObject(new Person1("小王",23,1001,new Account(5000)));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //反序列化
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Day11/object.dat"));
            Object obj=ois.readObject();
            String str=(String)obj;
            obj=ois.readObject();
            Person1 p=(Person1) obj;
            obj=ois.readObject();
            Person1 p1=(Person1)obj;
            System.out.println(str);
            System.out.println(p);
            System.out.println(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ois!=null){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
