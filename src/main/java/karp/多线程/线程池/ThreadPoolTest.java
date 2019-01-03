package karp.多线程.线程池;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.*;

/**
 * 1.线程池：类似连接池的概念：提供了一个标记了等待状态的线程队列，提高性能，避免创建和销毁而外的开销
 * 2.使用工具类中的Executors创建线程池。
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        final ThreadDemo tak = new ThreadDemo();
//        new ScheduledThreadPoolExecutor(10).execute(tak);


        /************************two &&&****************************/
//        Future<Integer> submit = pool.submit(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                int sum = 0;
//                for (int i = 0; i <= 100; i++)
//                    sum += i;
//                return sum;
//            }
//        });
//        System.out.println(submit.get());
//        pool.shutdown();
        /************************two &&&****************************/


        /************************二****************************/

//        ThreadDemo tak=new ThreadDemo();
//       for(int i=0;i<=10;i++)
//       {
//           tak.setMsg("第"+i+"轮");
//           pool.submit(tak);
//       }
//        pool.shutdown();
        /************************二****************************/

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ScheduledFuture<Integer> schedule = scheduledExecutorService.schedule(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                int sum = 0;

                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(2000);
                    System.out.println(currentThread().getName() + ":" + i);
                    sum += i;
                }
                return sum;

            }
        }, 1, TimeUnit.SECONDS);//延迟执行是时间设置。
        System.out.println(schedule.get());

    }
}


class ThreadDemo implements Runnable {
    private int i = 0;
    private String msg;

    private Lock lock = new ReentrantLock();

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (i <= 100) {

                try {
                    sleep(200);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(currentThread().getName() + getMsg() + "：" + i);
                i++;
            }
        } finally {
            lock.unlock();
        }
    }
}