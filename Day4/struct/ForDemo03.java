package struct;

public class ForDemo03 {
    public static void main(String[] args) {
        //输出1~1000能被5整除的数，并且每三个为一行
        for (int i = 1; i <=1000; i++) {
            if(i%5==0){
                System.out.print(i+"\t");//不换行
            }
            if(i%(5*3)==0){//换行
                System.out.println();//等于System.out.print("\n");
            }
        }
    }
}
