package struct;

public class TestDemo01 {
    public static void main(String[] args) {
        //打印三角形
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j >= i+1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
