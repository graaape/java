package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/*
其他流的使用
1.标准的输入、输出流
2.打印流
3.数据流
 */
public class OtherStreamTest {
    /*
    标准的输入、输出流
    练习：
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作，直至当输入“e”或“exit”时，退出程序。
     方法1：使用Scanner实现,调用next()返回一个字符串
     方法2：使用System.in实现-->转换流--->BufferedReader的readLine()
     */
    public static void main(String[] args) {
        BufferedReader br= null;
        try {
            InputStreamReader isr=new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true){
                System.out.println("请输入字符串:");
                String data=br.readLine();
                if("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase=data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    打印流：PrintStream PrintWriter
     */
    @Test
    public void test2(){
        PrintStream ps= null;
        try {
            FileOutputStream fos=new FileOutputStream(new File("Day11/text.txt"));
            //创建打印输出流，设置为自动刷新模式（写入换行符或字节‘\n’时都会刷新缓冲区）
            ps = new PrintStream(fos,true);
            if(ps!=null){
                System.setOut(ps);//把标准输出流（控制台输出）改为文件
            }
            for (int i = 0; i <=255 ; i++) {//输出ASCII字符
                System.out.print((char) i);
                if(i%50==0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                ps.close();
            }
        }
    }
    /*
    数据流
    练习：将内存中的字符串、基本数据类型的变量写出到文件中。
     */
    @Test
    public void test3() throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("Day11/data.txt"));
        dos.writeUTF("小明");
        dos.flush();//将内存中的数据写入文件
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();
        dos.close();
    }
    /*
    将文件中存储的字符串、基本数据类型读取到内存中，保存到变量中。
    读取不同类型的数据的顺序要与当初写入文件时的顺序一致。
     */
    @Test
    public void test4() throws IOException {
        DataInputStream dis=new DataInputStream(new FileInputStream("Day11/data.txt"));
        String name=dis.readUTF();
        int age=dis.readInt();
        boolean isMale= dis.readBoolean();
        System.out.println("name="+name);
        System.out.println("age="+age);
        System.out.println("isMale="+isMale);
        dis.close();
    }
}
