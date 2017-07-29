package cities.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RENT on 2017-07-29.
 */
public class CityRepository {
    private final Map<Long,City> map = new HashMap<>();
    private static SequenceGenerator sequenceGenerator = new SequenceGenerator();

    public long add (String name, int citizens, double area){
        long id = sequenceGenerator.generate();
        map.put(id, new City(id, name, citizens, area));
        return id;
    }

    public City get(long id){
        if (map.containsKey(id)){
            return copy(map.get(id));
        }
        return null;
    }

    public City copy(City city){
        return new City(city.getId(), city.getName(), city.getCitizens(), city.getArea());
    }


    public List<City> getCitiesByName(String cityName){
        List<City> cities = new ArrayList<>();
        for (City city : map.values()) {
            if (city.getName().equals(cityName)){
                cities.add(copy(city));
            }
        }
        return cities;
    }

    public boolean update(City city){
        if (map.containsKey(city.getId())){
            map.replace(city.getId(), copy(city));
            return true;
        }else {
            return false;
        }
    }

    public boolean delete(long id){
        if (map.containsKey(id)){
            map.remove(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityRepository that = (CityRepository) o;

        return map != null ? map.equals(that.map) : that.map == null;
    }

    @Override
    public int hashCode() {
        return map != null ? map.hashCode() : 0;
    }






}
