package karp.枚举;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pjx
 * @Date: 2018/12/25 10:25
 * @Version 1.0
 */


/**
 * 模拟星期中的表示的天，每个星期天都表示一个对象
 * 1、类中的每一个枚举成员都是该类的一个实例对象
 * 2、构造函数私有化
 * 3、提供操作枚举成员的抽象方法和静态方法
 */
public abstract class WeekDate {

    public WeekDate(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }
    /**
     * 下一天
     * @return
     */
    public abstract WeekDate nextDay();

    /**
     * 前一天
     * @return
     */
    public abstract WeekDate preDay();
    /**
     * 星期一
     */

    public static final WeekDate MON = new WeekDate("MON",0) {	//匿名子类

        @Override
        public WeekDate nextDay() {
            return TUES;
        }

        @Override
        public WeekDate preDay() {
            return WEDNES;
        }

        @Override
        public String toString() {
            return "WeekDate.MON";
        }

    };

    /**
     * 星期二
     */
    public static final WeekDate TUES = new WeekDate("TUES",1) {	//匿名子类

        @Override
        public WeekDate nextDay() {
            return WEDNES;
        }

        @Override
        public WeekDate preDay() {
            return MON;
        }

        @Override
        public String toString() {
            return "WeekDate.TUES";
        }

    };

    /**
     * 星期二
     */
    public static final WeekDate WEDNES = new WeekDate("WEDNES",2) {	//匿名子类

        @Override
        public WeekDate nextDay() {
            return MON;
        }

        @Override
        public WeekDate preDay() {
            return TUES;
        }

        @Override
        public String toString() {
            return "WeekDate.WEDNES";
        }

    };

    /**
     * 枚举名称
     */
    private final String name;

    public String getName() {
        return name;
    }

    public int getOrdinal() {
        return ordinal;
    }

    /**
     * 枚举成员的顺序
     */
    private final int ordinal;

    /**
     * 保存枚举成员
     */
    private static WeekDate[] values = {
            MON,TUES,WEDNES
    };
    private static Map<String, WeekDate> valueMap = new HashMap<String, WeekDate>();
    //初始化
    static {
        valueMap.put("MON", values[0]);
        valueMap.put("TUES", values[1]);
        valueMap.put("WEDNES", values[2]);
    }
}
