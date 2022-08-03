package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
创建线程方式3：实现Callable接口---JDK5.0新增
如何理解实现Callable接口创建多线程的方式比实现Runnable接口创建多线程的方式要强大？
1.call()可以有返回值。
2.call()可以抛出异常。
3.Callable支持泛型。
 */
//创建一个实现Callable的实现类
class NumThread implements Callable{
//实现call方法
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 1; i <=100 ; i++) {
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //创建Callable接口实现类的对象
        NumThread numThread=new NumThread();
        //将此对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread类的对象，并调用start()
        new Thread(futureTask).start();
        try {
            //获得call方法的返回值
           Object sum= futureTask.get();
            System.out.println("偶数总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
