package ga.veee.day23.control;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class MySessionFilter
 */
public class MySessionFilter implements Filter {
    public void destroy() {
        System.out.println("destroy filter called...");

    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponse hresponse = (HttpServletResponse) response;

        HttpSession session = hrequest.getSession();
        if (session.isNew()) {
            String formId = request.getParameter("formId");
            if (formId.equals("lang")) {
                chain.doFilter(request, response);
            } else {
                hresponse.sendRedirect("session-expired.jsp");
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("init filter called...");
    }
}