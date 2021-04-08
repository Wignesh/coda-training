package ga.veee.day22.control;

import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcessor {
    public void process(HttpServletRequest request, HttpServletResponse response) {
        try {
            Properties configProp = (Properties) request.getServletContext().getAttribute("configProp");
            Properties dbConfigProp = (Properties) request.getServletContext().getAttribute("dbConfigProp");
            String formid = request.getParameter("formid");
            String actionClass = configProp.getProperty(formid);

            Action action = (Action) Class.forName(actionClass).getConstructor(Properties.class).newInstance(dbConfigProp);
            String result = action.execute(request, response);

            String nextPage = configProp.getProperty(result);
            response.sendRedirect(nextPage);
//            RequestDispatcher rd = request.getRequestDispatcher(nextPage);
//
//            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
