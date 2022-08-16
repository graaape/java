package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
调用运行时类中的指定结构
 */
public class ReflectionTest {
    @Test
    public void testField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class cla = Person.class;
        //创建运行时类的对象
        Person p=(Person)cla.newInstance();
        //获取指定的属性:要求属性声明为public
        Field id = cla.getField("id");
        /*
        设置当前属性的值
        set():参数1：指明设置哪个对象的属性 参数2：将此属性设置为多少
         */
        id.set(p,1001);
        /*
        获取当前属性的值
        get():参数1：获取哪个对象当前的属性值
         */
        int pID=(int)id.get(p);
    }
    @Test
    public void test1() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class cla = Person.class;
        //创建运行时类的对象
        Person p=(Person)cla.newInstance();
        //getDeclaredField():获取运行时类中指定变量名的属性
        Field name = cla.getDeclaredField("name");
        //保证当前属性可访问
        name.setAccessible(true);
        name.set(p,"Tom");
        System.out.println(name.get(p));
    }
    @Test
    public void testMethod() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class cla = Person.class;
        //创建运行时类的对象
        Person p=(Person)cla.newInstance();
        //getDeclaredMethod():参数1：指明获取的方法的名称 参数2：指明获取的方法的形参列表
        Method show = cla.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        //invoke():参数1：方法的调用者 参数2：给形参赋值的实参
        Object returnValue=show.invoke(p,"CN");
        System.out.println(returnValue);
        System.out.println("************调用静态方法***************");
        Method showDesc = cla.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        returnValue=showDesc.invoke(null);
        System.out.println(returnValue);
    }
    @Test
    public void testConstructor() throws Exception {
        Class cla = Person.class;
        /*
        获取指定的构造器
        getDeclaredConstructor():参数：指明构造器的参数列表
         */
        Constructor constructor = cla.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        //调用此构造器创建运行时类的对象
        Person p = (Person) constructor.newInstance("Tom");
        System.out.println(p.toString());
    }
}
