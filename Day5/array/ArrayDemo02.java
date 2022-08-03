package array;

public class ArrayDemo02 {
    public static void main(String[] args) {
        //静态初始化:创建+赋值
        int[] a={1,23,434};
        Man[]men={new Man(),new Man()};
        System.out.println(a[0]);
        //动态初始化：包含默认初始化
        int[]b=new int[10];//初始化值为0
        System.out.println(b[0]);
    }
}
