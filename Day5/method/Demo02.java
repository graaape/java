package method;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println(max(10,20));
        System.out.println(max(2.1,3.2));
    }
    //比大小
    public static int max(int a,int b){
        int res=0;
        if(a>b){
            res=a;
        }
        else{
            res=b;
        }
        return res;
        //return a>b?a:b;
    }
    //方法重载
    public static double max(double a,double b){
        return a>b?a:b;
    }
}
