package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/*
解决线程安全问题方式3：Lock锁---JDK5.0新增
1.问题：synchronized与lock的异同
同：都可以解决线程安全问题
不同：sychronized机制执行完相应的同步代码自动释放同步监视器
    lock需要手动地启动结束同步
 */
class Window implements Runnable{
    private int ticket=100;
    //实例化ReentrantLock
    private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                //调用锁定方法
                lock.lock();
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+":卖票，票号为:"+ticket);
                    ticket--;
                }
                else {
                    break;
                }
            }finally {
                //调用解锁方法
                lock.unlock();
            }

        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window w=new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
