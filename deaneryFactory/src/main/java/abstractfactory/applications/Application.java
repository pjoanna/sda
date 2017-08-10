package abstractfactory.applications;

import abstractfactory.person.Person;

import java.time.LocalDateTime;

/**
 * Created by RENT on 2017-08-09.
 */
public class Application {
    private LocalDateTime creationDate;
    private String place;
    private Person person;
    private String content;

    public Application(LocalDateTime creationDate, String place, Person data, String content) {
        this.creationDate = creationDate;
        this.place = place;
        this.person = data;
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
