package oop.demo05;
//在Java中，所有类都默认直接或间接继承Object类
public class Person {
    //public
    //protected
    //default
    //private
   protected String name="123";
   //私有的无法被继承
   public void print(){
       System.out.println("Person");
   }

    public Person(String name) {
        this.name = name;
    }
        public Person() {
        System.out.println("Person无参执行");
    }
}
