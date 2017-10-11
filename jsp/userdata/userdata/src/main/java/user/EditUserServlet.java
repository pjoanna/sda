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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorMsg = "";
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        Integer userId = Integer.valueOf(id);
        String oldName = name;
        if (null == userId) {
            errorMsg += "Nie podano parametru id.";
        }

        if (null == name || name.isEmpty()) {
            errorMsg += "Nie podano parametru name.";
        }
        if (!errorMsg.isEmpty()) {
//            log.error(errorMsg);
            request.setAttribute("_ERROR", errorMsg);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/edituser.html");
            requestDispatcher.forward(request, response);
            return;
        }
        
        Optional<User> userById = userDAO.getUserById(userId);
        if (userById.isPresent()){
             oldName = userById.get().getName();
        }

        boolean result = userDAO.editUser(userId, name);
        if (!result) {
//            log.error("Problem z dodaniem usera o id=" + id + " i name=" + name);

            request.setAttribute("_ERROR", "Problem z edycją usera o id=" + id + " i name=" + name);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/error.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        if (oldName.equals(name)){
            request.setAttribute("_OK", "User o id=" + userId + " i name=" + name+ " nie zmienił imienia");
        }else {
            request.setAttribute("_OK", "Edytowano usera o id=" + userId + " i name=" + name + " (stare imie: " + oldName + ")");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/users.html");
        requestDispatcher.forward(request, response);
    }

}
