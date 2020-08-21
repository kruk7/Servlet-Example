package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AddAttributeX", servletNames = "paramView")
public class AddAttributeX implements Filter
{
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        req.setAttribute("lang", "PL");
        chain.doFilter(req, resp);
    }

    public void destroy() {}
    public void init(FilterConfig config) throws ServletException {}
}
