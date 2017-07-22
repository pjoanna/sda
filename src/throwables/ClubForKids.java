package throwables;

/**
 * Created by RENT on 2017-07-15.
 */
public class ClubForKids extends Club {
    @Override
    public void enter(Person person) {
        if(person.getAge() < 18){
            System.out.println("Witamy w klubie");
        }else {
            throw new NoChildException();
        }
    }
}
