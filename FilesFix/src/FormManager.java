import java.util.Scanner;

/**
 * Created by pjoanna on 2017-08-02.
 */
public class FormManager {
    private final Scanner scanner;
    private Form form;

    public FormManager(Scanner scanner) {
        this.scanner = scanner;
    }

    private String ask(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

    private void getSexFromUser() {
        Sex sex ;
        do {
            String answer = ask("Podaj plec (m/k):");
            sex = Sex.parse(answer);
        }while (sex == Sex.UNKNOWN);
        form.setSex(sex);
    }

    private void getNameFromUser() {
        String odp = ask("Podaj imie:");
        form.setName(odp);
    }
    private void getSurnameFromUser() {
        String odp = ask("Podaj nazwisko:");
        form.setSurname(odp);
    }

    private void getAgeFromUser() {
        Integer age = null;
        do {
            String ageString = ask("Podaj wiek:");
            try {
                age = Integer.parseInt(ageString);
            } catch (NumberFormatException e) {
                System.out.println("Nieporawne dane wejsciowe.");
            }
        } while (age == null);
        form.setAge(age);
    }

    private void askMoreIfNecessery() {
        if(shouldAskMore()){
            askMore();
        }else {
            System.out.println("Nie spełniasz kryteriów wiekowych ankiety, dziękujemy!");
        }
    }

    private void askMore() {
        form.setAnswer1(ask("Pytanie1:"));
        form.setAnswer2(ask("Pytanie2:"));
        form.setAnswer3(ask("Pytanie3:"));
    }
    private boolean shouldAskMore() {
        int age = form.getAge();
        Sex sex = form.getSex();
        return (sex==Sex.MALE && age >25 && age <30)  ||
                sex==Sex.FEMALE && age >18 && age <25;
    }

    public Form createAndFillForm() {
        form = new Form();
        getNameFromUser();
        getSurnameFromUser();
        getAgeFromUser();
        getSexFromUser();
        askMoreIfNecessery();
        return form;
    }
}
