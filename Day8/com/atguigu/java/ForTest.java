package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/*
foreach循环，用于遍历数组、集合
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        //内部仍然调用了迭代器
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }
    @Test
    public void test2(){
        int[]arr=new int[]{1,2,3,4,5,6};
        for (int i : arr) {
            System.out.println(i);
        }
    }
    @Test
    public void test3(){
        String[]arr=new String[]{"MM","MM","MM"};
        //普通for循环
//        for (int i = 0; i < arr.length ; i++) {
//            arr[i]="GG";
//        }
        //增强for循环，不改变数组中元素的值
        for (String s : arr) {
            s="GG";
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}
