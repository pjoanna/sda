package applications;

import person.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static person.PersonCreator.createPerson;

/**
 * Created by RENT on 2017-08-09.
 */
public class ApplicationsCreator {
    public static ConditionalStayApplication createConditionalStayApplication() {
        Scanner scanner = new Scanner(System.in);
        Application appBase = createApplicationBase();
        System.out.println("Podaj oceny(oddzielając spacją): ");
        String[] gradesString = scanner.nextLine().split(" ");
        List<Double> grades = new ArrayList<>();
        for (String gradeString : gradesString) {
            Double grade = Double.parseDouble(gradeString);
            grades.add(grade);
        }
        System.out.println("Podaj powód: ");
        String reason = scanner.nextLine();
        return new ConditionalStayApplication(appBase.getCreationDate(), appBase.getPlace(), appBase.getPerson(), appBase.getContent(), grades, reason);
    }

    public static SchoolarshipApplication createSchoolarshipApplication() {
        Scanner scanner = new Scanner(System.in);
        Application appBase = createApplicationBase();
        System.out.println("Podaj oceny(oddzielając spacją): ");
        String[] gradesString = scanner.nextLine().split(" ");
        List<Double> grades = new ArrayList<>();
        for (String gradeString : gradesString) {
            Double grade = Double.parseDouble(gradeString);
            grades.add(grade);
        }
        System.out.println("Wypisz dodatkowe zajęcia, w których bierzesz udział (oddzielając spacją): ");
        String[] activities = scanner.nextLine().split(" ");
        List<String> extracurricularActivities = new ArrayList<>();
        for (String activity : activities) {
            extracurricularActivities.add(activity);
        }
        return new SchoolarshipApplication(appBase.getCreationDate(), appBase.getPlace(), appBase.getPerson(), appBase.getContent(), grades, extracurricularActivities);
    }

    public static SemesterExtendApplication createSemesterExtendApplication() {
        Scanner scanner = new Scanner(System.in);
        Application appBase = createApplicationBase();
        System.out.println("Podaj powód: ");
        String reason = scanner.nextLine();
        return new SemesterExtendApplication(appBase.getCreationDate(), appBase.getPlace(), appBase.getPerson(), appBase.getContent(), reason);
    }

    public static SocialSchoolarshipApplication createSocialSchoolarshipApplication() {
        Scanner scanner = new Scanner(System.in);
        Application appBase = createApplicationBase();
        System.out.println("Podaj oceny(oddzielając spacją): ");
        String[] gradesString = scanner.nextLine().split(" ");
        List<Double> grades = new ArrayList<>();
        for (String gradeString : gradesString) {
            Double grade = Double.parseDouble(gradeString);
            grades.add(grade);
        }
        System.out.println("Dochód na członka rodziny wynosi: ");
        Double income = Double.parseDouble(scanner.nextLine());
        return new SocialSchoolarshipApplication(appBase.getCreationDate(), appBase.getPlace(), appBase.getPerson(), appBase.getContent(), grades, income);
    }

    private static Application createApplicationBase() {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Podaj miejscowość: ");
        String place = scanner.nextLine();
        Person person = createPerson();
        System.out.println("Podaj treść wniosku");
        String content = scanner.nextLine();
        return new Application(date, place, person, content);
    }

}
