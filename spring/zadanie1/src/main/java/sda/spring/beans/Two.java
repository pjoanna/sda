package sda.spring.beans;

public class Two {
    private One one;

    public Two(One one) {
        this.one = one;
    }

    public One getOne() {
        return one;
    }

    public void setOne(One one) {
        this.one = one;
    }
}
