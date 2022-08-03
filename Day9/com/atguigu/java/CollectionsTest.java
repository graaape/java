package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Collections常用方法
 */
public class CollectionsTest {
    @Test
    public void test1(){

        List list=new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println(list);
//        //reverse(List)
//        Collections.reverse(list);
        //shuffle(List)
//        Collections.shuffle(list);
        //sort(List)
//        Collections.sort(list);
        //swap(List,int,int)
//        Collections.swap(list,1,2);
        //int frequency(List,Object)
        System.out.println(Collections.frequency(list,765));
    }
    @Test
    public void test2(){
        List list=new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
        //报异常
//        List dest=new ArrayList();
//        Collections.copy(dest,list);
        List dest= Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
        //list1为线程安全的List
        List list1 = Collections.synchronizedList(list);
    }
}
