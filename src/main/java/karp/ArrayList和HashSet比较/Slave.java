package karp.ArrayList和HashSet比较;

/**
 *
 */
public class Slave {
    private int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int y;

    public Slave(int x, int y) {
        this.setX(x);
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Slave slave = (Slave) o;

        if (getX() != slave.getX()) return false;
        return y == slave.y;

    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + y;
        return result;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
