package karp.泛型;

/**
 * @Author: pujx
 * @Date: 2019/5/17 15:07
 */
public class Person {
    private int age;

    public Person(int age, String address, int weight) {
        this.age = age;
        this.address = address;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", weight=" + weight +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private  String address;
    private  int weight;
}
