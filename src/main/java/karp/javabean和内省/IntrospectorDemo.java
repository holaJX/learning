package karp.javabean和内省;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: pjx
 * @Date: 2018/12/21 11:29
 * @Version 1.0
 */
public class IntrospectorDemo {
    String name;
    public static void main(String[] args) throws Exception{
//        IntrospectorDemo demo = new IntrospectorDemo();
//        demo.setName("Winter Lau");
//
//        //如果不想把父类的属性也列出来的话，
//        //那getBeanInfo的第二个参数填写父类的信息
//        BeanInfo bi = Introspector.getBeanInfo(demo.getClass(),Object.class);
//        PropertyDescriptor[] props = bi.getPropertyDescriptors();
//        for(int i=0;i<props.length;i++){
//            System.out.println(props[i].getName()+"="+
//                    props[i].getReadMethod().invoke(demo,null));
//        }

        TestBean testBean =new TestBean();
        Student student=new Student();
        student.setAddresss("ces");
        student.setAge(19);
        student.setName("测试阿达的说法");
        testBean.setStudent(student);
        testBean.setCount(100);
        String propertyName = "student";
        Object property = getProperty(testBean, propertyName);

        System.out.println(property);
        Student studentnew=new Student();
        studentnew.setAddresss("adfadf");
        studentnew.setAge(19);
        studentnew.setName("dsfadfsafs");
        testBean.setStudent(studentnew);
        steProperty(testBean, propertyName,studentnew);
        System.out.println(testBean);
    }

    private static void steProperty(TestBean bean, String propertyName,Object newValue) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        //使用ＡＰＩ操作属性。
        //propertyName为属性名
        PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, bean.getClass());
        //获取指定属性的get方法
        Method writeMethod = descriptor.getWriteMethod();
        writeMethod.invoke(bean, newValue);
    }


    private static Object getProperty(TestBean bean, String propertyName) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
//        Object o = null;
//        //获取JavaBean的信息。
//        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
//        //这里面只提供了返回所有属性信息的方法，无法返回具体哪一个属性的信息
//        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//        //使用迭代获取特定的属性信息
//        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
//            if (propertyDescriptor.getName().equals(propertyName)) {
//                Method readMethod = propertyDescriptor.getReadMethod();
//                o = readMethod.invoke(bean);
//                break;
//            }
//        }
//        return o;

        Object o=null;
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor p :
                propertyDescriptors) {
            if (p.getName().equals(propertyName)){
                Method readMethod = p.getReadMethod();
                 o = readMethod.invoke(bean);
                break;
            }
        }
        return  o;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
