package java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 三窗口卖票，继承Thread的方法
 *      使用lock解决线程安全问题
 *
         * Lock接口的概述
         *     * Lock是JDK1.5新特性
         *     * 专门用来实现线程安全的技术
         *
         * Lock接口的常用实现类
         *     * ReentrantLock：互斥锁
         *
         * Lock接口的常用方法
         *     void lock()  获取锁
         *     void unlock() 释放锁
         *
         * 注意事项
         *     * 获取锁和释放锁的代码必须成对出现。
 *
 * @author 冯振卓
 * @ 2021/11/27 18:52
 */
public class Ticket1 extends Thread{
    private static int ticket = 100;
//    final Object obj = new Object();
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){

            try {
                Thread.sleep(100);
                lock.lock ();

//           synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(getName() + "出票成功" + ticket);
                    ticket--;
                    continue;
                }
                System.out.println("余票为零");
                break;
//            }
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        Ticket1 my01 = new Ticket1();
        Ticket1 my02 = new Ticket1();
        Ticket1 my03 = new Ticket1();

        my01.setName("窗口1");
        my02.setName("窗口2");
        my03.setName("窗口3");

        my01.start();
        my02.start();
        my03.start();



    }


}

