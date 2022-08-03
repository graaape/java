package struct;

public class BreakDemo {
    public static void main(String[] args) {
        int i=0;
        while(i<100){
            System.out.println(i);
            i++;
            if (i==30){
                break;
            }
        }
        System.out.println("123");
    }
}
