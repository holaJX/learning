package karp.枚举;

import sun.security.provider.Sun;

/**
 * @Author: pjx
 * @Date: 2018/12/25 10:37
 * @Version 1.0
 */
public enum WeekDateEnum {
    MON(1, "星期一"),
    TUES(2, "星期二"),
    WEDNES(3, "星期三"),
    THURS(4, "星期四"),
    FRI(5, "星期五"),
    SATUR(6, "星期六"),
    SUN(7, "星期天");

    public int getOrgin() {
        return orgin;
    }

    public void setOrgin(int orgin) {
        this.orgin = orgin;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private int orgin;
    private String desc;

    WeekDateEnum(int orgin, String desc) {
        this.orgin = orgin;
        this.desc = desc;
    }

    public int toValue() {
        return this.orgin;
//        switch (this) {
//            case MON:
//                return  MON.orgin;
//            case TUES:
//                return TUES.orgin;
//            case WEDNES:
//                return WEDNES.orgin;
//            case THURS:
//                return THURS.orgin;
//            case FRI:
//                return FRI.orgin;
//            case SATUR:
//                return SATUR.orgin;
//            case SUN:
//                return SUN.orgin;
//            default:
//                return -1;
//        }
    }

    public String toDescribe() {
        return this.desc;
    }
}
