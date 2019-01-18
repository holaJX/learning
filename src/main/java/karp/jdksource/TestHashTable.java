package karp.jdksource;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

/**
 * @Author: pjx
 * @Date: 2019/1/18 11:55
 * @Version 1.0
 */
public class TestHashTable {

    public static void main(String[] args) {
        Random random=new Random();
        Hashtable table=new Hashtable();
        table.put("one",random.nextInt(10));
        table.put("two",random.nextInt(10));
        table.put("three",random.nextInt(10));
        System.out.println("table-->"+table);

        System.out.println("----------------------------------");
        Iterator iterator = table.keySet().iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("tabe size--->"+ table.size());
        System.out.println("key--one---->"+ table.containsKey("one"));
        System.out.println("key---two ----->"+table.containsKey("two"));
        Object three = table.remove("three");
        System.out.println(three);
        System.out.println("key ----three-->"+ table.containsKey("three"));
        System.out.println(table);

    }
}
