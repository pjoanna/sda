package utils;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;


/**
 * Created by RENT on 2017-07-26.
 */
public class TestFivePlusFive {
    @Test
    public void fivePlusFiveShouldReturnTen(){
        int expected = 10;
        int actual = 5 + 5;
        assert actual == expected;
        assertThat(actual).isEqualTo(expected);
    }



}
