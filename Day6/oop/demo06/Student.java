package oop.demo06;

public class Student extends Person {


    public void go(){
        System.out.println("go");
    }

//    @Override
//    public void run() {
//        System.out.println("son");
//    }
//    public void eat(){
//        System.out.println("eat");
//    }
}
/*
 Object object=new Student();
        System.out.println(object instanceof Student);//true
        System.out.println(object instanceof Object);//true
        System.out.println(object instanceof Person);//true
        System.out.println(object instanceof Teacher);//false
        System.out.println(object instanceof String);//false
        System.out.println("=====================");
        Person person=new Student();
        System.out.println(person instanceof Student);//true
        System.out.println(person instanceof Object);//true
        System.out.println(person instanceof Person);//true
        System.out.println(person instanceof Teacher);//false
        //System.out.println(person instanceof String);//编译报错
        System.out.println("=====================");
        Student student=new Student();
        System.out.println(student instanceof Student);//true
        System.out.println(student instanceof Person);//true
        System.out.println(student instanceof Object);//true
//        System.out.println(student instanceof Teacher);
//        System.out.println(student instanceof String);
 */
/*
public class Application {
    public static void main(String[] args) {

       //类型之间的转换
        Person obj=new Student();
        ((Student)obj).go();
        //子类转换为父类，可能丢失自己本来的一些方法
        Student student=new Student();
        student.go();
        Person person=student;
    }
}
/*
1.父类引用可以直接指向子类的对象
2.把父类转换为子类，需要强制转换
3.方便方法的调用
 */