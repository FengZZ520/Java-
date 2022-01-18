package java4;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream和ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来
 * 3.要想一个Java对象是可序列化的，需要满足相应的要求，见Person.java
 *
 * @author 冯振卓
 * @ 2021/12/13 18:57
 */
public class ObjectInputOutputStream {

    /*
    序列化过程：将内存中的Java对象保存到磁盘中或通过网络传播出去
    使用ObjectOutputStream实现
     */

    @Test
    public void testObjectInputOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object,dat"));
            oos.writeObject(new String("我爱中国"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("王明",23));
            oos.flush();

            oos.writeObject(new Person("张学良",23,new java4.Account(5000)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /*
    反序列化：将磁盘文件中的对象还原为内存中的一个Java对象
    使用ObjectInputStream来实现
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            Person p = (Person) ois.readObject();
            Person p1 = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
