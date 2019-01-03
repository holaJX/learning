package karp.javabean和内省;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pjx
 * @Date: 2018/12/21 10:49
 * @Version 1.0
 */
public class TestBeanUtils {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        TestBean testBean =new TestBean();
//       Student student= new Student("karp",18,"云南省禄丰县川街乡");
//       testBean.setStudent(student);
//       testBean.setCount(10);
//        System.out.println("beanUtils操作前："+testBean);
//        //获取javabean的值
//        String property = BeanUtils.getProperty(testBean, "student.addresss");
//        //设置值
//        BeanUtils.setProperty(testBean,"student.age",200);
//        System.out.println("beanUtils操作后：---->"+testBean);
//
////        Map<String, String> describe = BeanUtils.describe(testBean);
////        for (String s : describe.keySet()) {
////            System.out.println(s + " is " + describe.get(s));
////        }
//
//      //javabean和内省 转换为map对象
//        Map<String,String> describe = BeanUtils.describe(testBean);
//        for (String s :
//                describe.keySet())
//            System.out.println("key="+s+ "----->value="+describe.get(s));


        //将map对象填充至javabean实例中。
//        Map<String, Object> map = new HashMap<String, Object>();
//        TestBean testBean1 = new TestBean();
//        map.put("num", 18);
//        map.put("name", "wanwanpp");
//        BeanUtils.populate(testBean1, map);
//        System.out.println(BeanUtils.getProperty(testBean1,"name"));
//
//        System.out.println(map);

        Map<String,Object> map =new HashMap<String ,Object>();
        map.put("student",new Student("普加学",19,"昆明"));
        map.put("count",100);
        TestBean testBean1 =new TestBean();
        BeanUtils.populate(testBean1,map);
        System.out.println(testBean1);

    }
}
