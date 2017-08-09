package abstractfactory.applications;

import abstractfactory.person.Person;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by RENT on 2017-08-09.
 */
class SchoolarshipApplication  extends Application {

    private List<Double> grades;
    private List<String> extracurricularActivities;

    public SchoolarshipApplication(LocalDateTime creationDate, String place, Person person, String content, List<Double> grades, List<String> extracurricularActivities) {
        super(creationDate, place, person, content);
        this.grades = grades;
        this.extracurricularActivities = extracurricularActivities;
    }
}
