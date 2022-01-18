package java5;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 11.URL：统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 * http://localhost:8080/java file saving idea/爱.jpg？uswename=qianc
 * 协议    主机名    端口号    资源地址                 参数列表
 *
 * @author 冯振卓
 * @ 2021/12/17 10:25
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/java file saving idea/爱.jpg？uswename=qianc");

            //public String getProtocol()   获取该URL的协议名
            //public String getHost()   获取该URL的主机名
            //public String getPort()   获取该URL的端口号
            //public String getPath()   获取该URL的文件路径
            //public String getFile()   获取该URL的文件名
            //public String getQuery()  获取该URL的查询名



        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
