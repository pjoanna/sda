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
        form.setSex(ask("Podaj plec:"));
    }

    private void getNameAndSurnameFromUser() {
        form.setName(ask("Podaj imie i nazwisko:"));
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
        String sex = form.getSex().toLowerCase();
        return (sex.equals("mezczyzna") && age >25 && age <30)  ||
                sex.equals("kobieta") && age >18 && age <25;
    }

    public Form createAndFillForm() {
        form = new Form();
        getNameAndSurnameFromUser();
        getAgeFromUser();
        getSexFromUser();
        askMoreIfNecessery();
        return form;
    }
}
