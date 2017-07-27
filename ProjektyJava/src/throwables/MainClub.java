package throwables;

/**
 * Created by RENT on 2017-07-15.
 */
public class MainClub {

    public static void main(String[] args) {
        Club club = new Club();
        ClubForKids forKids = new ClubForKids();
        Person[] persons = {
                new Person(23, "Kasia","Nowak"),
                new Person(14, "Monika", "Kowalska"),
                new Person(32, "Adam", "Nowak"),
                new Person(18, "Kuba","Kowal")};

        for(Person person : persons){
            try {
                club.enter(person);
            }catch (NoAdultException e){
                System.out.println("Nie możesz wejść do klubu");
            }
        }
        System.out.println();
        for (Person person : persons){
            try {
                forKids.enter(person);
            }catch (NoChildException e){
                System.out.println("Nie możesz wejść do klubu");
            }
        }


    }
}
