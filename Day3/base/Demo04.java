package base;

public class Demo04 {
    public static void main(String[] args) {
        int i=128;
        byte b=(byte) i;//内存溢出
        //强制转换 （类型）变量名 高~低
        //自动转换 低~高
        System.out.println(i);//128
        System.out.println(b);//-128
        /*
        注意点：
        1. 不能对布尔值进行转换
        2. 不能把对象类型转换为不相干的类型
        3. 在把高容量转换到低容量时，需要强制转换
        4. 转换时可能存在内存溢出，或者精度问题
         */
        System.out.println("=============================");
        System.out.println((int)23.7);
        System.out.println((int)-45.89f);
        System.out.println("=============================");
        char c='a';
        int d=c+1;
        System.out.println(d);
        System.out.println((char)d);
    }
}
