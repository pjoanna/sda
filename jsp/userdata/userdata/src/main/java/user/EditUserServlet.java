package user;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class EditUserServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(AddUserServlet.class);

    private UserDAO userDAO = new UserDAO();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String errorMsg = "";
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        Integer userId = Integer.valueOf(id);
//
//        if (null == userId) {
//            errorMsg += "Nie podano parametru id.";
//        }
//
//        if (null == name || name.isEmpty()) {
//            errorMsg += "Nie podano parametru name.";
//        }
//        if (!errorMsg.isEmpty()) {
//            log.error(errorMsg);
//            request.setAttribute("_ERROR", errorMsg);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/edituser.html");
//            requestDispatcher.forward(request, response);
//            return;
//        }
//
//        boolean result = userDAO.editUser(userId, name);
//        if (!result) {
//            log.error("Problem z edycją usera o id=" + id + " i name=" + name);
//            request.setAttribute("_ERROR", "Problem z edycją usera o id=" + id + " i name=" + name);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/error.jsp");
//            requestDispatcher.forward(request, response);
//            return;
//        }
//
//        request.setAttribute("_OK", "Dodano usera o id=" + userId + " i name=" + name);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/users.html");
//        requestDispatcher.forward(request, response);
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Optional<User> optionalUser = getUserById(id);

        //log.debug("OptionalUser" + optionalUser);

        if (optionalUser.isPresent()) {
            request.setAttribute("user", optionalUser.get());

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/editUser.jsp");
            requestDispatcher.forward(request, response);
        } else {
            //	log.error("Brak usera o id=" + id);
            request.setAttribute("_ERROR", "Błąd przy edycji usera o id=" + id);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/error.jsp");
            requestDispatcher.include(request, response);
        }
    }

    private Optional<User> getUserById(String id) {
        int userId = Integer.parseInt(id);
        return userDAO.getUserById(userId);
    }

}
