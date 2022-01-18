package java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections：操作Collection、Map的工具类
 *
 *
 * 面试题：Colllection和Collections的却别？
 * @author 冯振卓
 * @ 2021/12/8 18:40
 */
public class CollectionsTest {

    /*
    reverse(List)：反转List中元素的顺序
    shuffle(List)：对List集合元素进行随机排序
    sort(Lise)：根据元素的自然顺序对指定List元素按升序排列
    sort(List,Comparator)：根据指定的Comparator产生的顺序对List集合元素进行排序
    swap(List,int,int)：将指定list集合中的i处元素和j处元素进行交换

    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection,Comparator)：根据Comparator指定的顺序，返回给定集合中的最大元素
    Object min(Collection)
    Object min(Collection.comparator)
    int frequency(Collection,Object)；返回指定集合中指定元素的出现次数
    void copy(List dest.List src)：将src中的内容复制到dest中
    Boolean replaceAll(List list,Object oldVai,Object newVai)：使用新值替换List对象的所有旧值
     */

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //报异常：IndexOutOfBoundException("Source does not fit in dest")
//        List dest = new ArrayList();
//        Collections.copy(dest,list);

        //正确的：
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//list.size
        Collections.copy(dest,list);

        System.out.println(dest);


        /*
        Collections类中提供了多个synchronizedXxx()方法，
        该方法可使得指定集合包装成线程安全的集合，从而可以解决
        多线程并发访问集合时的线程安全问题
         */

        //返回的list1即为线程安全的list
        List list1 = Collections.synchronizedList(list);
    }


    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

//        Collections.reverse(list);
        Collections.shuffle(list);

        System.out.println(list);


    }

}
