package com.atguigu.java1;

import com.atguigu.java.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*
Set接口：存储无序的、不可重复的数据
HashSet:作为Set接口的主要实现类，线程不安全，可以储存null值
LinkedHashSet：作为HashSet的子类。遍历其内部数据时，可以按照添加的顺序遍历
TreeSet：可以按照添加对象的指定属性，进行排序
向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
    重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
 */
public class SetTest {
    /*
    一、Set的特点：存储无序的、不可重复的数据
    以HashSet为例说明
    1.无序性:不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定

    2.不可重复性：保证添加的元素按照equals()判断时，不能返回true，即相同的元素只能添加一个

    二、添加元素的过程，以HashSet为例
        向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值
        通过某种算法以此哈希值计算出元素a在HashSet底层数组中的存放位置(即索引位置)，判断此位置上是否已有其他元素
            如果没有其他元素，则元素a添加成功-->情况1
            如果有其他元素B（或以链表形式存在的多个元素），则比较元素a与元素b的hash值
                如果hash值不相同，则元素a添加成功-->情况2
                如果hash值相同，则调用元素a所在类的equals()方法
                    返回true则添加失败
                    返回false则添加成功-->情况3
       对于添加成功的情况2和3而言，元素a与已经存在指定索引位置上的数据以链表的方式存储。
       jdk 7：元素a在数组中，指向原来的元素
       jdk 8：原来的元素在数组中，指向元素a

       jdk 7中HashSet底层：数组+链表的结构
     */
    @Test
    public void test1(){
        Set set=new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);
        Iterator iterator= set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //LinkedHashSet的使用
    //LinkedHashSet在添加数据的同时，每个数据还维护了两个引用，记录此数据的前一个和后一个数据
    //对于频繁的遍历操作，LinkedHashSet的效率高于HashSet
    @Test
    public void test2(){
        Set set=new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);
        Iterator iterator= set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
