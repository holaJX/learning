package karp.jdksource;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @Author: pjx
 * @Date: 2019/1/22 10:27
 * @Version 1.0
 */
public class WaitForever {
    public static Object monitor = new Object();
    static long start;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("马上执行wait (3000)方法");
                synchronized (monitor) {
                    start = System.currentTimeMillis();
                    try {
                        monitor.wait(3000);
                        System.out.println("wait方法结束了");
                        System.out.println("等待了" + (System.currentTimeMillis() - start) / 1000 + "秒。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(100);
        synchronized (monitor) {
            Thread.sleep(500000);
        }
    }
}
