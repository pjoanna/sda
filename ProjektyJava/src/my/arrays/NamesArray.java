package my.arrays;

/**
 * Created by RENT on 2017-07-08.
 */
public class NamesArray {

    public static void main(String[] args) {
        String[] names = {"Ala","Basia","Czesia","Daria","Ela","Fiona","Gienia","Hela","Ada","Asia","Ania"};

        for (int i = 0; i < names.length; i++){
            System.out.println(names[i]);

        }
        for(String name : names){
            System.out.println(name);
        }
        for (int i = 0; i < names.length; i++) {
            if((i+1)%2 == 0){
                System.out.println(names[i]);
            }
        }
        System.out.println("A");
        for(String name : names){
            if (name.toUpperCase().charAt(0)=='A'){
                System.out.println(name);
            }
        }
        for(String name : names){
            if (name.toUpperCase().startsWith("A")){
                System.out.println(name);
            }
        }
    }
}
