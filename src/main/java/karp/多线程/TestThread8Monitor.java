package karp.多线程;

/**
 * @Author: pjx
 * @Date: 2019/1/4 17:03
 * @Version 1.0
 *
 * 1. 两个普通同步方法，两个线程，标准打印， 打印? //one  two
 *
 *
 */
public class TestThread8Monitor {

    public static void main(String[] args) {
        final Number number=new Number();
        new Thread(new Runnable() {
            @Override
            public void run() {
               Number.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getTwo();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getThree();
            }
        }).start();

    }
}


class Number{
  public static synchronized void getOne() {
      try {
          Thread.sleep(200);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      System.out.println("----- one --------->");
  }

    public    void getTwo()
    {
        System.out.println("----- Two --------->");
    }
    public void  getThree()
    {
        System.out.println("-----------three------");
    }
}