package karp.多线程.同步锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: pjx
 * @Date: 2019/1/2 11:46
 * @Version 1.0
 */
public  class synchronizedDemo {
    public static void main(String[] args) {
        syncTick tick = new syncTick();
        for (int i = 0; i <= 20; i++) {
            synchronized (new Object()) {
                new Thread(tick, "当前售票窗口为" + i).start();
            }
        }
    }
}

class syncTick implements Runnable {
    private int tickNumber = 100;

    public int getTickNumber() {
        return tickNumber;
    }

    public void setTickNumber(int tickNumber) {
        this.tickNumber = tickNumber;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(200);
                if (this.tickNumber > 0) {
                    System.out.println(Thread.currentThread().getName() + "当前余票为：" + --tickNumber);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//
        }

    }
}