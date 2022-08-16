package com.atguigu.java;
/*
静态代理
代理类和被代理类在编译期间就被确定
 */
interface ClothFactory{
    void produceCloth();
}
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//用被代理类的对象进行实例化
    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理工厂进行准备工作");
        factory.produceCloth();
        System.out.println("代理工厂进行收尾工作");
    }
}
//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nike=new NikeClothFactory();
        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}
