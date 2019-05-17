package karp.可变参数;

/**
 * @Author: pjx
 * @Date: 2018/12/21 13:42
 * @Version 1.0
 */
public class VariableParameter {
    public static void main(String[] args) {
        System.out.println( add(10,19));
        System.out.println(add(1,2,3,4,5,6,7,8,9));
        System.out.println("------------------------------------");
    }
    //...代表可变参数
    private  static   int add(int origin,int ...args)
    {
        int  sum = origin;
        for (   int arg :args){
            sum+=arg;
        }
        return  sum;


    }
}
