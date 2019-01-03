package karp.基本数据类型;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pjx
 * @Date: 2018/12/26 11:23
 * @Version 1.0
 */
public class 包装类 {
    public static void main(String[] args) {
//        int a=10;
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

        System.out.println(String.valueOf("12313"));
        System.out.println(String.valueOf(true));
        Integer aa=10;
        System.out.println(aa.toString());
        List<Integer> list=new ArrayList<>();
        list.add(11233);
        list.add(Integer.parseInt("1230") );
        System.out.println("------------------------");
        for (int s :list)
        {
            System.out.println(s);
        }


    }

}
