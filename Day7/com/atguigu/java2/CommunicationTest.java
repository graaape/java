package com.atguigu.java2;
/*
线程通信例子：使用两个线程交替打印1~100
wait():一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器。
notify():唤醒另一个在wait的线程。
notifyAll():唤醒其余所有在wait的线程。

说明：
1.以上三个方法必须使用在同步代码块或同步方法中。
2.以上三个方法的调用者必须是所在的同步代码块或同步方法的同步监视器。
3.以上三个方法定义在java.lang.Object类中。

问题：sleep()和wait()方法异同
1.相同点:一旦执行，都可以让当前线程进入阻塞状态。
2.不同点：1）声明的位置不同：Thread类中声明sleep(),Object类中声明wait()。
        2）调用的要求不同：sleep()可以在任何需要的场景下调用，wait()必须使用在同步代码块或同步方法中。
        3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放同步监视器，wait()会释放同步监视器。
 */
class Number implements Runnable{
    private  int num=1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();//唤醒另一个在wait的线程
                //notifyAll();唤醒其余所有在wait的线程
                if (num<=100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num++;
                    try {
                        //使得调用如下wait方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number=new Number();
        Thread t1=new Thread(number);
        Thread t2=new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }

}
