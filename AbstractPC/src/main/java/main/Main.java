package main;

import pc.AbstractPCWithFactory;

/**
 * Created by RENT on 2017-08-08.
 */
public class Main {
    public static void main(String[] args) {
    AbstractPCWithFactory pc = AbstractPCWithFactory.createApplePC1();
    pc = AbstractPCWithFactory.createApplePC1().createAsusPC2();
    }
}
