import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.net.URI;
import java.util.List;

/**
 * Created by RENT on 2017-07-26.
 */
public class TestUtils {
    @Test
    public void divideFiveByFiveShouldReturn1(){
        double expected = 1;
        double actual = Utils.divide(5,5);
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void divideFiveByTwoShouldReturn2AndHalf(){
        double expected = 2.5;
        double actual = Utils.divide(5,2);
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void divideOneByThreeShouldReturn03(){
        //double expected = 1/3;
        double actual = Utils.divide(1,3);
        assertThat(actual).isBetween(0.333333, 0.333334);
    }
    @Test (expected = java.lang.ArithmeticException.class) // oczekujemy błędu
    public void divideOneByZeroShouldReturn2AndHalf(){
        Utils.divide(1,0);

    }

    @Test
    public void OneTwoThreeArrayEqualsOneTwoThreeArray(){
        int[] array1 = {1,2,3};
        int[] array2 = {1,2,3};
        boolean actual = Utils.arrayEquals(array1, array2);

        assertThat(actual).isTrue();
    }

    @Test
    public void OneTwoThreeArrayEqualsThreeFourFiveArray(){
        int[] array1 = {1,2,3,4,5,6,7,8,9,0};
        int[] array2 = {1,2,3,4,5,6,7,8,9};
        boolean actual = Utils.arrayEquals(array1, array2);
        assertThat(actual).isFalse();
    }

    @Test
    public void DifferentSizesTest(){
        int[] array1 = {1,2,3};
        int[] array2 = {3,4};
        boolean actual = Utils.arrayEquals(array1, array2);
        assertThat(actual).isFalse();
    }


    @Test // T type
    public void DifferentSizesOfArraysT(){
        String[] array1 = {"siema", "Ala", "ma", "kota"};
        String[] array2 = {"siema", "Ala", "ma",};
        boolean actual = Utils.arrayEqualsT(array1, array2);
        assertThat(actual).isFalse();
    }
    @Test // T type
    public void OneToSevenIsOneToSevenT(){
        Integer[] array1 = {1,2,3,4,5,6,7};
        Integer[] array2 = {1,2,3,4,5,6,7};
        boolean actual = Utils.arrayEqualsT(array1, array2);
        assertThat(actual).isTrue();
    }

    @Test // T type
    public void TwoOtherTypesOtherSizeT(){
        Integer[] array1 = new Integer[]{1,2,3,4,66};
        String[] array2 = new String[]{"siema", "Ala", "ma",};
        boolean actual = Utils.arrayEqualsT(array1, array2);
        assertThat(actual).isFalse();
    }
    @Test // T type
    public void TwoOtherTypeTheSameSizeT(){
        Integer[] array1 = new Integer[]{1,2,3,4,66};
        String[] array2 = new String[]{"siema", "Ala", "ma", "kota", "Felika"};
        boolean actual = Utils.arrayEqualsT(array1, array2);
        assertThat(actual).isFalse();
    }
    @Test // T type
    public void TheSameString(){
        String[] array1 = {"siema", "Ala", "ma", "kota"};
        String[] array2 = {"siema", "Ala", "ma","kota"};
        boolean actual = Utils.arrayEqualsT(array1, array2);
        assertThat(actual).isTrue();
    }
    @Test
    public void oneOfRandomString(){
        String[] data = {"Ala","ma","kota","a","kot","ma","Alę"};
        String actual = Utils.rand(data);
        assertThat(actual).isIn(data);
    }

    @Test
    public void nwdFor24And9Is3(){
        int actual = Utils.nwd(24,9);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void nwdFor24And5IsOne(){
        int actual = Utils.nwd(24,5);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void nwdOfTheSameTwoNumbersIsThisNumber(){
        int actual = Utils.nwd(4,4);
        int expected = 4;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void fillArrayWithFives(){
        int[] array = new int[4];
        int[] actuals = Utils.fillArray( array, 5);
        assertThat(actuals).containsOnly(5);
    }
    @Test
    public void fillArrayWithSevensHasNoFour(){
        int[] array = new int[18];
        int[] actual = Utils.fillArray(array, 7);
        assertThat(actual).doesNotContain(4);
    }

    @Test
    public void newListContainsOnlyOnes (){
        int[] elements = {1,1,1,1,1,1,1,1,1};
        List actual = Utils.newListCreate(elements);
        assertThat(actual).containsOnly(1);
    }
    @Test
    public void newListContains12(){
        int[] elements = {1,2,3,4,5,6,3,2,12,3,4,5,6,6,4};
        List actual = Utils.newListCreate(elements);
        assertThat(actual).contains(12);
    }
    @Test
    public void newListSizeIs3(){
        int[] elements = {1,2,3};
        List actual = Utils.newListCreate(elements);
        assertThat(actual.size()==3);
    }

}
