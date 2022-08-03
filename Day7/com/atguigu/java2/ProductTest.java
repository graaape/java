package com.atguigu.java2;
/*
线程通信的应用
生产者/消费者问题
生产者（Producer）将产品交给店员（Clerk），而消费者（Customer）从店员处取走产品。
店员一次只能持有固定数量（比如20个）的产品，如果生产者试图生产更多的产品，店员会叫生产者暂停生产，有空位时再通知生产者继续生产；
如果没有产品了，店员会叫消费者等一下，店里有产品后消费者再来取商品。

分析：
1.是否是多线程问题？是，生产者线程，消费者线程。
2.是否有共享数据的问题？是，店里产品的数量。
3.如何解决线程安全问题？同步机制，三种方法。
4.是否涉及线程的通信？是。
 */

class Clerk{
    private int productCount=0;
    public synchronized void produceProduct() {
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+"：开始生产第"+productCount+"个产品");
            notify();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public synchronized void consumeProduct() {

        if(productCount>0){
            System.out.println(Thread.currentThread().getName()+"：开始消费第"+productCount+"个产品");
            productCount--;
            notify();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始生产产品......");
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            clerk.produceProduct();
        }
    }
}
class Customer extends Thread{
    private Clerk clerk;
    public Customer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始消费产品......");
        try {
            sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            clerk.consumeProduct();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Producer p1=new Producer(clerk);
        p1.setName("生产者1");
        Customer c1=new Customer(clerk);
        c1.setName("消费者1");
        Customer c2=new Customer(clerk);
        c2.setName("消费者2");
        p1.start();;
        c1.start();
        c2.start();
    }
}
