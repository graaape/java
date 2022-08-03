package scanner;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //输入多个数字，并求其总和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果
        Scanner scanner=new Scanner(System.in);
        double sum=0;
        int cnt=0;

        //通过循环判断是否还有数字输入
        while(scanner.hasNextDouble()){
            sum+=scanner.nextDouble();
            cnt++;
            System.out.println("你输入了第"+cnt+"个数据，当前总和为"+sum);
        }
        System.out.println(cnt+"个数的和为"+sum);
        System.out.println(cnt+"个数的平均值为"+(sum/cnt));
        scanner.close();
    }

}
