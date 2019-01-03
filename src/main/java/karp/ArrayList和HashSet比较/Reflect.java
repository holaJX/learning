package karp.ArrayList和HashSet比较;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

/**
 * @Author: pjx
 * @Date: 2018/12/20 16:04
 * @Version 1.0
 */
public class Reflect {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1.读取properties配置文件的信息
        InputStream resourceAsStream = Reflect.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties =new Properties();
        properties.load(resourceAsStream);
        String className = properties.getProperty("className");
        resourceAsStream.close();
        Collection collection = (Collection) Class.forName(className).newInstance();
        Slave slave1 = new Slave(1, 1);
        Slave slave2 = new Slave(5, 5);
        Slave slave3 = new Slave(1, 1);


        collection.add(slave1);
        collection.add(slave2);
        collection.add(slave3);
        collection.add(slave1);
        System.out.println(collection.size());
        for ( Object s:collection
             ) {
            Slave s1 = (Slave) s;
            System.out.println("x-->"+s1.getX());
            System.out.println("y-->"+s1.getY());
        }

    }
}
