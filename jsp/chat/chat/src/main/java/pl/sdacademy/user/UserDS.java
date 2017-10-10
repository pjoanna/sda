package pl.sdacademy.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class UserDS extends HttpServlet {

	private UserDAO userDAO = new UserDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int i = Integer.parseInt(id);
		Optional<User> userById = userDAO.getUserById(i);

		if (userById.isPresent()) {
			request.setAttribute("user", userById.get());
		}

		RequestDispatcher view = request.getRequestDispatcher("/user.jsp");
		view.include(request, response);
	}
}
