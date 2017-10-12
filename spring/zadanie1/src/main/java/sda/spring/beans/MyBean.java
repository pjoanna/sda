package sda.spring.beans;

public class MyBean {
    private boolean flag;
    private String name;
    private int count;
    private SimpleBean simpleBean;

    public MyBean(boolean flag, String name, int count, SimpleBean simpleBean) {
        this.flag = flag;
        this.name = name;
        this.count = count;
        this.simpleBean = simpleBean;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public SimpleBean getSimpleBean() {
        return simpleBean;
    }

    public void setSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}
