package karp.common;

import karp.泛型.CheckWeekVO;

/**
 * @Author: pujx
 * @Date: 2019/5/22 11:31
 */
public class MainTest {
    public static void main(String[] args) {
        CheckWeekVO vo=new CheckWeekVO();
        vo.setWeight(20);
        vo.setAge(18);
        vo.setFileunid(UnicomUtilYn.getGeneratID());
        System.out.println(ResponseDTO.success(vo));
    }
}
