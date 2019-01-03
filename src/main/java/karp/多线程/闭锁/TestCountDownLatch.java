package karp.多线程.闭锁;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: pjx
 * @Date: 2019/1/2 9:39
 * @Version 1.0
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch latch =new CountDownLatch(50);
        LatchDemo latchDemo =new LatchDemo(latch);
        long start = System.currentTimeMillis();

        for (int i = 0; i < 50; i++) {
            new Thread(latchDemo).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
        }

        long end = System.currentTimeMillis();

        System.out.println("耗费时间为：" + (end - start));

    }
}


class LatchDemo implements Runnable{

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } finally {
            latch.countDown();
        }
    }
}