package user;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

//@Slf4j
public class UserServlet extends HttpServlet {

	private UserDAO userDAO = new UserDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Optional<User> optionalUser = getUserById(id);

		//log.debug("OptionalUser" + optionalUser);

		if (optionalUser.isPresent()) {
			request.setAttribute("user", optionalUser.get());

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/user.jsp");
			requestDispatcher.forward(request, response);
		} else {
		//	log.error("Brak usera o id=" + id);
			request.setAttribute("_ERROR", "Brak usera o id=" + id);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/error.jsp");
			requestDispatcher.include(request, response);
		}
	}

	private Optional<User> getUserById(String id) {
		int userId = Integer.parseInt(id);
		return userDAO.getUserById(userId);
	}
}
