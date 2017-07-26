package innerclasses.nostaticschool;

/**
 * Created by RENT on 2017-07-24.
 */
public class School {
    private String name;
    private String patron;

    public School(String name, String patron) {
        this.name = name;
        this.patron = patron;
    }
    public Pupil newPupil(String name){
        Pupil pupil = new Pupil(name);
        return pupil;
    }

    class Pupil {
        private String name;

        public Pupil(String name) {
            this.name = name;
        }
        public void introduce(){
            System.out.println("Nazywam się " + name + ". Uczęszczam do szkoły " + School.this.name + " imienia " + patron);
        }
    }

    public static void main(String[] args) {
        School school = new School("I LO","Sobieski");
        Pupil pupil = school.newPupil("Jan");
        // Nie można tworzyć instancji klas wewnętrznych w kontekście statycznym
        // new Pupil("Adam);
        pupil.introduce();
    }
}
