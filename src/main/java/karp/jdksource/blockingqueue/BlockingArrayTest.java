package karp.jdksource.blockingqueue;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: pjx
 * @Date: 2019/1/17 15:30
 * @Version 1.0
 */
public class BlockingArrayTest {

    public static void main(String[] args) {
//        final  BlockingArray<Integer> blockingArray = new BlockingArray<>(10);
        final  BlockingArrayWithCondition<Integer> blockingArray=new BlockingArrayWithCondition<>(10);
        final AtomicInteger count =new AtomicInteger(0);
        for (int i=0;i<=1000;i++)
        {
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        blockingArray.put(count.incrementAndGet());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }

        for (int i=0;i<=1000;i++)
        {
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        blockingArray.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
