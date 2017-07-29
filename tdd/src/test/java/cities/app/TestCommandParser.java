package cities.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by RENT on 2017-07-29.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestCommandParser {

    @InjectMocks
    CommandParser commandParser;

    @Mock
    CommandExecutor commandExecutor;

    @Test
    public void whenCommendIsExitShouldCloseApp() {

        commandParser.parse("exit");

        Mockito.verify(commandExecutor).closeApp();
    }

    @Test
    public void whenCommendIsAddGdanskShouldAddGdansk() {

        commandParser.parse("add Gdansk 100 10.5");
        Mockito.verify(commandExecutor).add("Gdansk", 100, 10.5);

    }
    @Test
    public void whenCommendIsGetByNameGdanskShouldGetGdansk() {
        commandParser.parse("getByName Gdansk");
        Mockito.verify(commandExecutor).getByName("Gdansk");
    }

    @Test
    public void whenCommendIsGetIdShouldGetGdansk() {
        commandParser.parse("get 1");
        Mockito.verify(commandExecutor).get(1L);
    }
    @Test
    public void whenCommendIsDeleteIdShouldDeleteGdansk() {
        commandParser.parse("delete 1");
        Mockito.verify(commandExecutor).delete(1L);
    }


}
