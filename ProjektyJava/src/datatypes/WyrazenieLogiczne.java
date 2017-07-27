package datatypes;

/**
 * Created by RENT on 2017-07-06.
 */
public class WyrazenieLogiczne {
    public static void main(String[] args) {
        boolean b1 = (false == false);
        boolean b2 = (false != true);
        boolean b3 = (!true);
        boolean b4 = (2 > 4);
        boolean b5 = (3 < 5);
        boolean b6 = (3 == 3 && 3 == 4);
        boolean b7 = (3 != 5 || 3 == 5);
        boolean b8 = ((2+4)>(1+3));
        boolean b9 = ("cos".equals("cos")); //takie same - równe wartości
        boolean b10 = ("cos" == "cos"); //to samo - identyczne, dotyczy tylko obiektów

        char a ='a';
        int i = 97;
        boolean ai1 = (a==i); //true

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);
        System.out.println(b7);
        System.out.println(b8);
        System.out.println(b9);
        System.out.println(b10);
        System.out.println(ai1);

        String cos = new String("cos");
        System.out.println(cos);
        System.out.println(cos.equals("cos")); //true
        System.out.println(cos == "cos"); //false // czy to jest to samo miejsce w pamieci komputera

    }

}
