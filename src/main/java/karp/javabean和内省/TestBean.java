package karp.javabean和内省;

/**
 * @Author: pjx
 * @Date: 2018/12/21 10:47
 * @Version 1.0
 */
public class TestBean {
    private  Student student;
    private  int count;

    public Student getStudent() {
        return student;
    }
    public TestBean() {

    }
    public TestBean(Student student, int count) {
        this.student = student;
        this.count = count;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "student=" + student +
                ", count=" + count +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
