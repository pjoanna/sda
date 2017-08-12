import java.util.Optional;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-12.
 */
public class Main {
    public static void main(String[] args) {
        String line = null;
        WebService service = new WebService();

        do {
            Scanner scanner = new Scanner(System.in);
            line = scanner.nextLine();
            Optional<Request> request = RequestParser.parseRequest(line);
            // to samo co niżej ale z wyrażeniem lambda
            request.ifPresent((req)->{
                System.out.println(request);
                service.handleRequest(request.get());
            });
//                if (request.isPresent()) {
//                    System.out.println(request);
//                    service.handleRequest(request.get());
//                } else {
//                    System.out.println("Couldn't parse that request");
//                }
            } while (!line.equals("quit")) ;

        }
    }
