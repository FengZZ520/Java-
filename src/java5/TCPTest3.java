package java5;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地，并返回“发送成功”给客户端，
 * 并关闭连接
 * @author 冯振卓
 * @ 2021/12/15 18:23
 */
public class TCPTest3 {

    /*
    这里涉及的异常，应该使用try-catch-finally处理
     */
    @Test
    public void client() throws IOException {
        //1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.
        OutputStream os = socket.getOutputStream();
        //3.
        FileInputStream fis = new FileInputStream(new File("爱.jpg"));
        //4.
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer,0,len);
        }

        //关闭数据的输出
        socket.shutdownOutput();

        //5.接受来自于服务端的数据，并显示在控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bufferr = new byte[20];
        int len1;
        while ((len1 = is.read(bufferr)) != -1){
            baos.write(bufferr,0,len1);
        }
        System.out.println(baos.toString());


        //6.
        fis.close();
        os.close();
        socket.close();
        baos.close();

    }

    /*
   这里涉及的异常，应该使用try-catch-finally处理
    */
    @Test
    public void server() throws IOException {
        //1.
        ServerSocket ss = new ServerSocket(9090);
        //2.
        Socket socket = ss.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("爱ai.jpg"));
        //5.
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        //6。服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，照片我已收到。".getBytes(StandardCharsets.UTF_8));

        //7.
        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();

    }

}
