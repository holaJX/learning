package karp.ArrayList和HashSet比较;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pjx
 * @Date: 2018/12/26 14:08
 * @Version 1.0
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<Employee,String> map =new HashMap<>();
        Employee employee1=new Employee(1);
        employee1.setName("karp1");
        Employee employee2=new Employee(1);
        employee2.setName("karp2");
        Employee employee3=new Employee(3);
        employee3.setName("karp3");
        map.put(employee1,"测试哈哈哈哈");
        map.put(employee2,"车上发大水发的撒是发生");
        map.put(employee3,"asdfadfasdfasdf");

        System.out.println(map);
    }
}

class Employee {
    // It is specified while object creation.
    // Cannot be changed once object is created. No setter for this field.
    private int id;
    private String name;

    public Employee(final int id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    // Hash code depends only on 'id' which cannot be
    // changed once object is created. So hash code will not change
    // on object's state change
    @Override
    public int hashCode() {
        return  this.id;
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + id;
//        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        return true;
    }
}