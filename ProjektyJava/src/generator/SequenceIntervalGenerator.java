package generator;

/**
 * Created by RENT on 2017-07-22.
 */
public class SequenceIntervalGenerator {
    private int counter = 0;
    private int start = 10;
    private int end = 20;

    public SequenceIntervalGenerator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int generate(){
        return counter++%(end-start+1)+start;
    }

    public static void main(String[] args) {
        SequenceIntervalGenerator generator = new SequenceIntervalGenerator(13,18);
        for (int i = 0; i < 25; i++) {
            System.out.println(generator.generate());
        }

    }
}

