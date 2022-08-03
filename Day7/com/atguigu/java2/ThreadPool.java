package com.atguigu.java2;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/*
创建线程方式4：使用线程池
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //提供指定数量的线程池
        ExecutorService service =Executors.newFixedThreadPool(10);
        //设置线程池的属性
        ThreadPoolExecutor service1=(ThreadPoolExecutor)service;
        service1.setCorePoolSize(15);
        //执行指定的线程的操作，需要有实现Runnable或Callable接口的对象
        service.execute(new NumberThread());//适合使用于Runnable
        service.execute(new NumberThread1());
        //service.submit();//适合使用于Callable
        //关闭线程池
        service.shutdown();

    }
}
