package java4;

import java.util.List;

/**
 * 创建DAO类的对象，分别调用其save，get，update，list，delete方法来操作User对象，
 * 使用Junit单元测试类进行测试
 *
 * @author 冯振卓
 * @ 2021/12/9 18:18
 */
public class DAOTest {
    public static void main(String[] args) {
        java4.DAO<java4.User> dao = new java4.DAO<java4.User>();

        dao.save("1001",new java4.User(1001,34,"周杰伦"));
        dao.save("1002",new java4.User(1002,20,"昆凌"));
        dao.save("1003",new java4.User(1003,20,"蔡依林"));

        dao.update("1003",new java4.User(1003,30,"方文山"));

        dao.delete("1002");

        List<java4.User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);
    }
}
