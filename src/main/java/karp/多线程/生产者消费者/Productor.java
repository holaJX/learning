package karp.多线程.生产者消费者;

/**
 * @Author: pjx
 * @Date: 2019/1/2 13:48
 * @Version 1.0
 */
public class Productor implements Runnable {

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    private Clerk clerk;

    @Override
    public void run() {
        System.out.println("---------------");
        for (int i = 0; i <= 20; i++) {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }
    }
}
