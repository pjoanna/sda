package sda.nordea.hello;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet",
        urlPatterns = {"/hello", "/Hello"},
        initParams = {
                @WebInitParam(name = "who", value = "i świat od razu jest piękniejszy"),
                @WebInitParam(name = "times", value = "8")
        },
        loadOnStartup = 1)

public class HelloServlet extends HttpServlet {

    private String who;
    private int times;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.who = getInitParameter("who");
        this.times = Integer.parseInt(getInitParameter("times"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        for (int i = 0; i < times; i++) {
            out.println(who);
        }

    }

}
