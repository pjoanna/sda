package sda.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myComponent")
public class MyComponent {
    @Value("${myComponent.count}")
    private int count;

    public MyComponent() {

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
