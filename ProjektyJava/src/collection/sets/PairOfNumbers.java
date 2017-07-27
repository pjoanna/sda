package collection.sets;

/**
 * Created by RENT on 2017-07-17.
 */
public class PairOfNumbers {
    private int a;
    private int b;

    public PairOfNumbers(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "{"+getA()+", "+getB()+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PairOfNumbers that = (PairOfNumbers) o;

        if (a != that.a) return false;
        return b == that.b;
    }

    @Override
    public int hashCode() {
        int result = 31 * a + b;
        return result;
    }
}
