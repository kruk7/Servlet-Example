package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AddAttributeY", servletNames = "paramView")
public class AddAttributeY implements Filter
{

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        req.setAttribute("loop", 1);
        chain.doFilter(req, resp);
    }

    public void destroy() {}
    public void init(FilterConfig config) throws ServletException {}

}
