package com.atguigu.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
动态代理
 */
interface Human{
    String getBelief();
    void eat(String food);
}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly.";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}
class HumanUtil{
    public void method1(){
        System.out.println("================通用方法1======================");
    }
    public void method2(){
        System.out.println("================通用方法2======================");
    }
}
/*
问题1:如何根据加载到内存中的被代理类，动态地创建一个代理类及其对象
问题2：当通过代理类地对象调用方法时，如何动态地调用被代理类中的同名方法
 */
class ProxyFactory{
    //调用此方法，返回一个代理类的对象
    public static Object getProxyInstance(Object obj){//obj：被代理类的对象
        MyInvocationHandler handler=new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);

    }
}
class MyInvocationHandler implements InvocationHandler{
    //通过代理类的对象调用方法a时，就会自动地调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能声明在invoke()中
    private Object obj;//需要使用被代理类的对象进行赋值
    public void bind(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil util=new HumanUtil();
        util.method1();
        //method:即为代理类对象调用的方法，此方法也为被代理类的对象要调用的方法
        //obj：被代理类的对象
       Object returnValue=method.invoke(obj,args);
       util.method2();
       //上述方法的返回值就作为当前类中的invoke()的返回值
       return returnValue;
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("apple");
        System.out.println("*******************************");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();
    }
}
