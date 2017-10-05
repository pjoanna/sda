package moviedb;


import javax.persistence.*;

/**
 * Created by pjoanna on 2017-10-02.
 */
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int year;
    private double duration;
    private String description;
    @ManyToOne
    @JoinColumn(name = "GENRE_ID")
    private Genre genre;

    public Movie() {
    }

    public Movie(String title, int year, double duration, String description) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                '}';
    }

}
