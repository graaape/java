public class Demo03 {
    public static void main(String[] args) {
        //整数拓展: 进制问题 二进制0b 十进制 八进制0 十六进制0x
        int i=10;
        int i2=010;//八进制 0
        int i3=0x10;//十六进制 0x 0~9 A~F
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println("=============================================================");
        //=====================================================
        //浮点数拓展 银行业务，金额表示
        //BigDecimal 数学工具类
        //=====================================================
        //float  double   有限 离散 存在舍入误差
        //最好避免使用浮点数进行比较
        float f=0.1f;//0.1
        double d=1.0/10;//0.1
        System.out.println(f==d);//false
        float d1=122323243243f;
        float d2=d1+1;
        System.out.println(d1==d2);//true

        System.out.println("=============================================================");
        //=====================================================
        //字符拓展
        //=====================================================
        char c1='a';
        char c2='中';
        System.out.println(c1);
        System.out.println((int)c1);//强制类型转换
        System.out.println(c2);
        System.out.println((int)c2);//强制类型转换
        //编码 Unicode 2字节 0~65536  97=a

        char c3='\u0061';//16进制 0x61=97
        System.out.println(c3);

        //转义字符
        // \t 制表符
        // \n 换行
        System.out.println("Hello\tworld!\nHello");
        System.out.println("=============================================================");
        //对象 从内存分析
        String sa=new String("hello world");
        String sb=new String("hello world");
        System.out.println(sa==sb);//false
        String sc="hello world";
        String sd="hello world";
        System.out.println(sc==sd);//true

        //布尔值拓展
        boolean flag=true;
        if(flag){}
        if(flag==true){}
    }
}
