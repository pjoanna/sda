package user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class EditUserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");


        Optional<User> optionalUser = getUserById(id);

        if (optionalUser.isPresent()) {

            optionalUser.get().setName(name);
            boolean result = userDAO.editUser(optionalUser.get());
            if (!result) {
//                log.error("Problem z dodaniem usera o id=" + id + " i name=" + name);
//                request.setAttribute("_ERROR", "Problem z dodaniem usera o id=" + id + " i name=" + name);
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/error.jsp");
//                requestDispatcher.forward(request, response);
//                return;
            }

        }


        req.setAttribute("_OK", "Edytowano usera o id=" + id + ": zmieniono imię na: " + name);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/users.html");
        requestDispatcher.forward(req, resp);

    }

    private Optional<User> getUserById(String id) {
        int userId = Integer.parseInt(id);
        return userDAO.getUserById(userId);
    }
}

