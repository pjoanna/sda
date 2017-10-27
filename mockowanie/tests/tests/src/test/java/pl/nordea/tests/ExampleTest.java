package pl.nordea.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class ExampleTest {

    @Test
    public void shouldReturnSixIfOneTwoAndThreeGiven() throws Exception {
        // given
        Example sut = new Example(); // sut = system under test
        List<Integer> integers = Arrays.asList(1,2,3);

        // when  - tych linii powinno być 1 (max. 2)
        int actual = sut.sum(integers);

        // then
       // Assert.assertEquals(6, actual);
        assertThat(actual).isEqualTo(6);
    }


}
