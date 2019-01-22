package karp.jdksource;

import org.junit.Test;

import java.util.*;

/**
 * @Author: pjx
 * @Date: 2019/1/21 11:40
 * @Version 1.0
 */
public class TestTreeSet {
    public static void main(String[] args) {

    }

    @Test
    public void testMain() {
        Set<String> words = new TreeSet<String>();
        words.addAll(Arrays.asList(new String[]{
                "tree", "map", "hash", "map",
        }));
        for (String w : words) {

            System.out.println(w + " ");
        }
        System.out.println("---------------------");
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void testSortedSet() {
        SortedSet<String> set = new TreeSet<String>();
        set.addAll(Arrays.asList(new String[]{
                "c", "a", "b", "d", "f"
        }));

        System.out.println(set.first()); //a
        System.out.println(set.last()); //f
        System.out.println(set.headSet("b"));//[a]
        System.out.println(set.tailSet("d"));//[d, f]
        System.out.println(set.subSet("b", "e")); //[b, c, d]

        //对返回的视图的操作会直接影响到原来的Set
        set.subSet("b", "e").clear(); //会从原set中删除
        System.out.println(set); //[a, f]
    }

    @Test
    public void tesNavigableSet() {
        NavigableSet<String> set = new TreeSet<String>();
        set.addAll(Arrays.asList(new String[]{
                "c", "a", "b", "d","f"
        }));
        System.out.println(set.floor("a")); //a
        System.out.println(set.lower("b")); //a
        System.out.println(set.ceiling("d"));//d
        System.out.println(set.higher("c"));//d
        System.out.println(set.subSet("b", true, "d", true)); //[b, c, d]
        System.out.println(set.pollFirst()); //a
        System.out.println(set.pollLast()); //f
        System.out.println(set.descendingSet()); //[d, c, b]
    }

}
