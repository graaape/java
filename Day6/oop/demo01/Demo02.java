package oop.demo01;

public class Demo02 {
    public static void main(String[] args) {
        //实例化这个类 new
        Student student= new Student();
        student.say();
    }
    //静态方法和类一起加载
    public static void a(){
        //b();
    }
    //类实例化之后才存在
    public void b(){
        a();
    }
}
