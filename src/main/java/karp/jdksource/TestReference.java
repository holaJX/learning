package karp.jdksource;

/**
 * @Author: pjx
 * @Date: 2019/1/18 15:24
 * @Version 1.0
 */
public class TestReference {


    public static void main(String[] args) {
        String x=new String("adfadfafd");
        String a=x;
        System.out.println(System.identityHashCode(x));
        System.out.println(System.identityHashCode(a));
        System.out.println(a);
    }
}
