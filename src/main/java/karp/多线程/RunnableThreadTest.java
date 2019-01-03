package karp.多线程;

/**
 * @Author: pjx
 * @Date: 2018/12/26 15:30
 * @Version 1.0
 * 没有返回值：
 * 1.现实Runnable接口
 * 2.继承Thread类
 * 有返回值的：
 * 3.实现CallAble
 * 4.线程池
 */
public class RunnableThreadTest implements  Runnable {

    private int i;
    public void run()
    {
        for(i = 0;i <100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
    public static void main(String[] args)
    {
        for(int i = 0;i < 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20)
            {
                RunnableThreadTest rtt = new RunnableThreadTest();
                new Thread(rtt,"新线程1").start();
                new Thread(rtt,"新线程2").start();
            }
        }
    }
}
