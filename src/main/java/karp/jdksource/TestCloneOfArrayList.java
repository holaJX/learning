package karp.jdksource;

import java.util.ArrayList;

/**
 * @Author: pjx
 * @Date: 2019/1/17 16:36
 * @Version 1.0
 */
public class TestCloneOfArrayList {

    public static void main(String[] args) {
        //测试浅复制
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        ArrayList list2 = (ArrayList) list.clone();
//        list2.add(5);
//        System.out.println(list);
//        System.out.println(list2);
     //默认是浅复制  引用类型的成员变量还是指向原地址
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("karp", 19));

        ArrayList<User> list2 = (ArrayList<User>) list.clone();
        list2.get(0).age=119;
        System.out.println(list);
        System.out.println(list2);
    }

    static class User {
        public String name;
        public int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
