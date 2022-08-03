package oop.demo02;

public class Student {
    //属性：字段
    String name;
    int age;
    //方法
    public void study(){
        System.out.println(this.name+"在学习");
    }
}
/*
//类实例化后会返回一个自己的对象
        Student xiaoming=new Student();
        Student xh=new Student();
        xiaoming.name="小明";
        xiaoming.age=3;
        System.out.println(xiaoming.name);
        System.out.println(xiaoming.age);
        xh.name="小红";
        xh.age=3;
        System.out.println(xh.name);
        System.out.println(xh.age);
    }
 */