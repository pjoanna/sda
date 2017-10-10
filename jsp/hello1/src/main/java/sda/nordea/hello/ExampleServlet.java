package sda.nordea.hello;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class ExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("/index.jsp");// -- przekierowanie
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
//        dispatcher.forward(req,resp);

        RequestDispatcher dispatcher = req.getRequestDispatcher("add1.jsp");
        dispatcher.include(req,resp);

        LocalDateTime now = LocalDateTime.now();
        req.setAttribute("now", now);

        RequestDispatcher dispatcher2 = req.getRequestDispatcher("add2.jsp");
        dispatcher2.include(req,resp);

    }
}
