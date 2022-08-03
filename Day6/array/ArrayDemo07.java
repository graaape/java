package array;

import java.util.Arrays;

public class ArrayDemo07 {
    public static void main(String[] args) {
        int[]a={1,4,5,6,72,2,2,2,225,6,7};
        int[]sort=sort(a);
        System.out.println(Arrays.toString(sort));

    }
    //冒泡排序
    //1.比较数组中两个相邻的元素，如果第一个数比第二个数大，就交换它们的位置。
    //2.每次比较都会产生一个最大或最小的数。
    //3.下一轮则减少一次比较。
    //4.依次循环，直到结束。
    public static int[] sort(int[]a){
        for (int i = 0; i <a.length-1 ; i++) {
            boolean flag=false;
            for (int j = 0; j <a.length-1 ; j++) {
                if (a[j + 1] > a[j]) {
                    int t = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = t;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        return a;
    }
}
