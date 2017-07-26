package generator.inter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by RENT on 2017-07-24.
 */
public class PersonGenerator implements Generator<Person>{
    private List<Person> people = new ArrayList<>();
    private String[] names = {"name0", "name1", "name2"};
    private String[] surnames = {"surname0", "surname1", "surname2"};
    private int[] ages = {21,24,36,47};
    private Random random = new Random();

    public Person generate(){
        return new Person(names[random.nextInt(names.length)],surnames[random.nextInt(surnames.length)], ages[random.nextInt(ages.length)]);
    }

    public static void main(String[] args) {
        PersonGenerator generator = new PersonGenerator();
        GeneratorMethods.printTenElements(generator);
    }



}
