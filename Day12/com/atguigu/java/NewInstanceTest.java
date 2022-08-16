package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/*
通过反射创建对应的运行时类的对象
 */
public class NewInstanceTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person0> cla=Person0.class;
        /*
        newInstance():调用此方法，创建对应的运行时类的对象，内部调用的是运行时类的空参构造器
        要提供空参的构造器，且要有空参构造器的访问权限
         */
        Person0 obj = cla.newInstance();
        System.out.println(obj);
    }
    //反射的动态性
    @Test
    public void test2(){
        for (int i = 0; i < 100; i++) {
            int num=new Random().nextInt(3);//0,1,2
            String classPath="";
            switch (num){
                case 0:
                    classPath="java.util.Date";
                    break;
                case 1:
                    classPath="java.lang.Object";
                    break;
                case 2:
                    classPath="com.atguigu.java.Person0";
                    break;
            }
            Object obj = null;
            try {
                obj = getInstance(classPath);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(obj);
        }

    }
    /*
    此方法创建一个指定类的对象
    classPath：指定类的全类名
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class cla=Class.forName(classPath);
        return cla.newInstance();
    }
}
