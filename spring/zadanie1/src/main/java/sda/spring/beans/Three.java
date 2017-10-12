package sda.spring.beans;

public class Three {

    private Two two;

    public Three(Two two) {
        this.two = two;
    }

    public Two getTwo() {
        return two;
    }

    public void setTwo(Two two) {
        this.two = two;
    }
}
