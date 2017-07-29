package cities.app;

/**
 * Created by RENT on 2017-07-29.
 */
public class CommandParser {
    private final CommandExecutor commandExecutor;

    public CommandParser(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }
    public void parse(String command) {
        String[] split = command.split(" ");
        String commandType = split[0];
        switch(commandType){
            case "exit":
                commandExecutor.closeApp();
                break;
            case "add":
                String cityName = split[1];
                Integer citizens = Integer.parseInt(split[2]);
                Double area = Double.parseDouble(split[3]);
                commandExecutor.add(cityName,citizens,area);
                break;
            case "getByName":
                String cityName0 = split[1];
                commandExecutor.getByName(cityName0);
                break;
            case "get":
                Long id = Long.parseLong(split[1]);
                commandExecutor.get(id);
                break;
            case "delete":
                Long id1 = Long.parseLong(split[1]);
                commandExecutor.delete(id1);
                break;

            default: break;
        }



    }
}
