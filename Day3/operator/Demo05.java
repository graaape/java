package operator;
//逻辑运算符
public class Demo05 {
    public static void main(String[] args) {
        //与 或 非
        boolean a=true;
        boolean b=false;
        System.out.println("a&&b:"+(a&&b));//都为true，结果才为true
        System.out.println("a||b:"+(a||b));//有一个为true，则结果为true
        System.out.println("!(a&&b):"+!(a&&b));//true->false false->true

        //短路运算
        int c=5;
        boolean d=(c<4)&&(c++>4);
        System.out.println(d);
    }
}
