package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    @Test
    public void test1(){
        Class cla= Person.class;
        //获取属性结构
        //getFields()：能获得当前运行时类及其父类public访问权限的属性
        Field[] fields = cla.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println();
        //getDeclaredFields():获取当前运行时类中声明的所有属性（不包含父类中声明的属性）
        Field[] declaredFields = cla.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }
    @Test
    public void test2(){
        Class cla= Person.class;
        Field[] declaredFields = cla.getDeclaredFields();
        for (Field f : declaredFields) {
            //权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier)+"\t");
            //数据类型
            Class type = f.getType();
            System.out.print(type.getName()+"\t");
            //变量名
            String name = f.getName();
            System.out.print(name);
            System.out.println();
        }
    }
}
