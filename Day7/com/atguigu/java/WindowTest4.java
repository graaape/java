package com.atguigu.java;
/*
使用同步方法处理继承Thread类创建多线程的安全问题
 */
class Window4 extends Thread{
    private static int ticket=100;
    private static boolean flag=false;
    @Override
    public void run() {
    while (true){
            show();
            if (flag){
                break;
            }
        }
    }
    private static synchronized void show(){
        //private synchronized void show(){//同步监视器：t1，t2，t3 不可行
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+":卖票，票号为:"+ticket);
            ticket--;
        }
        else {
            flag=true;
        }
    }
}
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1=new Window4();
        Window4 t2=new Window4();
        Window4 t3=new Window4();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}