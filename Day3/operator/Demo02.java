package operator;

public class Demo02 {
    public static void main(String[] args) {
        long a=1000000000000L;
        int b=123;
        short c=10;
        byte d=8;
        System.out.println(a+b+c+d);//long
        System.out.println(b+c+d);//int
        System.out.println(c+d);//int
        double e=1.1;
        System.out.println(a+e);//long+double 变成用科学计数法表示
    }
}
