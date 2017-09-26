import animal.Inter;

/**
 * Created by pjoanna on 2017-09-08.
 */
public final class Outside {
    private class Inside{
        private final int i = 100;
        private void check(){}
    }
    private Inside ins  = new Inside();

    public void changeI(){
        ins.check();
       // ins.i = 90;
        Inter inter = new Inter() {
            public void inter() {
                System.out.println("inter interfejsowy");
            }
        };
        inter.inter();

    }

}
