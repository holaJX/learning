package karp.类加载器;

/**
 * @Author: pjx
 * @Date: 2018/12/21 16:08
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        FileSystemClassLoader classLoader=new FileSystemClassLoader("wanwnapp","F:/tmp/");
//        Class<?> printClassLoader = classLoader.loadClass("com.wp.PrintClassLoader");
//        printClassLoader.newInstance();
        //注意是class 文件位置
        FileSystemClassLoader classLoader = new FileSystemClassLoader("ajax", "F:\\demo\\learning\\target\\classes\\karp\\类加载器\\");
        //全类名（包名+类名）
        Class<?> aClass = classLoader.loadClass("karp.类加载器.PrintClassLoader");
        Object o = aClass.newInstance();

    }
}
