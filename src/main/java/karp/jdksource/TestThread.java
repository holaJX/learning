package karp.jdksource;

import java.util.concurrent.TimeUnit;

/**
 * @Author: pjx
 * @Date: 2019/1/21 11:12
 * @Version 1.0
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new WorkThread(previous));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(3);
    }

    static class WorkThread implements Runnable {
        private Thread previous;

        public WorkThread(Thread previous) {
            this.previous = previous;
        }
        @Override
        public void run() {
            try {
                previous.join();
                System.out.println(previous.isAlive());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}
