package generator;

import oop.TeddyBear;

/**
 * Created by RENT on 2017-07-22.
 */
public class TrueFalseGenerator {
    private boolean value = false;

    public boolean generate(){
        value = !value;
        return value;
    }

    public static void main(String[] args) {
        TrueFalseGenerator generator = new TrueFalseGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }

    }
}
