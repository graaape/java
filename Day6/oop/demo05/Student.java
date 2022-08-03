package oop.demo05;
//Student is Person
//子类继承父类的全部public方法
public class Student extends Person{
    private String name="321";
    public void print(){
        System.out.println("Student");
    }
    public void test(){
        print();
        this.print();
        super.print();
    }

    public Student() {
        //隐式调用父类的构造器
        //显式调用父类构造器，必须在子类构造器第一行
        System.out.println("Student无参执行");
    }
    //    public void test(String name){
//        System.out.println(name);
//        System.out.println(this.name);
//        System.out.println(super.name);
//    }
//
}
