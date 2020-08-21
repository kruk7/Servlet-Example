package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "permissonFilter", servletNames = "paramView")
public class PermissonFilter implements Filter
{
    private String deniedWord = "blokuj";
    private Enumeration<String> paramNames;

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        paramNames = req.getParameterNames();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        while (paramNames.hasMoreElements())
        {
            String reqParam = paramNames.nextElement();
            String paramVal = req.getParameter(reqParam);
            if (paramVal.equals("blokuj"))
            {
            //  ((HttpServletResponse) resp).setStatus(403);
                response.sendError(403);
                System.out.println(reqParam + paramVal);

            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {}
    public void destroy() {}
}
