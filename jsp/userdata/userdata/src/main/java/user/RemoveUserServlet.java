package user;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Slf4j
public class RemoveUserServlet extends HttpServlet {

	private UserDAO userDAO = new UserDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorMsg = "";
		String id = request.getParameter("id");
		Integer userId = Integer.valueOf(id);
		if (null == userId) {
			errorMsg += "Nie podano parametru id.";
		}

		if (!errorMsg.isEmpty()) {
	//		log.error(errorMsg);
			request.setAttribute("_ERROR", errorMsg);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/users.html");
			requestDispatcher.forward(request, response);
			return;
		}

		boolean result = userDAO.removeUser(userId);
		if (!result) {
	//		log.error("Problem z usunieciem usera o id=" + id);
			request.setAttribute("_ERROR", "Problem z usunieciem usera o id=" + id);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/error.jsp");
			requestDispatcher.forward(request, response);
			return;
		}

		request.setAttribute("_OK", "Usunieto usera o id=" + userId);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/users.html");
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}
