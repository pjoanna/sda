package sda.spring.beans;

public class MergingBean {
    private ConstructorInjected constructorInjected;
    private MyBean myBean;

    public MergingBean(ConstructorInjected constructorInjected, MyBean myBean) {
        this.constructorInjected = constructorInjected;
        this.myBean = myBean;
    }

    public ConstructorInjected getConstructorInjected() {
        return constructorInjected;
    }

    public void setConstructorInjected(ConstructorInjected constructorInjected) {
        this.constructorInjected = constructorInjected;
    }

    public MyBean getMyBean() {
        return myBean;
    }

    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }
}
