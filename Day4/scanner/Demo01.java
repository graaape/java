package scanner;



import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        //创建一个扫描器对象，用于接受键盘数据
        Scanner scanner= new Scanner(System.in);
        System.out.println("使用next方式接收：");
        //判断用户有没有输入字符串
        if(scanner.hasNext()){
            //使用next方式接收，无法得到带有空格的字符串
            String str=scanner.next();
            System.out.println("输出的内容为："+str);
        }
        //凡是从属于IO流的类，使用后要及时关闭，否则会占用资源
        scanner.close();
    }
}
