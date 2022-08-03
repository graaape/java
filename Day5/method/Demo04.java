package method;

public class Demo04 {
    public static void main(String[] args) {
        printMax(34,3,3,2,56.4);
        printMax(new double[]{23,2,1.6,1});
    }
    public static void printMax(double... numbers){
       if(numbers.length==0){
           System.out.println("No argument passed");
           return;
       }
       double res=numbers[0];
        for (int i = 1; i <numbers.length ; i++) {
            if (numbers[i]>res){
                res=numbers[i];
            }
        }
        System.out.println("The max value is "+res);
    }
}
