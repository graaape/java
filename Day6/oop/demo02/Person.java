package oop.demo02;

public class Person {
    //即使什么都不写，也会存在一个默认的构造方法
    //显式定义构造器
    String name;
    int age;
    //实例化初始值
    //1.使用new关键字本质是在调用构造器
//    public Person(){
//        this.name="小明";
//    }
//    //有参构造：一旦定义了有参构造，无参构造就必须显式定义，否则实例化时必须带有参数
//    public Person(String name){
//        this.name=name;
//    }
    //alt+insert

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
/*
public static void main(String[] args) {

        //new 实例化了一个对象
        Person person=new Person("123");
        System.out.println(person.name);
    }
 */
