package filtry;
import javax.servlet.*;
import java.io.IOException;

public class PageFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        System.out.println("Start: " + start);
        chain.doFilter(req, resp);

        long end = System.currentTimeMillis();
        System.out.println("End: " + end);
        System.out.println("Time: " + (end-start));
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
