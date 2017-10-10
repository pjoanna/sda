package filtry;

import javax.servlet.*;
import java.io.IOException;

public class CounterPageFilter implements Filter {

    private long counter = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        filterChain.doFilter(servletRequest,servletResponse);
        ++counter;
        System.out.println("Ilość wyświetleń = " + counter);
    }

    @Override
    public void destroy() {

    }
}
