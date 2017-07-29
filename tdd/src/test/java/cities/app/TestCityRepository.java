package cities.app;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by RENT on 2017-07-29.
 */
public class TestCityRepository {
    private CityRepository underTest = new CityRepository();

    @Test
    public void whenRepositoryIsEmptyGetShouldReturnNull(){
        City actual = underTest.get(1L);
        assertThat(actual).isNull();
    }

    @Test
    public void whenAddNoCityGetReturnEmptyList(){
        List<City> actual = underTest.getCitiesByName("CityName");
        assertThat(actual).isEmpty();
    }


    @Test
    public void whenAddCityGetByNameShouldReturnThisCity(){
        long cityId = underTest.add("CityName",1000,1000.0);
        List<City> actual = underTest.getCitiesByName("CityName");
        assertThat(actual).containsOnly(new City(cityId, "CityName", 1000, 1000.0 ));
    }

    @Test
    public void whenAddOneCityGetByNameShouldReturnThisCity(){
        long cityId = underTest.add("CityName",1000,1000.0);
        List<City> actual = underTest.getCitiesByName("CityName");
        assertThat(actual).containsOnly(new City(cityId, "CityName", 1000, 1000.0 ));
    }

    @Test
    public void whenAddCitiesTheSameNamesAndGetByNameShouldReturnTheseCities(){
        long cityId1 = underTest.add("CityName",1000,1000.0);
        long cityId2 = underTest.add("CityName",1001,1001.0);
        long cityId3 = underTest.add("CityName",1002,1002.0);
        List<City> actual = underTest.getCitiesByName("CityName");
        assertThat(actual).containsOnly(
                new City(cityId1, "CityName", 1000, 1000.0),
                new City(cityId2, "CityName", 1001, 1001.0),
                new City(cityId3, "CityName", 1002, 1002.0));
    }


    @Test // Adriana
    public void whenFewCitiesWithTheSameNameGetByNameShouldReturnTheseCities(){
        long cityId1 = underTest.add("CityName",1000,1000.0);
        long cityId2 = underTest.add("CityName",1000,1000.0);
        long cityId3 = underTest.add("CityName",1000,1000.0);
        List<City> actual = underTest.getCitiesByName("CityName");
        assertThat(actual).containsOnly(
                new City(cityId1, "CityName", 1000, 1000.0 ),
                new City(cityId2, "CityName", 1000, 1000.0 ),
                new City(cityId3, "CityName", 1000, 1000.0 )
        );
    }

    @Test // bez sensu ? :P
    public void whenFewCitiesWithTheOtherNamesGetByNameShouldReturnOneOfTheseCities(){
        long cityId1 = underTest.add("CityName0",1000,1000.0);
        long cityId2 = underTest.add("CityName1",1001,1001.0);
        long cityId3 = underTest.add("CityName2",1002,1002.0);
        List<City> actual = underTest.getCitiesByName("CityName2");
        assertThat(actual).containsOnly(new City(cityId3, "CityName2", 1002, 1002.0 ));
    }

    @Test
    public void addCityWithGeneratedIdShouldReturnIdOfThisCity(){
        long id1 = underTest.add("Gdynia",124432,1234.0);
        assertThat(id1).isEqualTo(1L);
        long id2 = underTest.add("Gdynia",124432,1234.0);
        long id3 = underTest.add("Gdynia",124432,1234.0);
        long id4 = underTest.add("Gdynia",124432,1234.0);
        assertThat(id4).isEqualTo(4L);

    }
    @Test
    public void deleteExistingCityShouldReturnTrue(){
        long id1 = underTest.add("Gdynia",124432,1234.0);
        boolean actual = underTest.delete(id1);
        assertThat(actual).isTrue();
        assertThat(underTest.get(id1)).isNull();
        assertThat(underTest.getCitiesByName("Gdynia")).isEmpty();
    }
    @Test
    public void deleteNoExistingCityShouldReturnFalse(){
        boolean actual = underTest.delete(5L);
        assertThat(actual).isFalse();
    }

    @Test
    public void deleteExistingCityShouldRemoveThisCity(){
        long id1 = underTest.add("Gdynia",124432,1234.0);
        long id2 = underTest.add("Gdynia",124432,1234.0);
        boolean actual = underTest.delete(id1);
        assertThat(actual).isTrue();
        assertThat(underTest.get(id1)).isNull();
        assertThat(underTest.getCitiesByName("Gdynia")).containsOnly(new City(id2,"Gdynia", 124432, 1234.0));
    }
    @Test
    public void updateNoExistingCityShouldReturnFalse(){
        boolean actual = underTest.update(new City(1,"Gdynia",124432,1234.0));
        assertThat(actual).isFalse();
    }
    @Test
    public void updateExistingCityShouldReturnTrue(){
        long id1 = underTest.add("Gdynia",124432,1234.0);
        long id2 = underTest.add("Gdynia",124432,1234.0);
        City updated1 = new City(id1, "Gdynia1",124432,1234.0);
        City notUpdated2 = new City(id2, "Gdynia",124432,1234.0);


        boolean actual = underTest.update(updated1);
        assertThat(underTest.get(id1)).isEqualToComparingFieldByField(updated1);
        assertThat(underTest.get(id2)).isEqualToComparingFieldByField(notUpdated2);

        assertThat(underTest.getCitiesByName("Gdynia")).containsExactly(new City(id2,"Gdynia",124432,1234.0));
        assertThat(underTest.getCitiesByName("Gdynia1")).containsExactly(new City(id1,"Gdynia1",124432,1234.0));

    }

    @Test
    public void whenModifyGettedCityRepositoryIsNotModify(){
        long sopotId = underTest.add("Sopot", 900, 339.8);
        City sopot = underTest.get(sopotId);
        sopot.setId(100L);
        sopot.setName("SopotLol");
        sopot.setArea(123.0);
        sopot.setCitizens(1233);

        assertThat(underTest.get(sopotId)).isEqualToComparingFieldByField(new City(sopotId, "Sopot", 900, 339.8));
    }



}
