package karp.多线程;

/**
 * @Author: pjx
 * @Date: 2018/12/26 15:28
 * @Version 1.0
 */


/**
 * 线程的生命周期

 新建(New)、就绪（Runnable）、运行（Running）、阻塞(Blocked)和死亡(Dead)5种状态
 */
/**
 * 1、多个thread对同一个java实例的访问（read和modify）不会相互干扰，
 * 它主要体现在关键字synchronized。
 * 如ArrayList和Vector，HashMap和Hashtable（后者每个方法前都有synchronized关键字）。
 * 如果你在interator一个List对象时，其它线程remove一个element，问题就出现了。
 *
 *
 2、每个线程都有自己的字段，而不会在多个线程之间共享。
 它主要体现在java.lang.ThreadLocal类，而没有Java关键字支持，如像static、transient那样。

 *
 *
 * 悲观锁 乐观锁
 * 比如数据库方面。
 悲观锁就是for update（锁定查询的行）
 乐观锁就是 version字段（比较跟上一次的版本号，如果一样则更新，如果失败则要重复读-比较-写的操作。）

 *
 *
 * JDK方面：
 悲观锁就是sync
 乐观锁就是原子类（内部使用CAS实现）

 本质来说，就是悲观锁认为总会有人抢我的。
 乐观锁就认为，基本没人抢。
 */

public class FirstThreadTest extends Thread  {

    int i=0;
    public void run() {
        for(;i<100;i++){
            System.out.println(getName()+"  "+i);
        }
    }

    public static void main(String[] args) {
        for(int i = 0;i< 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+"  : "+i);
            if(i==20)
            {
                new FirstThreadTest().start();
                new FirstThreadTest().start();
            }
        }

    }
}
