package generator.inter;

/**
 * Created by RENT on 2017-07-24.
 */
public class StarsGenerator implements Generator<String>{

    private Generator<Integer> generator;

    public StarsGenerator(Generator<Integer> generator) {

        this.generator = generator;
    }

    @Override
    public String generate() {
        Integer generated = generator.generate();
        if (generated != null){
            String stars = "";
            for (int i = 0; i < generated; i++) {
                stars += "*";
            }
            return stars;
        } else {
            System.out.println("null");
            return null;
        }

    }

    public static void main(String[] args) {
        StarsGenerator starsGenerator = new StarsGenerator(new RandomNumbersFromIntervalGenerator(1,12));

        for (int i = 0; i < 10; i++) {
            System.out.println(starsGenerator.generate());
        }
    }
}
