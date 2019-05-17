package karp.jdksource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: pjx
 * @Date: 2019/1/17 16:59
 * @Version 1.0
 */
public class TestHashMap {

//    public void indexForBucket() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        HashMap<String, String> map = new HashMap<>();
//        Method hash = map.getClass().getDeclaredMethod("hash", Object.class);
//        hash.setAccessible(true);
//        int hashOfWanwanpp = (int) hash.invoke(map, "karp");
//        System.out.println(Integer.toBinaryString(hashOfWanwanpp));
//    }

    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "--");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
