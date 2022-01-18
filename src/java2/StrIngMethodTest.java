package java2;


import org.junit.Test;

/**
 * @author 冯振卓
 * @ 2021/11/29 11:06
 */
public class StrIngMethodTest {

    /*
    String replace(char oldChar,char newChar)
     */







    /*
    boolean contains(CharSequence s)：当且仅当此字符串包含指定的char值序列时，返回true
    Int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
    Int indexOf(String str,int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
    Int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
    Int lastIndexOf(String str,int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始反向搜索
    注意：indexOf和lastIndexOf方法如果未找到都时返回-1


     */




    /*
    boolean endsWith(String suffix)：测试此字符串是否已指定的后缀开始
    boolean endsWith(String prefix)：测试此字符串是否已指定的后缀开始
    boolean endsWith(String prefix,int toffset)：测试了此字符串从指定索引开始的子字符串是否以指定前缀开始
     */


    /*
    int length()：返回字符串的长度：return value.length
    char charAt(int index)：返回某索引处的字符return value[index]
    boolean isEmpty()：判断是否是空字符串：return value.length == 0
    String toLowerCase()：使用默认语言环境，将String中的所有字符转换为小写
    String toUpperCase()：使用默认语音环境，将String中的所有字符转化为大写
    String trim()：返回字符串的副本，忽略前导空白和尾部空白
    boolean equals(Object obj)：比较字符串的内容是否相等
    boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
    String concat(String str)：将指定字符串连接到此字符串的结尾，等价于用“+”
    int compareTo(String anotherString)：比较两个字符串的大小
    String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串
    String substring(int beginIndex,int endIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到rndIndex（不包括）的一个子字符串

     */


    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));//false
        System.out.println(s1.equalsIgnoreCase(s2));//true

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);//abcdef

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//-2，比较ASCII

        String s7 = "郑州商学院";
        String s8 = s7.substring(2);
        System.out.println(s7);//郑州商学院
        System.out.println(s8);//商学院

        String s9 = s7.substring(2,3);
        System.out.println(s9);//商
    }


    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));
//        System.out.println(s1.charAt(10));
//        s1 = "";
        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s1);//HelloWorld，s1不可变，仍然为原来的字符串
        System.out.println(s2);//helloworld，改成小写以后的字符串

        String s3 = "      hell o  wor  l d  ";
        String s4 = s3.trim();
        System.out.println("---------" + s3 + "---------");//---------      hell o  wor  l d  ---------
        System.out.println("---------" + s4 + "---------");//---------hell o  wor  l d---------

    }


}
