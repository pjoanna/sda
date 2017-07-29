package parse.array;

import org.junit.Test;
import parse.array.Statistic;

import static org.assertj.core.api.Assertions.*;
import java.util.Collections;

/**
 * Created by RENT on 2017-07-29.
 */
public class TestMean {

    @Test
    public void meanFromEmptyListShouldReturn0() {
        double actual = Statistic.mean(Collections.emptyList());
        assertThat(actual).isEqualTo(0.0);
    }

    @Test
    public void meanFrom23ShouldReturn2AndHalf() {
    //    double actual = Statistic.mean(Utils.newListCreate(2,3));
     //   assertThat(actual).isEqualTo(2.5);
    }
}
