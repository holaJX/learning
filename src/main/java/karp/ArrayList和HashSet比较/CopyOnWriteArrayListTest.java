package karp.ArrayList和HashSet比较;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: pujx
 * @Date: 2019/5/28 10:04
 */
public class CopyOnWriteArrayListTest {


    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i <= 100000; i++) {
            ThreadTest threadTest = new ThreadTest(i);
            pool.submit(threadTest);
        }
    }

    static class ThreadTest implements Runnable {
        //        CopyOnWriteArrayList  arrayList =new CopyOnWriteArrayList();
        ArrayList arrayList = new ArrayList();

        public ThreadTest(int i) {
            arrayList.add(i);
        }

        @Override
        public void run() {
//            System.out.println("------------"+Thread.currentThread());
            arrayList.forEach(e -> System.out.println(e));
        }
    }
}
