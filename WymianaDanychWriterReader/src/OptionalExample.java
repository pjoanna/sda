import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by pjoanna on 2017-08-07.
 */
public class OptionalExample {

    public static boolean allMatch(List<Integer> numbers, Predicate<Integer> predicate) {
        for (Integer number : numbers) {
            if (!predicate.test(number)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Optional<Integer> max = Arrays.asList(1,2,2,32).stream().max(Integer::compareTo);

        boolean allSmallerThan100 = allMatch(Arrays.asList(1, 2, 109), i -> (i <= 100));
        System.out.println(allSmallerThan100);
    }
}
