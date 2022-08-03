package oop.demo04;

public class Student {
    //属性私有
    private String name;//名字
    private int id;//学号
    private int age;
    private char sex;//性别
    //提供可以操作属性的方法
    //提供一些public的get、set方法
    public  String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    //alt+insert

    public int getId() {
        return id;
    }

    public char getSex() {
        return sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>120||age<0){
            this.age=3;
        }
        else {
            this.age = age;
        }
    }
}
/*
public class Application {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.setName("123");
        System.out.println(s1.getName());
        s1.setAge(-1);//不合法的
        System.out.println(s1.getAge());
    }
}
1.提高程序的安全性，保护数据
2.隐藏代码的实现细节
3.统一接口
4.系统的可维护性增加了
 */