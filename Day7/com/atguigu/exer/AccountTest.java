package com.atguigu.exer;
/*
问题描述：银行有一个账户，两个储户向同一个账户存3000元，每次存1000元，存3次，每次存完打印账户余额。
分析：
1.是否为多线程问题？是，两个储户线程
2.是否有共享数据？有，账户余额
3.是否有线程安全问题？有
4.如何解决线程安全问题？同步机制，三种方式
 */
class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    public synchronized void deposit(double amt) {//唯一的Account类对象，可以不用写成静态方法
        if(amt>0){
            balance+=amt;
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功。余额为："+balance);
        }
    }
}
class Customer extends Thread{
    private Account acct;
    public Customer(Account acct){
        this.acct=acct;
    }

    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
           acct.deposit(1000);
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account acct=new Account(0);
        Customer c1=new Customer(acct);
        Customer c2=new Customer(acct);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}
