package base;

public class Demo07 {


    //类变量 static
    static double salary=2500;

    //属性：变量

    //实例变量：从属于对象;如果不进行初始化，则为这个类型的默认值 eg.0
    //布尔值默认为false
    //除了基本类型，其余默认值都是null
    String name;
    int age;

    //main 方法
    public static void main(String[] args) {
        //局部变量:必须声明和初始化值
        int i=10;

        //变量类型 变量名 =new Demo07();
        Demo07 demo07= new Demo07();
        System.out.println(demo07.age);//0
        System.out.println(demo07.name);//null

        //类变量 static
        System.out.println(salary);
    }

    //其他方法
    public void  add(){

    }
}
