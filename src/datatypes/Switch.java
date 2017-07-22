package datatypes;

/**
 * Created by RENT on 2017-07-06.
 */
public class Switch {
    public static void main(String[] args) {
        int i =1;
        switch (i){ ///tu wykona się wszystko
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
            default:
                System.out.println("?");
        }

        int i1 =1;
        switch (i1){ ///tu wykona się wszystko
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("?");
                break; // ta instrukcja nie jest tu potrzebna ale dla porządku się ją pisze
        }

    }
}
