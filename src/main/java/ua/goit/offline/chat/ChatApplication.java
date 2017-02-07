package ua.goit.offline.chat;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by andreymi on 2/7/2017.
 */
public class ChatApplication implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("/WEB-INF/application-context.xml");

        ServletRegistration.Dynamic reg = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        reg.setLoadOnStartup(1);
        reg.addMapping("/");

        /*DelegatingFilterProxy filter = new DelegatingFilterProxy("springSecurityFilterChain");
        filter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
        servletContext.addFilter("springSecurityFilterChain", filter).addMappingForUrlPatterns(null, false, "/*");*/
    }
}
