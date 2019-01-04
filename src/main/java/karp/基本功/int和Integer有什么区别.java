package karp.基本功;

import java.util.List;

/**
 * @Author: pjx
 * @Date: 2019/1/4 9:04
 * @Version 1.0
 */
public class int和Integer有什么区别 {
//    int 是基本数据类型
//    Integer是其包装类，注意是一个类。
//    为什么要提供包装类呢？？？
//    一是为了在各种类型间转化，通过各种方法的调用。否则 你无法直接通过变量转化。
//    比如，现在int要转为String

    public static void main(String[] args) {
//        int a=12313;
//        String result=Integer.toString(a);
//        System.out.println(result);

        int num=Integer.valueOf("12");
        int num2=Integer.parseInt("12");
        double num3=Double.valueOf("12.2");
        double num4=Double.parseDouble("12.2");
//其他的类似。通过基本数据类型的包装来的valueOf和parseXX来实现String转为XX
        String a=String.valueOf("1234");//这里括号中几乎可以是任何类型
        String b=String.valueOf(true);
        String c=new Integer(12).toString();//通过包装类的toString()也可以
        String d=new Double(2.3).toString();

//        再举例下。比如我现在要用泛型
        List<Integer> nums;
//        这里<>需要类。如果你用int。它会报错的。
    }
}
