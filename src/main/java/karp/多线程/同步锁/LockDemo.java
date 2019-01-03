package karp.多线程.同步锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: pjx
 * @Date: 2019/1/2 11:26
 * @Version 1.0
 * 一、解决多线程安全问题
 * 1.同步代码块
 * 2.同步方法
 * jdk1.5以后： lock 同步锁
 * 注意：是一个线程锁： lock()方法上锁；unlock()方法解锁；
 **/

public class LockDemo {
    public static void main(String[] args) {
        Tick tick =new Tick();
        for(int i=0;i<=100;i++)
        {
            new Thread(tick,"当前售票窗口"+i).start();
        }
    }
}

class Tick implements Runnable {
    private int tickNumber=100;
   private Lock lock=new ReentrantLock();
    public int getTickNumber() {
        return tickNumber;
    }

    public void setTickNumber(int tickNumber) {
        this.tickNumber = tickNumber;
    }

    @Override
    public void run() {
        try {

                Thread.sleep(200);
                lock.lock();//加锁
                if (this.tickNumber > 0) {
                    System.out.println(Thread.currentThread().getName() + "当前余票为：" + --tickNumber);
                }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//释放锁
        }

    }
}