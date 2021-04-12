package ga.veee.day23.control;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LangAction extends Action {
    public LangAction(Properties dbConfigProp) {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String language = request.getParameter("language");
        ResourceBundle rb = ResourceBundle.getBundle("ga.veee.day23.control.Dictionary", new Locale(language));
        HttpSession session = request.getSession();
        session.setAttribute("rb", rb);
        session.setAttribute("lang", language);
        return "lang.success";
    }
}
