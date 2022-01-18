package java4;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字节的输出流转换为字符的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节、字节数组---->字符数组、字符串
 *   编码：字符数组、字符串---->字节、字节数组
 *
 * 4.字符集
 *
 *
 * @author 冯振卓
 * @ 2021/12/11 19:16
 */
public class InputStreamReaderTest {

    /*
    此时处理异常的话，仍然应该使用try-catch-finally
    InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
     */
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        //参数2指明了字符集：具体使用哪个字符集，取决于文件保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        char[] cbfu = new char[20];
        int len;
        while((len = isr.read(cbfu)) != -1){
            String str = new String(cbfu,0,len);
            System.out.println(str);
        }

        isr.close();
   }

   /*
   此时处理异常的话，仍然应该使用try-catch-finally
   综合使用InputStreamReader和OutputStreamWriter
    */
    @Test
    public void test2() throws Exception {
        File file1 = new File("");
        File file2 = new File("");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        //读写过程
        char[] cbfu = new char[20];
        int len;
        while ((len = isr.read(cbfu)) != -1){
            osw.write(cbfu,0,len);
        }

        isr.close();
        osw.close();

    }

}
