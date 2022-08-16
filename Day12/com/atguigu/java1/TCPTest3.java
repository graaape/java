package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
例3：客户端发送文件给服务端，服务端保存文件到本地，服务端发送反馈，并关闭相应的连接
 */
public class TCPTest3 {
    @Test
    public void client() throws IOException {
        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream os= socket.getOutputStream();
        FileInputStream fis=new FileInputStream("Day12/pic.jpg");
        byte[]buffer=new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //关闭数据输出
        socket.shutdownOutput();
        InputStream is= socket.getInputStream();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        buffer=new byte[20];
        while ((len=is.read(buffer))!=-1){
            baos.write(buffer,0,len);
        }
        System.out.println(baos.toString());
        baos.close();
        is.close();
        fis.close();
        os.close();
        socket.close();
    }
    @Test
    public void server() throws IOException {
        ServerSocket ss=new ServerSocket(9090);
        Socket socket=ss.accept();
        InputStream is=socket.getInputStream();
        FileOutputStream fos=new FileOutputStream("Day12/pic2.jpg");
        byte[]buffer=new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        System.out.println("图片传输完成");
        OutputStream os=socket.getOutputStream();
        os.write("你好，我已收到照片".getBytes());
        os.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
