package karp.类加载器;

/**
 * @Author: pjx
 * @Date: 2018/12/21 15:59
 * @Version 1.0
 */
public class PrintClassLoader {
    public PrintClassLoader() {
        System.out.println("classLoader is " +this.getClass().getClassLoader());
    }
}
