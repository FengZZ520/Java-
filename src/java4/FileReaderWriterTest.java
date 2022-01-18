package java4;

/**
 * 一、流的分类
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类             节点流（或文件流）                                   缓冲流（处理流的一种）
 * InputStream          FileInputStream （read(byte[]buffer)）             BufferedInputStream（read(byte[]buffer)）
 * OutputStream         FileOutputStream （write(byte[]buffer,0,len)）     BufferedOutputStream（write(byte[]buffer,0,len)）/flush()
 * Reader               FileReader （read(char[]cbfu)）                    BufferedReader（read(char[]cbfu)）/readLine()
 * Writer               FileWriter （write(char[]cbfu,0,len)）             BufferedWriter（write(char[]cbfu,0,len)）/flush()
 *
 *
 * @author 冯振卓
 * @ 2021/12/11 17:28
 */
public class FileReaderWriterTest {
}
