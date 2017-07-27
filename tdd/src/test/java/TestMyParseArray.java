import org.junit.Test;
import parse.array.MyParseArray;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
/**
 * Created by RENT on 2017-07-27.
 */
public class TestMyParseArray {

    @Test (expected = NumberFormatException.class)
    public void stringWithNoneElementsReturnEmptyList(){
        List<Integer> actual = MyParseArray.parseList("[]");
        assertThat(actual).isEmpty();
    }

    @Test
    public void WhenStringOneTwoThreeThenOutIs123(){
        List<Integer> actual = MyParseArray.parseList("[1,2, 3]");
        assertThat(actual).containsExactly(1,2,3);
    }

    @Test
    public void WhenStringOneTwoThreeThenWithSpacesOutIs123(){
        List<Integer> actual = MyParseArray.parseList("[1, 2, 3]");
        assertThat(actual).containsExactly(1,2,3);
    }

    @Test (expected = NumberFormatException.class)
    public void WhenStringIsWordOutIsError() {
        MyParseArray.parseList("[cokolwiek, 1, 2]");
    }

    @Test (expected = IllegalArgumentException.class)
    public void WhenFormatIsMistakeOutIsError() {
        MyParseArray.parseList("1,2");
    }


}
