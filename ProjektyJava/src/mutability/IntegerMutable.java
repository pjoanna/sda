package mutability;

/**
 * Created by RENT on 2017-07-22.
 */
public class IntegerMutable {
    private int value;

    public IntegerMutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegerMutable that = (IntegerMutable) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
