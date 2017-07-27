package mutability.person;

/**
 * Created by RENT on 2017-07-22.
 */
public class Person {
        private final String name;
        private final String surname;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

    public Person changeName(String name) {
        return new Person(name,surname);
    }

    public Person changeSurname(String surname) {
        return new Person(name,surname);
    }

    public String getSurname() {
            return surname;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (name != null ? !name.equals(person.name) : person.name != null) return false;
            return surname != null ? surname.equals(person.surname) : person.surname == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (surname != null ? surname.hashCode() : 0);
            return result;
        }


}
