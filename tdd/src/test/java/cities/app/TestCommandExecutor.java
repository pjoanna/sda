package cities.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RENT on 2017-07-29.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestCommandExecutor {

    @InjectMocks
    CommandExecutor underTest;
    @Mock
    UserInterface userInterface;
    @Mock
    CityRepository cityRepository;
    @Mock
    App app;

    @Test
    public void addShouldAddCityToRepositoryAndInformUserAboutIt() {

        Mockito.when(cityRepository.add("Sopot", 100, 10)).thenReturn(5L);

        underTest.add("Sopot", 100, 10);

        Mockito.verify(cityRepository).add("Sopot", 100, 10);
        Mockito.verify(userInterface).showMessage(UserInterface.Message.NEW_CITY_ADDED);
        Mockito.verify(userInterface).showCityDetails(new City(5L, "Sopot", 100, 10));
    }

    @Test
    public void whenCityWithGivenIdExistGetShouldShowItsDetails() {

        City sopot = new City(2L, "Sopot", 100, 10);
        Mockito.when(cityRepository.get(2L)).thenReturn(sopot);

        underTest.get(2L);

        Mockito.verify(userInterface).showCityDetails(sopot);
    }

    @Test
    public void whenCityWithGivenIdNoExistGetShouldShowCityDoesntExist() {

        Mockito.when(cityRepository.get(2L)).thenReturn(null);

        underTest.get(2L);

        Mockito.verify(userInterface).showMessage(UserInterface.Message.CITY_DOESNT_EXIST);
    }

    @Test
    public void whenExistNoCitiesWithGivenNameShouldShowItDoesntExists(){
        Mockito.when(cityRepository.getCitiesByName("Sopot")).thenReturn(Collections.emptyList());
        underTest.getByName("Sopot");

        Mockito.verify(userInterface).showMessage(UserInterface.Message.CITY_DOESNT_EXIST);
        Mockito.verifyNoMoreInteractions(userInterface);
    }

    @Test
    public void whenExistOneCityWithGivenNameShouldShowItsDetails(){
        City sopot = new City(1L, "Sopot", 100, 100.0);
        List<City> sopotOnly = new ArrayList<>();
        sopotOnly.add(sopot);
        Mockito.when(cityRepository.getCitiesByName("Sopot")).thenReturn(sopotOnly);

        underTest.getByName("Sopot");

        Mockito.verify(userInterface).showCityDetails(sopot);
    }

    @Test
    public void whenExistTwoCitiesWithGivenNameShouldShowItsDetails(){
        City sopot1 = new City(1L, "Sopot", 100, 100.0);
        City sopot2 = new City(2L, "Sopot", 100, 100.0);
        List<City> sopotOnly = new ArrayList<>();
        sopotOnly.add(sopot1);
        sopotOnly.add(sopot2);
        Mockito.when(cityRepository.getCitiesByName("Sopot")).thenReturn(sopotOnly);

        underTest.getByName("Sopot");

        Mockito.verify(userInterface).showCityDetails(sopot1);
        Mockito.verify(userInterface).showCityDetails(sopot2);
    }






}