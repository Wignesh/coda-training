package ga.veee.day21.MVC;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Controller extends HttpServlet {

    RequestProcessor requestProcessor;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.requestProcessor = RequestProcessor.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Controller");
        requestProcessor.processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
