package moviedb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.Scanner;

/**
 * Created by pjoanna on 2017-10-02.
 */
public class MovieDB {
    public static void main(String[] args) {
        Movie movie = getMovieFromUser();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Genre genre = new Genre("genre1");
            movie.setGenre(genre);

            session.persist(genre);
            session.persist(movie);



            session.getTransaction().commit();
        } catch (Throwable e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

    private static Movie getMovieFromUser() {
        Scanner scanner = new Scanner(System.in);

        String title;
        Integer year;
        Double duration;
        String description;

        System.out.println("podaj tytuł");
        title = scanner.nextLine();

        System.out.println("podaj rok");
        year = Integer.parseInt(scanner.nextLine());

        System.out.println("podaj czas trwania w minutach");

        duration = Double.parseDouble(scanner.nextLine());
        System.out.println("podaj opis");
        description = scanner.nextLine();

        return new Movie(title, year, duration, description);
    }
}
