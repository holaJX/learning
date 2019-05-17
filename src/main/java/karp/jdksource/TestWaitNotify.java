package karp.jdksource;

/**
 * @Author: pjx
 * @Date: 2019/1/21 14:56
 * @Version 1.0
 *
 *
 * //java.lang.IllegalMonitorStateException异常：尝试等待一个对象的监视器或者去通知其他正在等待这个对象监视器的线程，
// 但是没有拥有这个监视器的所有权。即未获取锁就调用wait或者notify
 */
public class TestWaitNotify {
    public static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {


        Thread waitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        object.wait();
                        System.out.println("waitThread线程被唤醒了");
                    } catch (InterruptedException e) {
                        //catch执行捕捉异常后的处理

                        System.out.println("waitThread线程被中断了");
                        e.printStackTrace();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        System.out.println("打印异常");
                    }
                }
            }
        });
        waitThread.start();

        System.out.println("waitThread线程已经进入wait状态。");
        Thread.sleep(1000);
        //唤醒
//        synchronized (object) {
//            object.notify();
//        }
        //中断
        waitThread.interrupt();
        Thread.sleep(1000);
    }
}
