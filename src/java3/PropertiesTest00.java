package java3;

import java.io.File;

/**
 *解决问题的 排错代码
 *
 *java.io.FileNotFoundException: jdbc.properties (系统找不到指定的文件。)
 *
 * @author 冯振卓
 * @ 2021/12/8 18:36
 */
public class PropertiesTest00 {
    public static void main(String[] args) {
        File file = new File("jdbc.properties");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
    }

}
