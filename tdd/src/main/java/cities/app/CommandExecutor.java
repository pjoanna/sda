package cities.app;

import java.util.List;

/**
 * Created by RENT on 2017-07-29.
 */
public class CommandExecutor {
    private final UserInterface userInterface;
    private final CityRepository cityRepository;
    private final App app;
    private City city;

    public CommandExecutor(UserInterface userInterface, CityRepository cityRepository, App app) {
        this.userInterface = userInterface;
        this.cityRepository = cityRepository;
        this.app = app;
    }

    public void add(String name, int citizens, double area) {
        long id = cityRepository.add(name, citizens, area);
        City city = new City(id, name, citizens, area); //
        userInterface.showMessage(UserInterface.Message.NEW_CITY_ADDED);
        userInterface.showCityDetails(city); //
        //efekt taki sam jak userInterface.showCityDetails(new City(id, name, citizens, area));
    }

    public void get(long id) {
        City city = cityRepository.get(id);
        if (city != null) {
            userInterface.showCityDetails(city);
        }else {
            userInterface.showMessage(UserInterface.Message.CITY_DOESNT_EXIST);
        }
    }

    public void getByName(String cityName) {
        List<City> cities = cityRepository.getCitiesByName(cityName);
        if (!cities.isEmpty()) {
            for (City city : cities) {
                userInterface.showCityDetails(city);
            }
        }else {
            userInterface.showMessage(UserInterface.Message.CITY_DOESNT_EXIST);
        }
    }

    public void update(long id, String name, int citizens, double area) {
        City oldCity = cityRepository.get(id);
        City city = new City(id, name, citizens, area);
        if (oldCity != null) {
            userInterface.showCityDetails(oldCity);
            cityRepository.update(city);
            userInterface.showMessage(UserInterface.Message.CITY_UPDATED);
            userInterface.showCityDetails(city);
        } else {
            userInterface.showMessage(UserInterface.Message.CITY_DOESNT_EXIST);
        }

    }

    public void delete(long id) {
        if (cityRepository.delete(id)) {
            userInterface.showMessage(UserInterface.Message.CITY_DELETED);
        } else {
            userInterface.showMessage(UserInterface.Message.CITY_DOESNT_EXIST);
        }
    }

    public void deleteByName(String cityName) {
        List<City> cities = cityRepository.getCitiesByName(cityName);
        for (City city1 : cities) {
            delete(city1.getId());
        }
    }

    public void closeApp() {
        userInterface.showMessage(UserInterface.Message.APP_CLOSED);
        app.closeApp();
    }
}
