package java2;

/**
 * @author 冯振卓
 * @ 2021/11/28 21:58
 */
public class StringTest1 {
    String str = new String("good");
    char[] ch ={'t','e','s','t'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest1 ex = new StringTest1();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}
