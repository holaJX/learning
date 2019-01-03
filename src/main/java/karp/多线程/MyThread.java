package karp.多线程;

import java.util.Random;

/**
 * @Author: pjx
 * @Date: 2018/12/25 11:07
 * @Version 1.0
 */
public class MyThread extends Thread {

    private Work work;

    public MyThread(Work work) {
        this.work = work;
    }

    public void run() {
        Random random = new Random();
        Data data = new Data();
        int n1 = random.nextInt(9999);
        int n2 = random.nextInt(2000);
        int n3 = random.nextInt(3000);
        work.process(data,n1,n2,n3);

        System.out.println(data.value);
        System.out.println("-------------------------");
        System.out.println("n1="+n1);
        System.out.println("n2="+n2);
        System.out.println("n3="+n3);
        System.out.println("n1+n2+n3="+(n1+n2+n3));
    }

    public static void main(String[] args) {
        Thread  thread=new MyThread(new Work());
        thread.start();
    }
}


class Data {
    public int value = 0;
}

class Work {
    public void process(Data data, Integer... numbers) {
        for (int n : numbers) {
            data.value += n;
        }
    }

}