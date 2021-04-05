package ga.veee.Day20;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

//@WebServlet(name = "Hello", value = "/Hello")
public class Hello extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init method called...............");
        String s = config.getInitParameter("myparam");
        System.out.println("Param value of myparam is...:" + s);
        System.out.println(config.getInitParameter("dbconfig"));
        Enumeration<String> e = config.getInitParameterNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = config.getInitParameter(name);
            System.out.println(name + ":" + value);
        }
        System.out.println("Name of the servlet..:" + config.getServletName());
        ServletContext application = config.getServletContext();
        System.out.println(application.getRealPath(""));
        application.setAttribute("global", "global value...............");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get Method");
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            System.out.printf("%s : %s\n", param, request.getParameter(param));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post Called");
        doGet(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy called");
    }
}
