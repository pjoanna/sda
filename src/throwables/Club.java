package throwables;

/**
 * Created by RENT on 2017-07-15.
 */
public class Club {
    public void enter(Person person){
        if(person.getAge() < 18){
            throw new NoAdultException();
        }else {
            System.out.println("Witamy w klubie");
        }

    }
}
