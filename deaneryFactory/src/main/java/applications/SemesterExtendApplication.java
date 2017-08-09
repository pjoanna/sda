package applications;

import person.Person;

import java.time.LocalDateTime;

/**
 * Created by RENT on 2017-08-09.
 */
class SemesterExtendApplication extends Application{

    private String reason;

    public SemesterExtendApplication(LocalDateTime creationDate, String place, Person person, String content, String reason) {
        super(creationDate, place, person, content);
        this.reason = reason;
    }
}
