package java4;

import org.junit.Test;

import java.io.File;

/**
 * File类的使用
 *
 * 1.File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *   并未涉及到写入或读取文件内容的操作。如果需要写入或读取文件内容，必须使用IO0流来完成。
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”。
 *
 * @author 冯振卓
 * @ 2021/12/9 18:37
 */
public class FileTest {
    /*
    1.如何创建File类的实例
    File(String filePath);
    File(String parentPath,String childPath);
    File(File parentPath,String childPath);

    2.
    相对路径：相较于某个路径下，指明的路径
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
    windows：\\
    unix：/
     */

    @Test
    public void test1(){

        //构造器1：
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\java file saving idea\\javaBasics\\src\\java4\\he.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器2：
        File file3 = new File("D:\\java file saving idea", "javaBasics");
        System.out.println(file3);

        //构造器3：
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);


    }


    /*
    public String getAbsolutePath()：获取绝对路径
    public String getPath()：获取路径
    public String getName()：获取名称
    public String getParent()：获取文件长度（即：字节数），不能获取目录的长度
    public long length()：获取最后一次的修改时间：毫秒值

    public String[] list()：获取指定目录下的所有文件或者文件目录的名称数组
    public file[] listFiles()：获取指定目录下的所有文件或者文件目录的File数组
     */

    @Test
    public void test2(){

    }

    @Test
    public void test3(){
        File file = new File("D:\\java file saving idea\\javaBasics\\src");

        String[] list = file.list();
        for (String s : list){
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        for (File f : files){
            System.out.println(f);
        }
    }

    /*
    public boolean renameTo(File dest)：把文件重命名为指定的文件路径
        比如：file1.renameTo(file2)为例
            想要保证返回true，需要file1在硬盘中是存在的，且file2不能在硬盘中存在
     */
    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);


    }

    /*
    public boolean isDirectory()：判断是否是文件目录
    public boolean isFile()：判断是否是文件
    public boolean exists()：判断是否存在
    public boolean canRead()：判断是否可读
    public boolean canWrite()：判断是否可写
    public boolean isHidden()：判断是否隐藏

     */

    @Test
    public void test5(){

    }


    /*
    public boolean createNewFile()：创建文件。若文件存在，则不创建，返回false
    public boolean mkdir()：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
    public boolean mkdirs()：创建文件目录，如果上层文件目录不存在，一并创建。
    注意：如果你创建文件或者文件目录没有写盘符路径，那么默认在项目路径下

    public boolean delete()：删除文件或文件夹
    注意：Java中的删除不走有回收站
    要删除一个文件目录，请注意该文件目录内不能包含文件或文件目录
     */

    @Test
    public void test6(){

    }

    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("d:\\io\\io1\\io2");

        boolean mkdir = file1.mkdir();
        if (mkdir){
            System.out.println("创建成功1");
        }

        File file2 = new File("d:\\io\\io1\\io4");

        boolean mkdir1 = file2.mkdirs();
        if (mkdir1){
            System.out.println("创建成功2");
        }

        File file3 = new File("d:\\io\\io1\\io4");

        boolean delete = file3.delete();
        if (delete){
            System.out.println("删除成功");
        }
    }

}
