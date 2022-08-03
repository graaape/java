package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/*
集合元素的遍历，使用迭代器Iterator接口
内部的方法：hasNext() next() remove()
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        Iterator iterator=coll.iterator();
        //方式1
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
//        System.out.println(iterator.next());
        //方式2：不推荐
//        for (int i = 0; i <coll.size() ; i++) {
//            System.out.println(iterator.next());
//        }
        //方式3：推荐
        //hasNext():判断是否还有下一个元素
        while (iterator.hasNext()){
            //next():指针下移，将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        //错误方式1：会跳过集合中的某些元素，且仍然会超出集合
//        Iterator iterator=coll.iterator();
//        while (iterator.next()!=null){
//            System.out.println(iterator.next());
//        }
        //错误方式2：死循环，只输出集合中第一个元素
//        while (coll.iterator().hasNext()){
//            System.out.println(coll.iterator().next());
//        }
    }
    //测试Iterator中的remove()
    //如果还未调用next()或在上次调用next方法之后已经调用了remove方法，
    //再调用remove都会报IllegalStateException
    @Test
    public void test3(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        Iterator iterator= coll.iterator();
        //删除集合中的“Tom”
        while (iterator.hasNext()){
            Object obj=iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }
        //重新创建迭代器，遍历集合
        iterator= coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
