package innerclasses.staticschool;

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

    static class Pupil {
        private String name;
        private School school;

        public Pupil(String name, School school) {
            this.name = name;
            this.school = school;
        }
        public void introduce(){
            System.out.println("Nazywam się " + name + ". Uczęszczam do szkoły " + school.name + " imienia " + school.patron);
        }
    }

    public static void main(String[] args) {
        School school = new School("I LO","Sobieski");
        Pupil pupil =  new Pupil("Jan",school);
        // Szkołę trzeba przekazać jako parametr konstruktora
        // bo pupil jest elementem statycznym klasy School
        pupil.introduce();
    }


}
