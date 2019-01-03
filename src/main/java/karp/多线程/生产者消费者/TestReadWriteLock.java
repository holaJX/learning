package karp.多线程.生产者消费者;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: pjx
 * @Date: 2019/1/2 14:45
 * @Version 1.0
 * <p>
 * * 1. ReadWriteLock : 读写锁
 * <p>
 * 写写/读写 需要“互斥”
 * 读读 不需要互斥
 */
public class TestReadWriteLock {


    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.setNumber(new Random().nextInt(1000) * 101);

            }
        }, "写").start();

        for (int i = 0; i <= 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.getNumber();
                }
            }, "读取数据").start();
        }
    }
}


class ReadWriteLockDemo {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private int number;

    public int getNumber() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":" + this.number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return number;
    }

    public void setNumber(int number) {
        lock.writeLock().lock();
        try {
            this.number = number;
            System.out.println(Thread.currentThread().getName() + ":");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }


    }
}