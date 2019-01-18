package karp.jdksource;

import sun.misc.PostVMInitHook;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author: pjx
 * @Date: 2019/1/18 15:27
 * @Version 1.0
 */
public class TestReferenceQueue {

    /**
     * 可以参考
     * http://www.cnblogs.com/jabnih/p/6580665.html
     *  https://vinoit.me/2017/06/23/java-phantom-reference/
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        //强引用FinalReference
        //软引用SoftReference
//        弱引用WeakReference
        //虚引用PhantomReference

//        String abc = new String("abc");
//        final ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
//        WeakReference<String> abcWeakRef = new WeakReference<String>(abc,
//                referenceQueue);
//        abc = null;
//        System.gc();
//        Thread.currentThread().sleep(3000);

        String abc = new String("abc");
        final ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
        PhantomReference<String> abcWeakRef = new PhantomReference<String>(abc,
                referenceQueue);
        abc = null;
        System.gc();
        Thread.currentThread().sleep(3000);
//
//        明明已经GC了，可实际对象依旧没有被回收。需要手动调用引用对象的clear方法来回收。利用这个特效，
// 可以用来做一些最后的清理工作。例如ByteBuffer的Cleaner对象，JVM的Reference Handler线程会调用clean()方法。
    }
}
