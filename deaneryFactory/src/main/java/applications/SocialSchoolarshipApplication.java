package applications;

import person.Person;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by RENT on 2017-08-09.
 */
class SocialSchoolarshipApplication extends Application{
    private List<Double> grades;
    private Double totalFamilyIncome;

    public SocialSchoolarshipApplication(LocalDateTime creationDate, String place, Person person, String content, List<Double> grades, Double totalFamilyIncome) {
        super(creationDate, place, person, content);
        this.grades = grades;
        this.totalFamilyIncome = totalFamilyIncome;
    }
}
