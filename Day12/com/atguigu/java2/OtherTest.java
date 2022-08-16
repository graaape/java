package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    /*
    获取构造器结构
     */
    @Test
    public void test1() throws NoSuchMethodException {
        Class cla= Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = cla.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中所有的构造器
        Constructor[] declaredConstructors = cla.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }
    /*
    获取运行时类的父类
     */
    @Test
    public void test2(){
        Class cla= Person.class;
        Class superclass = cla.getSuperclass();
        System.out.println(superclass.getName());
    }
    /*
   获取运行时类的带泛型的父类
    */
    @Test
    public void test3(){
        Class cla= Person.class;
        Type genericSuperclass = cla.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
    /*
   获取运行时类的带泛型的父类的泛型
    */
    @Test
    public void test4(){
        Class cla= Person.class;
        Type genericSuperclass = cla.getGenericSuperclass();
        ParameterizedType parameterizedType=(ParameterizedType)genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        //System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }
    /*
    获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class cla= Person.class;
        Class[] interfaces = cla.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }
        System.out.println();
        //获取运行时类父类的接口
        Class[] interfaces1 = cla.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
        }
    }
    /*
    获取运行时类所在的包
     */
    @Test
    public void test6(){
        Class cla= Person.class;
        Package p = cla.getPackage();
        System.out.println(p);
    }
    /*
    获取运行时类声明的注解
     */
    @Test
    public void test7(){
        Class cla= Person.class;
        Annotation[] annotations = cla.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
