package karp.多线程.生产者消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: pjx
 * @Date: 2019/1/2 13:42
 * @Version 1.0
 */
public class Clerk {
    private int product = 0;

    //    public  synchronized void get()  {
//        while (product >= 10) {
//            System.out.println("商品已满...！");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//        System.out.println(Thread.currentThread().getName() + ":" + ++product);
//        this.notifyAll();
//    }
//    public  synchronized void sale()
//    {
//        while (product<=0)
//        {
//            System.out.println("缺货啦...！");
//        }
//        try {
//            this.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+":"+ --product);
//        this.notifyAll();
//    }
    private Lock lock = new ReentrantLock();
    private Condition condition =lock.newCondition();

    // 进货
    public void get() {
        lock.lock();

        try {
            if (product >= 1) { // 为了避免虚假唤醒，应该总是使用在循环中。
                System.out.println("产品已满！");

                try {
                    condition.await();
                } catch (InterruptedException e) {
                }

            }


            condition.signalAll();
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + " : "
                + ++product);

    }

    // 卖货
    public void sale() {
        lock.lock();

        try {
            if (product <= 0) {
                System.out.println("缺货！");

                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }



            condition.signalAll();

        } finally {
            lock.unlock();
        }
    }
//    public  void get() {
//        lock.lock();
//
//            try {
//                if (product >= 1) {
//                    System.out.println("商品已满...！");
//                }
//                try {
//                    condition.await();
//                }catch (InterruptedException ex){
//
//                }
//             condition.signalAll();
//            }
//            finally {
//                lock.unlock();
//            }
//
//
//        System.out.println(Thread.currentThread().getName() + " : "
//                + ++product);
//    }

//    public  void sale() {
//       lock.lock();
//        try {
//            if (product <= 0) {
//                System.out.println("缺货啦...！");
//            }
//           condition.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        finally {
//            lock.unlock();
//        }
//        System.out.println(Thread.currentThread().getName() + ":" + --product);
//       condition.signalAll();

//    }
}
