package karp.jdksource;

/**
 * @Author: pjx
 * @Date: 2019/1/18 16:00
 * @Version 1.0
 */
public class TestString {

    public static void main(String[] args) {
        String str = "abc";
        String str1 = "abc";
        //str2中的value引用的是"abc"的地址，而不是复制abc的内容到value中

        String str2 = new String("abc");
        System.out.println(str == str1);
        System.out.println(str1 == "abc");
        System.out.println(str2 == "abc");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2.intern());
        System.out.println(str2 == str2.intern());
        //String的hashCode方法会根据value生成值。
        System.out.println(str1.hashCode() == str2.hashCode());


    }
}
