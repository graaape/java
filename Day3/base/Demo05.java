package base;

public class Demo05 {
    public static void main(String[] args) {
        //操作比较大的数，要注意溢出问题
        //数字间可以用下划线分割
        int money=10_0000_0000;
        int years=20;
        int total =years*money;//-1474836480 内存溢出
        System.out.println(total);
        long total2=years*money;//默认为int进行计算，所以仍然溢出
        System.out.println(total2);
        total2=years*(long)money;//先把一个数转换为long就行了
        System.out.println(total2);
    }
}
