package com.atguigu.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test1(){
        //创建Person0类的对象
        Person0 p1=new Person0("Tom",12);
        //通过对象调用内部的属性、方法
        p1.age=10;
        System.out.println(p1.toString());
        p1.show();
    }
    @Test
    public void test2() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        //通过反射创建对象
        Class cla=Person0.class;
        Constructor cons=cla.getConstructor(String.class,int.class);
        Object obj=cons.newInstance("Tom",12);
        Person0 p=(Person0)obj;
        System.out.println(p.toString());
        //通过反射调用属性、方法
        Field age=cla.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        Method show = cla.getDeclaredMethod("show");
        show.invoke(p);
        System.out.println("====================");
        //通过反射可以调用类的私有结构
        Constructor cons1 = cla.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person0 p1=(Person0) cons1.newInstance("Jerry");
        System.out.println(p1);
        Field name = cla.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);
        Method showNation = cla.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        System.out.println(showNation.invoke(p1,"CN"));
    }
    //获取Class的实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式1：调用运行时类的属性：.class
        Class<Person0>cla1=Person0.class;
        System.out.println(cla1);
        //方式2：通过运行时的对象
        Person0 p1=new Person0();
        Class cla2=p1.getClass();
        System.out.println(cla2);
        //方式3：调用Class的静态方法：forName（String classPath）
        Class cla3 = Class.forName("com.atguigu.java.Person0");
        System.out.println(cla3);
        System.out.println(cla1==cla2);
        System.out.println(cla1==cla3);
        //方式4：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class cla4 = classLoader.loadClass("com.atguigu.java.Person0");
        System.out.println(cla4);
        System.out.println(cla1==cla4);
    }
    @Test
    public void test4(){
        Class c1=Object.class;
        Class c2=Comparable.class;
        Class c3=String[].class;
        Class c4=int[][].class;
        Class c5= ElementType.class;
        Class c6=Override.class;
        Class c7=int.class;
        Class c8=void.class;
        Class c9=Class.class;
        int[]a=new int[10];
        int[]b=new int[100];
        //只要元素类型和维度应用，就是一个Class
        Class c10=a.getClass();
        Class c11=b.getClass();
        System.out.println(c10==c11);
    }
}
