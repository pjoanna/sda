import java.util.Optional;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-12.
 */
public class RequestParser {
    public static Optional<Request> parseRequest(String requestLine) {
        try {
            String[] commandLine = requestLine.split(" ");
            RequestType type = RequestType.valueOf(commandLine[0]);
            String username = commandLine[1];
            String content = commandLine[2];
            Request request = new Request(type, username, content);
            return Optional.of(request);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("wrong number of arguments");
        } catch (IllegalArgumentException e) {
            System.out.println("wrong type");
        }
        return Optional.empty();
    }
}
