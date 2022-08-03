package struct;

import java.util.Scanner;

public class IfDemo01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("");
        String s= scanner.nextLine();
        //equals方法，判断字符串是否相等
        if(s.equals("Hello")){
            System.out.println(s);
        }
        System.out.println("End");
        scanner.close();
    }
}
