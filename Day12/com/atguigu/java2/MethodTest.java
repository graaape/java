package com.atguigu.java2;
/*
获取运行时类的方法结构
 */
import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {
    @Test
    public void test1(){
        Class cla = Person.class;
        //getMethods():能获得当前运行时类及其所有父类public访问权限的方法
        Method[] methods = cla.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        //getDeclaredMethods():获取当前运行时类中声明的所有方法（不包含父类中声明的方法）
        Method[] declaredMethods = cla.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }
    @Test
    public void test2(){
        Class cla = Person.class;
        Method[] declaredMethods = cla.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //获取方法声明的注解
            Annotation[] annos = declaredMethod.getAnnotations();
            for (Annotation a : annos) {
                System.out.println(a);
            }
            //权限修饰符
            System.out.print(Modifier.toString(declaredMethod.getModifiers())+"\t");
            //返回值类型
            System.out.print(declaredMethod.getReturnType().getName()+"\t");
            //方法名
            System.out.print(declaredMethod.getName());
            System.out.print("(");
            //形参列表
            Class[] parameterTypes = declaredMethod.getParameterTypes();
            if(!(parameterTypes==null||parameterTypes.length==0)){
                for (int i = 0; i < parameterTypes.length; i++) {
                    if(i!=0){
                        System.out.print(",");
                    }
                    Class p=parameterTypes[i];
                    System.out.print(p.getName()+" args_"+i);
                }
            }
            System.out.print(")");
            //抛出的异常
            Class[] exceptionTypes = declaredMethod.getExceptionTypes();
            if(!(exceptionTypes==null||exceptionTypes.length==0)){
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i!=0){
                        System.out.print(",");
                    }
                    System.out.print(exceptionTypes[i].getName());
                }
            }
            System.out.println();
        }


    }
}
