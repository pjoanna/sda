package pl.sdacademy.jdbc.person;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 *
 */
public class PersonDAOTest {

	@Test
	public void shouldBePresentWithIdOne() throws Exception {
		// given
		PersonDAO sut = new PersonDAO();

		// when
		Optional<Person> actual = sut.findById(1L);

		// then
		assertThat(actual.isPresent(), is(true));
		Person person = actual.get();
		assertPerson(person, 1L, "firstname1", "lastname1");
	}

	@Test
	public void shouldBeAbsentWithIdMinusFive() throws Exception {
		// given
		PersonDAO sut = new PersonDAO();

		// when
		Optional<Person> actual = sut.findById(-5L);

		// then
		assertThat(actual.isPresent(), is(false));
	}

	private void assertPerson(Person person, long id, String firstName, String lastName) {
		assertThat("id should be: " + id, person.getId(), is(id));
		assertThat("firstName should be: " + firstName, person.getFirstName(), is(firstName));
		assertThat("lastName should be: " + lastName, person.getLastName(), is(lastName));
	}
}