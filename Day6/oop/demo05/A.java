package oop.demo05;

public class A extends B{
    //重写
    @Override//有功能的注释
    public void test() {
        System.out.println("A->test()");
    }
}
/*
 public static void main(String[] args) {
        //静态方法的调用只和左边定义的数据类型有关
        //非静态：重写
        //静态方法和非静态方法区别很大

        A a=new A();
        a.test();
        //父类的引用指向了子类
        B b=new A();//子类重写了父类的方法
        b.test();
    }
 */