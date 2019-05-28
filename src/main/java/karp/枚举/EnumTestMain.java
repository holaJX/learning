package karp.枚举;

/**
 * @Author: pujx
 * @Date: 2019/5/17 16:07
 */
public class EnumTestMain {
    public static void main(String[] args) {


        System.out.println(DlTypeEnum.DLTYPE_KTWB);
        System.out.println(DlTypeEnum.getNoteByCode( DlTypeEnum.DLTYPE_KTWB.getCode()));
    }
}
