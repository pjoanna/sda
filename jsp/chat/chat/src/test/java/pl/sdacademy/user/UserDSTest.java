package pl.sdacademy.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDSTest {

	@InjectMocks
	private UserDS sut = new UserDS();

	@Mock
	private UserDAO userDAO;

	@Mock
	private HttpServletRequest httpServletRequest;
	@Mock
	private HttpServletResponse httpServletResponse;
	@Mock
	private RequestDispatcher requestDispatcher;

	private Optional<User> presentUser = Optional.of(new User(1, "nick", "pass", new Date(), Gender.MALE, "desc"));
	private Optional<User> absentUser = Optional.empty();

	@Test
	public void shouldAddUserToAttribute() throws Exception {
		// given
		when(httpServletRequest.getParameter(anyString())).thenReturn("1");
		when(userDAO.getUserById(anyInt())).thenReturn(presentUser);
		when(httpServletRequest.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

		// when
		sut.doGet(httpServletRequest, httpServletResponse);

		// then
		verify(httpServletRequest).setAttribute("user", presentUser.get());
		verify(requestDispatcher).include(httpServletRequest, httpServletResponse);
	}

	@Test
	public void shouldNotAddUserToAttribute() throws Exception {
		// given
		when(httpServletRequest.getParameter(anyString())).thenReturn("1");
		when(userDAO.getUserById(anyInt())).thenReturn(absentUser);
		when(httpServletRequest.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

		// when
		sut.doGet(httpServletRequest, httpServletResponse);

		// then
		verify(requestDispatcher).include(httpServletRequest, httpServletResponse);
		verify(httpServletRequest, never()).setAttribute(anyString(), anyObject());
	}
}