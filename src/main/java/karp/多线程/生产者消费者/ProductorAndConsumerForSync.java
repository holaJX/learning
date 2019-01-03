package karp.多线程.生产者消费者;

/**
 * @Author: pjx
 * @Date: 2019/1/2 13:53
 * @Version 1.0
 */
public class ProductorAndConsumerForSync {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        final Productor p=new Productor(clerk);
        Consumer c =new Consumer(clerk);
       new  Thread(p,"生产者A").start();
        new  Thread(p,"消费者B").start();
    }
}
