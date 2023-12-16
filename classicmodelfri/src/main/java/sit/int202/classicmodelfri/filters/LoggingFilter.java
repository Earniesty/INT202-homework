package sit.int202.classicmodelfri.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "LoggingFilter", servletNames = {"AddToCartServlet", "OfficeListServlet", "ProductListServlet"})
public class LoggingFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long before = System.currentTimeMillis();
        // before invoke resources
        chain.doFilter(request, response);
        // after invoke resources
        long duration = System.currentTimeMillis();
        String msg = "Resource: " + ((HttpServletRequest) request).getRequestURI() +
                ", execution time: " + duration + "milliSecond";
        config.getServletContext().log(msg);
    }

    @Override
    public void destroy() {
    }


}