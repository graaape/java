package oop.demo10;

public class Test {
    public static void main(String[] args) {
        //Apple apple=new Apple();
        //没有名字初始化类，不用将实例保存到变量中
        new Apple().eat();;
        UserService userService=new UserService() {
            @Override
            public void hello() {

            }
        };
    }
}
class Apple{
    public void eat(){
        System.out.println("1");
    }
}
interface UserService{
    void hello();
}