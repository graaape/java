package struct;
//九九乘法表
public class ForDemo04 {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i+1; j++) {
                int a=i+1;
                int b=j+1;
                System.out.print(b+"*"+a+"="+(a*b));
                System.out.print("\t");
            }
            System.out.println();
        }

    }
}
