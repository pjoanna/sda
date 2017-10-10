package pl.sda.library;

import java.util.Objects;
import java.util.Set;

public class Book {

	private static int counter;

	private int id;
	private String title;
	private Category category;
	private Set<Author> authors;
	private int year;

	public Book() {
		this.id = ++counter;
	}

	public Book(String title, Category category, Set<Author> authors, int year) {
		this();
		this.title = title;
		this.category = category;
		this.authors = authors;
		this.year = year;
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

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return year == book.year &&
				Objects.equals(title, book.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, year);
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", authors=" + authors +
				", category=" + category +
				", year=" + year +
				'}';
	}
}
