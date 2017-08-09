package applications;

import person.Person;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by RENT on 2017-08-09.
 */
class ConditionalStayApplication extends Application{
    private List<Double> grades;
    private String reason;

    public ConditionalStayApplication(LocalDateTime creationDate, String place, Person person, String content, List<Double> grades, String reason) {
        super(creationDate, place, person, content);
        this.grades = grades;
        this.reason = reason;
    }


}
