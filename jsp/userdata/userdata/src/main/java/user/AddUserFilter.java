//package user;
//
//import javax.servlet.*;
//import java.io.IOException;
//
//public class AddUserFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("filtr!!");
//       // filterChain.doFilter(servletRequest,servletResponse);
//        System.out.println("zaraz przekieruję..");
//        servletRequest.getRequestDispatcher("/users.html").forward(servletRequest,servletResponse);
//        System.out.println("po przekierowaniu");
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
