package com.apress.apachetomcat7.chapter3;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Aleksa Vukotic
 */
public class HelloWorldServlet extends HttpServlet {
    private String message;
    private Integer count;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.message = config.getInitParameter("message");
        this.count = Integer.parseInt(config.getInitParameter("count"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + this.message + "</title>");
        out.println("</head>");
        out.println("<body>");
        for (int i = 0; i < count; i++) {
            out.println("<h1>" + message + "</h1>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}