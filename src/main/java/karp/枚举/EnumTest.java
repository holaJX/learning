package karp.枚举;

/**
 * @Author: pjx
 * @Date: 2018/12/21 13:50
 * @Version 1.0
 */
public class EnumTest {
    /**
     * 枚举测试
     * @param args
     */
    public static void main(String[] args) {
//          WeekDate  weekDate =WeekDate.MON;
//        System.out.println(weekDate.nextDay());
//        System.out.println(weekDate.preDay());
//        System.out.println(weekDate.getName());
//        System.out.println("------------------");


//        //使用JDK中提供的枚举特性功能应用
//        WeekDateEnum weekDateEnum = WeekDateEnum.MON;	//获得一个枚举对象
//        System.out.println(WeekDate.values().length); 	//获得枚举成员数量
//        System.out.println(weekDateEnum.name());		//获得枚举的字符串名称
//        System.out.println(weekDateEnum.toString());	//打印枚举对象，已重写toString方法，默认打印枚举的名称
//        System.out.println(weekDateEnum.nextDay().ordinal());	//枚举成员列表中的位置
//        System.out.println(WeekDateEnum.valueOf("FRI").nextDay().ordinal());
//        System.out.println("---------------遍历枚举成员，使用JDK的枚举特性-------------------------");
//        for (WeekDateEnum enumDemo : WeekDateEnum.values()) {
//            System.out.println(enumDemo);
//        }

        WeekDateEnum  weekDateEnum = WeekDateEnum.MON;
        System.out.println(weekDateEnum.ordinal());
        System.out.println(weekDateEnum.name());
        System.out.println("---------------遍历枚举成员，使用JDK的枚举特性-------------------------");


        System.out.println(weekDateEnum.getOrgin()==1);

        System.out.println(weekDateEnum.getDesc()=="星期一");
        System.out.println(WeekDateEnum.values().length);
        System.out.println(weekDateEnum.name());
        for (WeekDateEnum weekDateEnum1: WeekDateEnum.values()){
            System.out.println(weekDateEnum1.name()+"-->值为="+  weekDateEnum1.getOrgin() +"描述："+weekDateEnum1.getDesc());
        }
//        System.out.println(WeekDateEnum.values().toString());
    }
}
