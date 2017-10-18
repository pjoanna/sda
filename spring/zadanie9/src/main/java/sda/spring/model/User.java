package sda.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

					// Krok 2.
					// to jest klasa która będzie tabelą User w naszej "wirtualnej" bazie danych. Każdy obiekt tej klasy będzie wierszem
					// -> żeby dostać się do tabeli trzeba zrobić UserRepository, idź tam
					// koniecznie trzeba dopisać @Entity nad nazwą klasy i @Id @GeneratedValue nad id

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private int phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
}