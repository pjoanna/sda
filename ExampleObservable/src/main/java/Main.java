import java.util.Scanner;

/**
 * Created by RENT on 2017-08-10.
 */
public class Main {
    public static void main(String[] args) {
        McDonald mcd = new McDonald();
        for(int i = 0; i < 10; i++){
            Employee e = new Employee();
            mcd.addObserver(e);
//            deleteObserver(e);
        }

        Scanner sc = new Scanner(System.in);
        while(true){
            String line = sc.nextLine();
            mcd.handleOrder(line);
            if(line.equals("quit"))
                break;
        }
    }
}
