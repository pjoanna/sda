package sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import sda.spring.model.User;

import java.util.List;

		// Krok 3.
		// Interfejs UserRepository jest połączeniem z bazą danych, ma w sobie różne gotowe metody

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	// Parametrami <User, Long> są wartość z tabeli(cały obiekt - tu klasa User) i pole identyfikator z tej tabeli (tu private Long id).
	// W tym interfejsie dodajemy metody, które są zapytaniami do bazy danych

	User findByUsername(String username);
	List<User> findByPassword(String password);
	List<User> findByFirstnameAndPassword(String firstName, String password);

	// nie można żadnej literówk zrobić w nazwie metody, ważne duże i małe litery bo nie zadziała
	// -> przechodzimy do innego interfejsju -> UserService i dodajemy tam metodę

}
