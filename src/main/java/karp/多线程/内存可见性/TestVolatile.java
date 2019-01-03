package karp.多线程.内存可见性;

/**
 * @Author: pjx
 * @Date: 2019/1/2 8:58
 * @Version 1.0
 * 1.内存可见性：
 * 主线程中修改了flag的值 子线程中看不见
 * 解决办法：
 *   volatile 修饰的变量。内存中可见
 *
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo threadDemo=new ThreadDemo();

        new Thread(threadDemo).start();
         while (true)
         {
             if (threadDemo.isFlag())
             {
                 System.out.println("----------------------while中的--------"+threadDemo.isFlag());
                 break;
             }
         }
    }
}
class ThreadDemo implements  Runnable{

//    private boolean flag=false;
 private volatile  boolean flag=false;
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.flag=true;
        System.out.println("run中修改flag---------->"+this.flag);
    }
}