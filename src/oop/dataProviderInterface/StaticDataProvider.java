package oop.dataProviderInterface;

/**
 * Created by RENT on 2017-07-15.
 */
public class StaticDataProvider implements DataProvider{
    @Override
    public int nextInt(String name) {
        int value = 30;
        return value;
    }

    @Override
    public String nextString(String name) {
        String value = "Imie/nazwisko";
        return value;
    }
}
