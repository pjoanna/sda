package user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class EditUserFormServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Optional<User> optionalUser = getUserById(id);
        if (optionalUser.isPresent()) {
            req.setAttribute("user", optionalUser.get());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/editUser.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            //	log.error("Brak usera o id=" + id);
            req.setAttribute("_ERROR", "Brak usera o id=" + id);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/error.jsp");
            requestDispatcher.include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/editUser.jsp");
        requestDispatcher.include(req, resp);
    }

    private  Optional<User> getUserById(String id) {
        int userId = Integer.parseInt(id);
        return userDAO.getUserById(userId);
    }
}
