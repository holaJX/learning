package karp.泛型;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pjx
 * @Date: 2018/12/21 15:02
 * @Version 1.0
 */
public class 反射观察泛型擦除 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        List<Integer> integerList = new ArrayList<Integer>();
//        integerList.add(12);
//        Method add = integerList.getClass().getMethod("add", Object.class);
//        add.invoke(integerList, "123abc");
//        add.invoke(integerList, false);
//        add.invoke(integerList, new Object());
//
//        for (int i = 0; i < integerList.size(); i++) {
//            System.out.println(integerList.get(i));
//        }

        List<Integer> integerList =new ArrayList<Integer>();
        integerList.add(12);
        Method add = integerList.getClass().getMethod("add", Object.class);
        add.invoke(integerList,"1231adfadfafd");
        add.invoke(integerList,false);
        add.invoke(integerList,new Object());
        for (Object s:integerList
             ) {
            System.out.println(s);
        }
    }
}
