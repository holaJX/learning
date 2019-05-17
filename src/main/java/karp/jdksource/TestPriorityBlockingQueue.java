package karp.jdksource;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author: pjx
 * @Date: 2019/1/18 15:02
 * @Version 1.0
 */
public class TestPriorityBlockingQueue {

    public static void main(String[] args) {
        PriorityBlockingQueue<Student> students = new PriorityBlockingQueue<>();
        students.offer(new Student("aaa",12));
        students.offer(new Student("bbb",13));
        students.offer(new Student("ccc",9));
        System.out.println(students.poll().getName());
        System.out.println(students.poll().getName());
        System.out.println(students.poll().getName());


        System.out.println("-----------");
    }
}

class Student implements Comparable<Student> {
    private Integer age;
    private String name;

    public Student(String name,Integer age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        if(o !=null)
        {
            return   this.getAge() -o.getAge();
        }
        return 0;
    }
}