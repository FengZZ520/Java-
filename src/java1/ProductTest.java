package java1;

/**
 * 线程通讯的应用：经典例题：生产者/消费者问题
 *  生产者（Productor）将产品交给电源（Clerk），而消费者（Customer）从店员处取走产品，
 *  店员一次稚嫩那个持有固定数量的产品（比如：20），如果生产者试图生产更多的产品，店员
 *  会叫生产者停一下，如果殿中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店
 *  员会告诉消费者等一下，如果点中有产品了在通知消费者取走产品。
 *
 *  分析：
 *  1.是否有多线程问题？    是，生产者线程，消费者线程
 *  2.是否有线程安全问题？    是，店员（或产品）
 *  3.如何解决线程的安全问题？  同步机制，有三种方法
 *  4.是否涉及线程通信》 是
 *
 * @author 冯振卓
 * @ 2021/11/27 21:06
 */

class Clerk{

    private int productCount = 0;
    //生产产品
    public synchronized void produceProduct() {
        if (productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + productCount + "个产品");

            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if (productCount > 0){
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productCount + "个产品");
            productCount--;

            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producter extends  Thread{//生产者

    private Clerk clerk;
    public Producter(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "：开始生产产品。。。");
        
        while (true){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread{//消费者
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "：开始消费产品。。。");

        while (true){

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}


public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producter p1 = new Producter(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");
        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();

    }
}
