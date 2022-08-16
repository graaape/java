package com.atguigu.java;

import java.io.Serializable;

public class Person1 implements Serializable {
    private String name;
    private int age;

    private int id;

    private Account account;

    public static final long serialVersionUID=231232L;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person1() {
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

    public Person1(String name, int age, int id, Account account) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", account=" + account +
                '}';
    }
}
class Account implements Serializable{
    private double balance;

    public static final long serialVersionUID=23232L;
    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}