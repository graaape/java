package operator;
//位运算
public class Demo06 {
    public static void main(String[] args) {
        /*
        A=  0011 1100
        B=  0000 1101

        A&B=0000 1100
        A|B=0011 1101
        A^B=0011 0001
        ~B= 1111 0010

        2*8=16 2*2*2*2
        效率高
        左移 << *2
        右移 >> /2
        */
        System.out.println(2<<3);//2左移3位  00010->10000

    }
}
