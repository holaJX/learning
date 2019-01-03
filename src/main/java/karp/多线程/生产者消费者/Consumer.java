package karp.多线程.生产者消费者;

/**
 * @Author: pjx
 * @Date: 2019/1/2 13:51
 * @Version 1.0
 */
public class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            clerk.sale();
        }
    }
}
