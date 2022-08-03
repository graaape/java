package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/*
ArrayList：List接口的主要实现类，线程不安全的，效率高。底层使用Object[] elementData存储
LinkedList：对于频繁插入、删除操作，使用此类效率比ArrayList高。底层使用双向链表存储
Vector：List接口的古老实现类，线程安全，效率低。底层使用Object[] elementData存储
问题：ArrayList、LinkedList、Vector三者的异同？
不同：见上
同：三个类都实现了List接口，存储数据的特点相同：存储有序的可重复的数据


ArrayList的源码分析：
    jdk 7情况下：
    ArrayList list=new ArrayList();//底层创建了长度是10的Object[]数组elementData
    list.add(123);//elementData[0]=new Integer(123);
    ...
    list.add(11);//如果这次添加导致elementData数组容量不够，则扩容
    默认情况下，扩容为原来容量的1.5倍，同时需要将原有数组中的数据复制到新数组中

   结论：建议开发中使用带参的构造器：ArrayList list=new ArrayList(int capacity)

   jdk 8中ArrayList的变化：
   ArrayList list=new ArrayList();//底层Object[]数组elementData初始化为{}，没有创建长度为10的数组
   list.add(123);//第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementData中
   ...
   后续的添加和扩展与jdk 7无异
LinkedList的源码分析：
     list=new LinkedList();//内部声明了Node类型的first和last属性，默认值为null
    list.add(123)://将123封装到Node中，创建了Node对象

总结常用方法：
增：add(Object obj)
删：remove(int index)/remove(Object obj)
改：set(int index,Object ele)
查：get(int index)
插：add(int index,Object ele)
长度：size()
遍历：1.Iterator迭代器
     2.增强for循环
     3.普通的循环

 */
public class ListTest {
    //List接口中常用方法测试
    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);
        System.out.println(list);
        //void add(int index,Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);
        //boolean addAll(int index,Collection eles):从index位置开始插入eles中的所有元素
        List list1= Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list.size());//9
        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));
    }
    @Test
    public void test2(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);
        //int indexOf(Object obj):返回obj在集合中首次出现的位置,如果不存在返回-1
        int index=list.indexOf(456);
        System.out.println(index);
        //int lastIndexOf(Object obj):返回obj在当前集合中最后出现的位置,如果不存在返回-1
        System.out.println(list.lastIndexOf(456));
        //Object remove(int index):移除指定index位置的元素，并返回该元素
        Object obj=list.remove(0);
        System.out.println(obj);
        System.out.println(list);
        //Object set(int index,Object ele):设置指定index位置的元素为ele
        list.set(1,"CC");
        System.out.println(list);
        //List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex位置(左闭右开)的子集合
        List subList=list.subList(2,4);
        System.out.println(subList);
        System.out.println(list);
    }
    @Test
    public void test3(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        //方式1：Iterator迭代器
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("====================");
        //方式2：增强for循环
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("====================");
        //方式3：普通的for循环
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
