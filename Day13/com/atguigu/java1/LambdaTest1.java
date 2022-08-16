package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest1 {
    //无参无返回值
    @Test
    public void test1(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("122312");
            }
        };
        r1.run();
        System.out.println("====================");
        //Lambda表达式
        Runnable r2=()->System.out.println("abcd");
        r2.run();
    }
    //Lambda需要一个参数，没有返回值
    @Test
    public void test2(){
        Consumer<String>con=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("abc");
        System.out.println("========================");
        Consumer<String>con1=(String s)->{
            System.out.println(s);
        };
        con1.accept("123");
    }
    //数据类型可以省略，因为可以由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String>con1=(String s)->{
            System.out.println(s);
        };
        con1.accept("123");
        System.out.println("========================");
        Consumer<String>con2=(s)->{
            System.out.println(s);
        };
        con2.accept("123");
    }
    @Test
    public void test4(){
        //类型推断
        ArrayList<String>list=new ArrayList<>();
        int[]arr={1,2,3};
    }
    //若只需要一个参数，参数的小括号可以省略
    @Test
    public void test5(){
        Consumer<String>con2=(s)->{
            System.out.println(s);
        };
        con2.accept("123");
        System.out.println("========================");
        Consumer<String>con1=s->{
            System.out.println(s);
        };
        con1.accept("123");
    }
    //Lambda需要两个及以上的参数，多条执行语句，并可以有返回值
    @Test
    public void test6(){
        Comparator<Integer>com1=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,21));
        System.out.println("========================");
        Comparator<Integer>com2=(o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(2,6));
    }
    //当Lambda体只有一条语句时，若有return与大括号，则都可以省略
    @Test
    public void test7(){
        Comparator<Integer>com2=(o1,o2)-> o1.compareTo(o2);
        System.out.println(com2.compare(2,6));
    }
    @Test
    public void test8(){
        Consumer<String>con1=s->System.out.println(s);
        con1.accept("123");
    }
}
