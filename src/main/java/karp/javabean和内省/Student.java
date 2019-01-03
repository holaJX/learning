package karp.javabean和内省;

/**
 * @Author: pjx
 * @Date: 2018/12/21 10:46
 * @Version 1.0
 */
public class Student {

    private  String name;
    private  Integer age;
    private  String addresss;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addresss='" + addresss + '\'' +
                '}';
    }

    public Student() {

    }
    public Student(String name, Integer age, String addresss) {
        this.name = name;
        this.age = age;
        this.addresss = addresss;
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

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }
}
