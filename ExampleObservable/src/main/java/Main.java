import java.util.Scanner;

/**
 * Created by RENT on 2017-08-10.
 */
public class Main {
    public static void main(String[] args) {
        McDonald mcd = new McDonald();

        Scanner sc = new Scanner(System.in);
        while(true){
            String line = sc.nextLine();
            mcd.handleOrder(line);
            if(line.equals("quit"))
                break;
        }
    }
}
