package oop.demo10;

public class Outer {
    private int id=10;
    public void out(){
        System.out.println("这是外部类的方法");
    }
    //局部内部类
    public void method(){
        class Inner{
            public void in(){
                System.out.println();
            }
        }
    }

//    public static class Inner{
//        public void in(){
//            System.out.println("这是内部类的方法");
//        }
//        //
//        public void getID(){
//            System.out.println(id);
//        }
//    }
}
//一个java类文件中只能有一个public类
//class  A{
//
//}
/*
Outer outer =new Outer();
        //通过外部类来实例化内部类
//        Outer.Inner inner= outer.new Inner();
//        inner.in();
//        inner.getID();
 */