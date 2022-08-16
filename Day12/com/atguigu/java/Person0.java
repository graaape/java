package com.atguigu.java;

public class Person0 {
    private String name;
    public int age;

    public Person0(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person0(String name) {
        this.name = name;
    }

    public Person0() {
        System.out.println("Person0()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person0{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void show(){
        System.out.println("你好");
    }
    private String showNation(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;
    }
}
