package struct;

public class ContinueDemo {
    public static void main(String[] args) {
        int i=0;
        while (i<100){
            i++;
            if(i%10==0){
                continue;
            }
            System.out.println(i);
        }
    }
}
