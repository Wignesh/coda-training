package ga.veee.day21.MVC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class RequestProcessor {
    private RequestProcessor() {
    }

    private static ThreadLocal<RequestProcessor> threadLocal = new ThreadLocal<>();
    private static RequestProcessor requestProcessor;

    synchronized public static RequestProcessor getInstance() {
        requestProcessor = threadLocal.get();
        if (requestProcessor == null) {
            System.out.println("New Instance");
            try {
                requestProcessor = new RequestProcessor();
                threadLocal.set(requestProcessor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return requestProcessor;
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Enumeration<String> params = request.getParameterNames();
//        while (params.hasMoreElements()) {
//            String param = params.nextElement();
//            System.out.println(param);
//            System.out.println(request.getParameter(param));
//        }
        String form = request.getParameter("formId");
        if (form != null) {
            switch (form) {
                case "Login":
                    new LoginAction().execute(request, response);
                    break;
                case "Logout":
                    new LogoutAction().execute(request, response);
                    break;
                case "Signup":
                    new SignupAction().execute(request, response);
                    break;
            }
        }
    }
}
