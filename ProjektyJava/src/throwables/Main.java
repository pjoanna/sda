package throwables;

import java.util.Random;

/**
 * Created by RENT on 2017-07-15.
 */
public class Main {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (MyOwnException e) {
            e.printStackTrace();
        }
    }

    public static void doSomething() throws MyOwnException{
        Random random = new Random();

        if(random.nextBoolean()) {
            throw new MyOwnException();
        }


    }
}

//runtime exception nie musi być obsłużony ale exception musi byc