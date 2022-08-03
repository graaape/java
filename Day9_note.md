# 笔记 Day 9
## 尚硅谷Java入门 p546~559
### Map接口
存储key-value对的数据。
>#### Map接口的实现类
- HashMap：作为Map的主要实现类，线程不安全的，效率高，可以存储null的key和value。
- LinkedHashMap：按照添加的顺序遍历map元素。在原有的HashMap底层结构的基础上，添加了一对指针，指向前一个和后一个元素。对于频繁的遍历操作，效率高于HashMap。
- TreeMap：按照添加的key-value进行排序，考虑key的自然排序或定制排序。底层使用红黑树。
- Hashtable：作为古老的实现类，线程安全，效率低，不可以存储null的key和value。
- Properties：常用于配置文件，key和val都是String类型。
>#### 常用方法
- 添加：
	```java
	map.put(key,value);
- 修改：
	```java
	map.put(oldKey,newValue);
- 删除：
	```java
	map.remove(key); 
- 清空：
	```java
	map.clear();
- 查询元素：
	```java
	map.get(key);
	boolean isExist=map.containsKey(key);
	map.isEmpty();
- 元视图：
	```java
	map.keySet();//遍历所有的key集
	map.values();//遍历所有的value集
	map.entrySet()//遍历所有的key-value	
##
### Collections工具类
- Collections是一个操作Set、List和Map等集合的工具类。
- Collections提供了一系列静态的方法对集合元素进行排序、查询和修改等操作，还提供了对集合对象设置不可变、对集合对象实现同步控制等方法。
- Collections类中提供了多个synchronizedXxx()方法，可以将指定集合包装成线程同步的集合，从而解决多线程并发访问集合时的线程安全问题。
