package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "paramView", value = "paramView")
public class ParamView extends HttpServlet
{

    private PrintWriter out;
    private Enumeration<String> attributeNames;
    private Enumeration<String> paramNames;
    private Enumeration<String> contextAtribute;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        ServletContext servletContext = request.getServletContext();

        attributeNames = request.getAttributeNames();
        paramNames = request.getParameterNames();
        contextAtribute = servletContext.getAttributeNames();

        out.println("<br>Request Attribute:<br>");
        while (attributeNames.hasMoreElements())
        {
            String tempAtribute = attributeNames.nextElement();
            out.println(tempAtribute + " = " +request.getAttribute(tempAtribute));
            out.println("<br>");
        }

        out.println("<br>Request Parameters:<br>");
        while (paramNames.hasMoreElements())
        {
            String tempParam = paramNames.nextElement();
            out.println(tempParam + " = " + request.getParameter(tempParam));
            out.println("<br>");
            servletContext.setAttribute(tempParam, request.getParameter(tempParam));
        }

        out.println("<br>Servlet Context Attribute:<br>");
        while (contextAtribute.hasMoreElements())
        {
            String tempContextAtribute = contextAtribute.nextElement();
            out.println(tempContextAtribute + " = " +servletContext.getAttribute(tempContextAtribute));
            out.println("<br>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
