package pl.sda.library;

import java.util.Objects;

public class Author {

	private static int counter;

	private int id;
	private String name;
	private String surname;

	public Author() {
		this.id = ++counter;
	}

	public Author(String name, String surname) {
		this();
		this.name = name;
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Author author = (Author) o;
		return Objects.equals(name, author.name) &&
				Objects.equals(surname, author.surname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	@Override
	public String toString() {
		return "Author{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				'}';
	}
}
