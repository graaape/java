package oop.demo01;

public class Demo03 {
    public static void main(String[] args) {
        //实参和形参的类型要对应
        int add=Demo03.add(1,2);
        System.out.println(add);
    }
    public static int add(int a,int b){
        return a+b;
    }
}
