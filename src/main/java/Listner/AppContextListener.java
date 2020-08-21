package Listner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@WebListener()
public class AppContextListener implements ServletContextAttributeListener
{

    private Enumeration<String> contextAtributes;
    private List<String> allAtributes;

    @Override
    public void attributeAdded(ServletContextAttributeEvent event)
    {
        String newAtribute = event.getName();
        String now = LocalDateTime.now().toString();
        String newAtributeDateName = newAtribute.concat(".when");

        ServletContext context = event.getServletContext();
        contextAtributes = context.getAttributeNames();
        allAtributes = Collections.list(contextAtributes);


        if (event.getName().endsWith(".when"))
            return;
        else
        context.setAttribute(newAtributeDateName, now);

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent)
    {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent)
    {

    }
}
