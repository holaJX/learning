package karp.jdksource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: pjx
 * @Date: 2019/1/17 16:01
 * @Version 1.0
 */
public class TestAtomicReference {

    public static void main(String[] args) {
        Integer integer = 19;
        String string = "karp";

        List list = new ArrayList();
        list.add(integer);
        list.add(string);
        AtomicReference atomicReference=new AtomicReference();
        atomicReference.set(list);

        List newlist = new ArrayList();
        newlist.add(integer + 10);
        newlist.add(string + "222");

        atomicReference.compareAndSet(list, newlist);
        Object o = atomicReference.get();
        System.out.println(o);
    }
}
