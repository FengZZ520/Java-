package java1;

/*
 *三个窗口同时卖票 用 实现Runnable方式
 *
 * 使用同步代码块synchronized线程安全问题
 *
 * */
public class Ticket2 implements Runnable{
    static int ticket=1;//票数
    static Object obj=new Object();
    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(2000);//停顿的时间
                synchronized (obj){//synchronized已同步
                    if (ticket<=60){
                        System.out.println("已经售出的乘车："+ticket+"号票");
                        ticket++;
                    }else {
                        System.exit(0);
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Ticket2 td2 = new Ticket2();
        Thread td = new Thread(td2);
        td.start();//开启线程

        Ticket2 td3 = new Ticket2();
        Thread thread3 = new Thread(td3);
        thread3.start();//开启线程

        Ticket2 td4 = new Ticket2();
        Thread thread4 = new Thread(td4);
        thread4.start();//开启线程

    }



}
