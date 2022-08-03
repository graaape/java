package struct;

public class ForDemo01 {
    public static void main(String[] args) {
        int a=1;//初始化条件
        while(a<=100) {//条件判断
            System.out.println(a);//循环体
            a += 2;//迭代
        }
        System.out.println("While循环结束");
        for(int i=1;i<=100;i++){
            System.out.println(i);
        }
        System.out.println("For循环结束");
        //死循环
//        for (;;){
//
//        }
    }
    /*
    for循环
    最先执行初始化步骤，可以声明一种类型，但可以初始化一个或多个循环控制变量，也可以是空语句。
    检查布尔表达式的值，如果为false则结束循环。
    执行一次循环后，更新循环控制变量。
     */
}
