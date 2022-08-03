package struct;

public class ForDemo02 {
    public static void main(String[] args) {
        //练习1：计算0~100之间的奇数和偶数的和

        int odd=0;
        int evenSum=0;
        for (int i = 0; i <=100; i++) {
            if(i%2!=0){
                odd+=i;
            }else {
                evenSum+=i;
            }
        }
        System.out.println("奇数的和："+odd);
        System.out.println("偶数的和："+evenSum);
    }
}
