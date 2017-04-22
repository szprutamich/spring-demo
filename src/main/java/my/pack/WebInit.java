package my.pack;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(MyConfig.class);
        container.addListener(new ContextLoaderListener(appContext));

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        switch (ConfigurationBase.CONFIG) {
            case JAVA:
                webContext.register(MyServletConfigJava.class);
                break;
            case XML:
                webContext.register(MyServletConfigXml.class);
                break;
        }
        ServletRegistration.Dynamic spring = container.addServlet("spring", new DispatcherServlet(webContext));
        spring.setLoadOnStartup(1);
        spring.addMapping("/");
    }
}
