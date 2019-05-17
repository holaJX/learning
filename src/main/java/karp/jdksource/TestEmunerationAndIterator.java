package karp.jdksource;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

/**
 * @Author: pjx
 * @Date: 2019/1/17 16:52
 * @Version 1.0

//Emuneration速度快一点，因为Iterator支持fail-fast，操作会多一些。
//Emuneration在jdk1.0时设计，Iterator在1.2时产生。
//Iterator中多了一个remove方法，可以进行集合的修改
 */
public class TestEmunerationAndIterator {

    public static void main(String[] args) {
        int val;
        Random r = new Random();
        Hashtable table = new Hashtable();
        for (int i = 0; i < 30000000; i++) {
            // 随机获取一个[0,100)之间的数字
            val = r.nextInt(100);
            table.put(String.valueOf(i), val);
        }

        // 通过Iterator遍历Hashtable
        iterateHashtable(table);

        // 通过Enumeration遍历Hashtable
        enumHashtable(table);
    }
    /*
     * 通过Iterator遍历Hashtable
     */
    private static void iterateHashtable(Hashtable table) {
        long startTime = System.currentTimeMillis();

        Iterator iter = table.entrySet().iterator();
        while (iter.hasNext()) {
            //System.out.println("iter:"+iter.next());
            iter.next();
        }

        long endTime = System.currentTimeMillis();
        countTime(startTime, endTime);
    }
    private static void enumHashtable(Hashtable table) {
        long startTime = System.currentTimeMillis();

        Enumeration enu = table.elements();
        while (enu.hasMoreElements()) {
            //System.out.println("enu:"+enu.nextElement());
            enu.nextElement();
        }

        long endTime = System.currentTimeMillis();
        countTime(startTime, endTime);
    }

    private static void countTime(long start, long end) {
        System.out.println("time: " + (end - start) + "ms");
    }
}
