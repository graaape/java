package array;

import java.util.Arrays;

public class ArrayDemo06 {
    public static void main(String[] args) {
        int[]a={1,2,3,4,5,3123,6756,6,34};
        //System.out.println(a);//[I@1b6d3586
        //打印数组元素Arrays.toString
        //System.out.println(Arrays.toString(a));
        //printArray(a);
        //数组进行排序
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        //数组填充
        Arrays.fill(a,2,4,0);
        System.out.println(Arrays.toString(a));
    }

    public  static void printArray(int[]a){
        for (int i = 0; i <a.length ; i++) {
            if(i==0){
                System.out.print("[");
            }
            if(i!=0){
                System.out.print(",");
            }
            System.out.print(a[i]);
            if(i==a.length-1){
                System.out.println("]");
            }
        }
    }
}
