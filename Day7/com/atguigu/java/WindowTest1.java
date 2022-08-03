package com.atguigu.java;
/*
例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
1，问题：卖票过程中出现了重票、错票-->出现了线程的安全问题
2.问题出现的原因：当某个线程操作车票（共享数据）的过程中，尚未操作完成时，其他线程就参与进来操作车票。
3.如何解决：当一个线程操作ticket时，其他线程不能参与，直到该线程操作完成。即使该线程出现堵塞，也不能让其他线程进行操作。
4.在Java中，通过同步机制来解决线程的安全问题。
    方式1：同步代码块

    synchronized(同步监视器){
        //需要被同步的代码
    }
    说明：1.操作共享数据的代码，即为需要同步的代码
         2.共享数据：多个线程共同操作的变量
         3.同步监视器，俗称锁。任何一个类的对象都可以充当锁。
           要求：多个线程必须共用同一把锁。
         补充：在实现Runnable接口创建多线程的方式中可以考虑用this作为锁
    方式2：同步方法
        如果操作共享数据的代码完整地声明在一个方法中，我们不妨将此方法声明为同步的。
 */
class Window1 implements Runnable{
    private int ticket=100;
    Object obj=new Object();

    @Override
    public void run() {
        while (true){
//            if(ticket>0){
//    //增加出现错票的可能
//              try{
//                   Thread.sleep(100);
//               }
//               catch (InterruptedException e){
//                   e.printStackTrace();
//               }
//                System.out.println(Thread.currentThread().getName()+":卖票，票号为:"+ticket);
//    //增加出现重票的可能
//                try{
//                   Thread.sleep(100);
//               }
//               catch (InterruptedException e){
//                  e.printStackTrace();
//               }
//                ticket--;
//            }
//            else {
//                break;
//            }
            synchronized(this){//此时this:唯一的Window1的对象  //synchronized(obj)
                if(ticket>0){
                try{
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                    System.out.println(Thread.currentThread().getName()+":卖票，票号为:"+ticket);
                    ticket--;
                }
                 else {
                    break;
                 }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w=new Window1();
        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
