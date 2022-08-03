package struct;

import java.util.Scanner;

public class IfDemo03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        /**
         * 一个if语句最多对应一个else语句
         */
        System.out.println("请输入成绩：");
        int score= scanner.nextInt();
        if(score==100){
            System.out.println("满分");
        }else if(score<100&&score>=90){
            System.out.println("A");
        }else if(score<90&&score>=80){
            System.out.println("B");
        }else if(score<80&&score>=70){
            System.out.println("C");
        }else if(score<70&&score>=60){
            System.out.println("D");
        }else if(score<60&&score>=0){
            System.out.println("不及格");
        }else {
            System.out.println("成绩不合法");
        }
        scanner.close();
    }
}
