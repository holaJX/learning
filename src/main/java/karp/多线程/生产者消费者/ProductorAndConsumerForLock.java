package karp.多线程.生产者消费者;

/**
 * @Author: pjx
 * @Date: 2019/1/2 13:41
 * @Version 1.0
 *
 * 生产者-消费者模式
 */
public class ProductorAndConsumerForLock {

    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Productor p=new Productor(clerk);
        Consumer c =new Consumer(clerk);

        new Thread(p, "生产者 A").start();
		new Thread(c, "消费者 B").start();
    }
}
