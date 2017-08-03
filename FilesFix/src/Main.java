import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by amen on 8/1/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Zaczynamy.");
        File file = new File("test.txt");
        Scanner scanner = new Scanner(System.in);
        tryToFillFile(file, scanner);
        checkIfFileExists(file);
        Form form = new Form();
        Map<String[], Form> formMap = new HashMap<>();
        addFormToMap(file, form, formMap);


        String commmand = "tak";

        while (commmand.equals("tak")) {
            System.out.println("Podaj imię szukanej osoby");
            String givenName = scanner.nextLine();
            System.out.println("Podaj nazwisko szukanej osoby");
            String givenSurname = scanner.nextLine();

            for (Map.Entry<String[], Form> formEntry : formMap.entrySet()) {
                String[] nameAndSurname = {givenName,givenSurname};
                if (formEntry.getKey().equals(nameAndSurname)){
                    System.out.println("Wiek: " + formEntry.getValue().getAge());
                } else {
                    System.out.println("nie znaleziono osoby");
                }
            }

            System.out.println("Czy chcesz szukać kolejnej osoby? (tak/nie)");
            commmand = scanner.next();
        }
    }

    private static void addFormToMap(File file, Form form, Map<String[], Form> formMap) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {

            String[] nameAndSurname = getFormAnswers(form, reader);
            formMap.put(nameAndSurname, form);

        } catch (FileNotFoundException e) {
            System.out.println("nie udało się odczytać");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] getFormAnswers(Form form, BufferedReader reader) throws IOException {

        form.setName(reader.readLine());
        form.setSurname(reader.readLine());
        String[] ageString = reader.readLine().split("=");
        Integer age = Integer.parseInt(ageString[1]);
        form.setAge(age);
        form.setSex(reader.readLine());
        form.setAnswer1(reader.readLine());
        form.setAnswer2(reader.readLine());
        form.setAnswer3(reader.readLine());
        return new String[]{form.getName(), form.getSurname()};
    }

    private static void tryToFillFile(File file, Scanner scanner) {
        try (FileOutputStream stream = new FileOutputStream(file); PrintWriter writer = new PrintWriter(stream)) {
            writeFormsToFile(scanner, writer);
        } catch (IOException e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    private static void writeFormsToFile(Scanner scanner, PrintWriter writer) {
        FormManager filler = new FormManager(scanner);
        do {
            Form form = filler.createAndFillForm();
            writer.println(form);
        } while (ask(scanner, "Czy chcesz wypełnić kolejną ankietę? (tak/nie):").equals("tak"));
    }


    private static String ask(Scanner sc, String text) {
        System.out.println(text);
        return sc.nextLine();
    }

    private static void checkIfFileExists(File file) {
        if (file.exists()) {
            System.out.println("Plik istnieje.");//
        } else {
            System.out.println("Plik nie istnieje.");
        }
    }

}
