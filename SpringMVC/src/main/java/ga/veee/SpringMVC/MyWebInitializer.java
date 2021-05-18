package ga.veee.SpringMVC;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext wctx = new AnnotationConfigWebApplicationContext();
        wctx.register(SpringConfig.class);
        wctx.setServletContext(servletContext);

        ServletRegistration.Dynamic dispatcherServlet =
                servletContext.addServlet("dispatcher", new DispatcherServlet(wctx));

        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

    }
}
