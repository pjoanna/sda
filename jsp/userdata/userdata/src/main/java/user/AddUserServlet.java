package user;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Slf4j
public class AddUserServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(AddUserServlet.class);

	private UserDAO userDAO = new UserDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorMsg = "";
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer userId = Integer.parseInt(id);
		if (null == userId) {
			errorMsg += "Nie podano parametru id.";
		}

		if (null == name || name.isEmpty()) {
			errorMsg += "Nie podano parametru name.";
		}
		if (!errorMsg.isEmpty()) {
			log.error(errorMsg);
			request.setAttribute("_ERROR", errorMsg);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adduser.html");
			requestDispatcher.include(request, response);
			return;
		}

		boolean result = userDAO.addUser(userId, name);
		if (!result) {
			log.error("Problem z dodaniem usera o id=" + id + " i name=" + name);
			request.setAttribute("_ERROR", "Problem z dodaniem usera o id=" + id + " i name=" + name);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/error.jsp");
			requestDispatcher.include(request, response);
			return;
		}

		request.setAttribute("_OK", "Dodano usera o id=" + userId + " i name=" + name);
		request.setAttribute("newUser", userId);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/users.html"); //html, jsp?
		requestDispatcher.include(request, response);
	}
}
