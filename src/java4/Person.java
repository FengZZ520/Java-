package java4;

import java.io.Serializable;

/**
 * Person需要满足如下的要求，方可序列化：
 * 1.需要实现接口：Serializable
 * 2.当前类提供一个全局常量：SerialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须要保证其内部所有属性
 *   也必须时可序列化的。（默认情况下，基本数据类型时可序列化的）
 *
 * 补充：ObjectInputStream和ObjectOutputStream不能同时序列化static和transient修饰的成员变量
 * @author 冯振卓
 * @ 2021/12/13 19:12
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 475463534532L;

    private String name;
    private int age;
    private Account acct;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Account acct) {
        this.name = name;
        this.age = age;
        this.acct = acct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acct=" + acct +
                '}';
    }
}

class Account implements Serializable {

    public static final long serialVersionUID = 47546534532L;

    private double balance;

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }
}