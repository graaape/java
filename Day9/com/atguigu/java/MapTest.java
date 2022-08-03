package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/*
一、Map:双列数据，存储key-value对的数据。
    HashMap：作为Map的主要实现类，线程不安全的，效率高，可以存储null的key和value。
        LinkedHashMap：按照添加的顺序遍历map元素。
            原因：在原有的HashMap底层结构的基础上，添加了一对指针，指向前一个和后一个元素
                 对于频繁的遍历操作，效率高于HashMap
    TreeMap：按照添加的key-value进行排序，考虑key的自然排序或定制排序
             底层使用红黑树
    Hashtable：作为古老的实现类，线程安全，效率低，不可以存储null的key和value。
        Properties：常用于配置文件，key和val都是String类型


       HashMap的底层：数组+链表（jdk7及之前）
                    数组+链表+红黑树（jdk8）
问题：
1.HashMap的底层实现原理？
2.HashMap和Hashtable的异同
3.CurrentHashMap和HashMap的异同？
二、Map结构的理解
    Map中的key：无序的、不可重复的，使用Set存储所有的key-->要重写equals()hashcode()（以HashMap为例）
    Map中的value：无序的、可重复的，使用Collection存储所有的value-->value所在类要重写equals()
    一个键值对构成一个Entry对象。
    Map中的Entry：无序的、不可重复的，使用Set存储所有的Entry对象
三、HashMap的底层实现原理
    以jdk7为例：
       HashMap map=new HashMap();
       在实例化后，底层创建了长度为16的一维数组Entry[] table
       ...可能执行过多次put...
       map.put(key1,value1);
       首先，调用key1所在类的hashCode()计算key1的哈希值，此哈希值通过某种算法计算以后，得到在Entry数组中存放的位置
       如果此位置上数据为空，此时key1-value1添加成功。---情况1
       如果此位置上数据不为空，意味着此位置上存在一个或多个数据（以链表形式存在），需要比较key1和已经存在数据的哈希值：
        如果哈希值不同，则添加成功。---情况2
        如果与某个已存在的数据（key2-val2）哈希值相同，则调用key1所在类的equals(key2)进行比较：
            如果返回false，则添加成功---情况3
            如果返回true，则使用value1替换value2
        补充：关于情况2和情况3，此时key1-value1和原来的数据以链表的方式存储。
        默认的扩容方式：扩容为原来容量的两倍，并将原有的数据复制过来。
        扩容条件：超过临界值，且要存放的位置为空。
     jdk8相较于jdk7在底层实现方面的不同：
     1.new HashMap():底层没有创建一个长度为16的数组
     2.jdk8的底层数组是Node[]
     3.首次调用put()时，底层创建长度为16的数组
     4.jdk7底层结构：数组+链表
       jdk8底层结构：数组+链表+红黑树
       当数组的某一个索引位置上以链表形式存储的数据个数>8且当前数组长度>64时，此时此索引位置上的所有数据使用红黑树存储。

       DEFAULT_INITIAL_CAPACITY:HashMap的默认容量：16
       DEFAULT_LOAD_FACTOR:HashMap的默认加载因子：0.75
       threshold:扩容的临界值=容量*加载因子
       TREEIFY_THRESHOLD:Bucket中链表长度大于该默认值（8），转化为红黑树
       MIN_TREEIFY_CAPACITY:Bucket中的Node被树化时最小的hash表的容量（64）

 */
public class MapTest {
    @Test
    public void test1(){
        Map map=new HashMap();
        //map=new Hashtable();
        map.put(null,null);
    }
    @Test
    public void test2(){
        Map map=new HashMap();
        map=new LinkedHashMap();
        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");
        System.out.println(map);
    }
    //Map中定义的方法
    //添加、删除、修改操作
    @Test
    public void test3(){
        Map map=new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        //修改
        map.put("AA",87);
        System.out.println(map);
        Map map1=new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map.putAll(map1);
        System.out.println(map);
        //remove(Object key)
        Object value= map.remove("CC");
        System.out.println(value);
        System.out.println(map);
        //clear()
        map.clear();//map=null不同
        System.out.println(map.size());
        System.out.println(map);
    }
    //元素查询操作
    @Test
    public void test4(){
        Map map=new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        //Object get(Object key)
        System.out.println(map.get(45));
        //boolean containsKey(Object key)
        boolean isExist=map.containsKey("BB");
        System.out.println(isExist);
        //boolean containsValue(Object value)
        isExist=map.containsValue(123);
        System.out.println(isExist);
        map.clear();
        System.out.println(map.isEmpty());

    }
    //元视图操作方法
    @Test
    public void test5(){
        Map map=new HashMap();
        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);
        //遍历所有的key集：keySet()
        Set set=map.keySet();
        Iterator iterator= set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        //遍历所有的value集：values()
        Collection values=map.values();
        iterator= values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        //遍历所有的key-value：
        //方式1：entrySet()
        Set entrySet=map.entrySet();
        iterator=entrySet.iterator();
        while (iterator.hasNext()){
            Object obj=iterator.next();
            Map.Entry entry=(Map.Entry) obj;
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        System.out.println();
        //方式2：
        Set keySet=map.keySet();
        Iterator iterator1= keySet.iterator();
        while (iterator1.hasNext()){
            Object key=iterator1.next();
            Object value=map.get(key);
            System.out.println(key+"="+value);
        }
    }
}
